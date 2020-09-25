public class User extends Sleepable implements Runnable {
    private Game game;

    public User(Game game) {
        this.game = game;
    }

    @Override
    public void run() {
        sleep();
        for (int i = 0; i < Game.ROUNDS_NUMBER; i++) {
            game.setBoxIsOpened(true);
            System.out.println("opened");
            sleep(Game.SET_GAP);
        }
    }
}
