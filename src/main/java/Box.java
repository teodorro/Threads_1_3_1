public class Box extends Sleepable implements Runnable {
    private Game game;

    public Box(Game game) {
        this.game = game;
    }

    @Override
    public void run() {
        while(true){
            if (game.isBoxIsOpened()) {
                game.setBoxIsOpened(false);
                System.out.println("closed\n");
            }
            sleep(Game.CHECK_GAP);
            if (Thread.interrupted())
                break;
        }
    }
}
