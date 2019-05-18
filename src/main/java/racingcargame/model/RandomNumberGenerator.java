package racingcargame.model;

public class RandomNumberGenerator {
    private static final int STOP_OR_GO = 4;
    private static final int STOP = 0;
    private static final int GO = 1;


    public static int generateRandomNumber() {
        int random = (int) (Math.random() * 10);
        int randomNumber  = STOP;
        if (random >= STOP_OR_GO) {
            randomNumber = GO;
        }
        return randomNumber;
    }

}
