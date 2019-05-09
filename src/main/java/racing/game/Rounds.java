package racing.game;


public class Rounds {
    private static final int BOUNDARY = 4;


    private static int getRandomValue() {

        return (int) (Math.random() * 10);
    }

    public static boolean canMove(int randomValue) {
        if (randomValue >= BOUNDARY) {
            return true;
        }
        return false;
    }


}
