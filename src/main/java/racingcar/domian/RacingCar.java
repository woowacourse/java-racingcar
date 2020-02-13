package racingcar.domian;

import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCar {
    private static final int ZERO = 0;
    private static final int COUNT_LOWER_LIMIT = 1;
    private static final int COUNT_UPPER_LIMIT = 10;
    private Cars cars;
    private int round;

    public void setUpPlayer() {
        cars = new Cars(InputView.inputCarName());
    }

    public void setUpRound() {
        round = validateRound(InputView.inputGameRound());
    }

    private int validateRound(String inputRound) {
        int round = validateNumber(inputRound.trim());
        validateCount(round);
        return round;
    }

    private int validateNumber(String input) {
        int count;
        try {
            count = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 횟수 입력");
        }
        return count;
    }

    private void validateCount(int count) {
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
