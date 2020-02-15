package racingcar.domian;

import racingcar.util.IntegerUtils;
import racingcar.util.StringUtils;
import racingcar.view.OutputView;

public class RacingCar {
    private static final int ZERO = 0;
    private static final int COUNT_LOWER_LIMIT = 1;
    private static final int COUNT_UPPER_LIMIT = 10;

    private Cars cars;
    private int round;

    public RacingCar(String names, String round) {
        this.cars = new Cars(names);
        this.round = validRound(round);
    }

    private static int validRound(String inputRound) {
        inputRound = StringUtils.validNullOrEmpty(inputRound);
        int round = IntegerUtils.stringToInt(inputRound);
        validCount(round);
        return round;
    }

    private static void validCount(int count) {
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
