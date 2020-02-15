package racingcar.domian;

import racingcar.view.OutputView;

public class RacingCar {
    private static final int ZERO = 0;
    private static final int COUNT_LOWER_LIMIT = 1;
    private static final int COUNT_UPPER_LIMIT = 10;

    private Cars cars;
    private int round;

    public RacingCar(String names, String round) {
        this.cars = new Cars(names);
        this.round = validateRound(round);
    }

    private static int validateRound(String inputRound) {
        inputRound = validateNullOrEmpty(inputRound);
        int round = validateNumber(inputRound);
        validateCount(round);
        return round;
    }

    private static String validateNullOrEmpty(String inputRound) {
        if (inputRound == null || (inputRound = inputRound.trim()).isEmpty()) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
        return inputRound;
    }

    private static int validateNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 횟수 입력");
        }
    }

    private static void validateCount(int count) {
        if (count < COUNT_LOWER_LIMIT || count > COUNT_UPPER_LIMIT) {
            throw new IllegalArgumentException("횟수가 1보다 작거나 10번 초과입니다!");
        }
    }

    public void startGame() {
        for (int i = ZERO; i < round; i++) {
            cars.moveAll();
            OutputView.printCurrentRound(cars.getCars());
        }
    }

    public String getResult() {
        return cars.getResult();
    }
}
