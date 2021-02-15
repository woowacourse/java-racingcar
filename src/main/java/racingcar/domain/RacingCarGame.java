package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import racingcar.utils.RandomUtil;
import racingcar.view.OutputView;

public class RacingCarGame {
    private static final String NUMERIC_REGULAR_EXPRESSION = "\\d+";
    private static final String NOT_NUMERIC_ERROR_MESSAGE = "숫자를 입력하세요.";
    private static final String NOT_OVER_ONE_ERROR_MESSAGE = "1 이상의 숫자를 입력하세요.";
    private static final int MINIMUM_LAP_COUNT = 1;
    private static final int START = 0;
    private static final int END = 9;

    private final Cars cars;
    private final int laps;

    public RacingCarGame(List<String> carNames, String lapInput) {
        this.laps = validateLaps(lapInput);
        this.cars = new Cars(carNames);
    }

    public int validateLaps(String lapInput) {
        if (!lapInput.matches(NUMERIC_REGULAR_EXPRESSION)) {
            throw new IllegalArgumentException(NOT_NUMERIC_ERROR_MESSAGE);
        }

        int laps = Integer.parseInt(lapInput);
        if (laps < MINIMUM_LAP_COUNT) {
            throw new IllegalArgumentException(NOT_OVER_ONE_ERROR_MESSAGE);
        }
        return laps;
    }

    public void race() {
        OutputView.showResult();
        for (int i = 0; i < laps; i++) {
            cars.raceOneLap(createRandomNumbers());
            OutputView.showOneLapResult(cars);
        }
    }

    private List<Integer> createRandomNumbers() {
        List<Integer> counts = new ArrayList<>();
        for (int i = 0; i < cars.getCarsSize(); i++) {
            counts.add(RandomUtil.nextInt(START, END));
        }
        return counts;
    }

    public List<String> getWinners() {
        return cars.getWinners();
    }

}
