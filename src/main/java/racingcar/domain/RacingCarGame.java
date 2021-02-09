package racingcar.domain;

import racingcar.view.OutputView;

public class RacingCarGame {
    private static final String NUMERIC_REGULAR_EXPRESSION = "\\d+";
    private static final String NOT_NUMERIC_ERROR_MESSAGE = "숫자를 입력하세요.";
    private static final String NOT_OVER_ONE_ERROR_MESSAGE = "1 이상의 숫자를 입력하세요.";

    private final Cars cars;
    private final int laps;

    public RacingCarGame(Cars cars, String lapInput) {
        this.laps =validateLaps(lapInput);
        this.cars =cars;
    }

    public int validateLaps(String lapInput) {
        if (!lapInput.matches(NUMERIC_REGULAR_EXPRESSION)) {
            throw new IllegalArgumentException(NOT_NUMERIC_ERROR_MESSAGE);
        }

        int laps = Integer.parseInt(lapInput);
        if (laps < 1) {
            throw new IllegalArgumentException(NOT_OVER_ONE_ERROR_MESSAGE);
        }
        return laps;
    }

    public void race() {
        OutputView.showResult();
        for (int i = 0; i < laps; i++) {
            cars.raceOneLap();
            OutputView.showOneLapResult(cars);
        }
    }

}
