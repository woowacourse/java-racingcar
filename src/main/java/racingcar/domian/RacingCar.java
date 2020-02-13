package racingcar.domian;

import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCar {
    private static final int ZERO = 0;
    private static final int COUNT_LOWER_LIMIT = 1;
    private static final int COUNT_UPPER_LIMIT = 10;
    private Cars cars;

    public void run() {
        setUp(inputPlayerInfo());
        int round = inputGameRound();
        OutputView.printNotice();
        startGame(round);
        OutputView.printResult(getResult());
    }

    private String getResult() {
        return cars.getResult();
    }

    private String inputPlayerInfo() {
        return InputView.inputCarName();
    }

    private void setUp(String names) {
        cars = new Cars(names);
    }

    private int inputGameRound() {
        return validateRound(InputView.inputGameRound());
    }

    private void startGame(int round) {
        for (int i = ZERO; i < round; i++) {
            cars.moveAll();
            OutputView.printCurrentRound(cars.getCars());
        }
    }

    private static int validateRound(String inputRound) {
        int round = validateNumber(inputRound.trim());
        validateCount(round);
        return round;
    }

    private static void validateCount(int count) {
        if (count < COUNT_LOWER_LIMIT || count > COUNT_UPPER_LIMIT) {
            throw new IllegalArgumentException("횟수가 1보다 작거나 10번 초과입니다!");
        }
    }

    private static int validateNumber(String input) {
        int count;
        try {
            count = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 횟수 입력");
        }
        return count;
    }
}
