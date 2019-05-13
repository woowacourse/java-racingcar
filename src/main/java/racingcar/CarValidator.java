package racingcar;

public class CarValidator {
    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = 5;
    private static final int MIN_NUM_OF_GAME = 1;

    public static void checkCarNames(String userInput) {
        String[] carNames = userInput.split(",");

        if (carNames.length < MIN_LENGTH) {
            System.err.println("자동차 이름을 1~5글자로 입력해주세요.");
            throw new IllegalArgumentException();
        }

        for (String carName : carNames) {
            int nameLength = carName.trim().length();
            if (nameLength < MIN_LENGTH || nameLength > MAX_LENGTH) {
                System.err.println("자동차 이름을 1~5글자로 입력해주세요.");
                throw new IllegalArgumentException();
            }
        }
    }

    public static void checkNumberOfGame(int numOfGame) {
        if (numOfGame < MIN_NUM_OF_GAME) {
            System.err.println("자연수만 입력 가능합니다.");
            throw new IllegalArgumentException();
        }
    }
}
