public class Game {
    public static final Integer ROUNDS_NUMBER = 5;
    public static final Integer SET_GAP = 2000;
    public static final Integer CHECK_GAP = 20;

    private volatile boolean boxIsOpened;

    public boolean isBoxIsOpened() {
        return boxIsOpened;
    }

    public void setBoxIsOpened(boolean boxIsOpened) {
        this.boxIsOpened = boxIsOpened;
    }

    public void start()  {
        try {
            Thread box = new Thread(null, new Box(this), "box");
            Thread user = new Thread(null, new User(this), "user");
            box.start();
            user.start();

            user.join();
            box.interrupt();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
