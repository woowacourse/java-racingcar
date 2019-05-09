package racingcar;

public class Validator {
    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = 5;
    private static final int MIN_NUM_OF_GAME = 1;

    public static void checkCarNames(String userInput) {
        String[] carNames = userInput.split(",");
        if (carNames.length < MIN_LENGTH) {
            throw new IllegalArgumentException();
        }
        for (String carName : carNames) {
            int nameLength = carName.trim().length();
            if (nameLength < MIN_LENGTH || nameLength > MAX_LENGTH) {
                throw new IllegalArgumentException();
            }
        }
    }

    public static void checkNumberOfGame(int numOfGame) {
        if (numOfGame < MIN_NUM_OF_GAME) {
            throw new IllegalArgumentException();
        }
    }
}
