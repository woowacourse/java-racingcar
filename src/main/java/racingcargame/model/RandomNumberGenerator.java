package racingcargame.model;

public class RandomNumberGenerator {
    public static int generateRandomNumber() {
        int random = (int) (Math.random() * 10);
        int randomNumber  = 0;
        if (random >= 4) {
            randomNumber = 1;
        }
        return randomNumber;
    }

}
