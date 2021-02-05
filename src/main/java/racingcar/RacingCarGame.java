package racingcar;

import racingcar.utils.SplitUtil;
import racingcar.view.InputView;

import java.util.List;

public class RacingCarGame {
    private static final String NUMERIC_REGULAR_EXPRESSION = "\\d+";
    private static final String NOT_NUMERIC_ERROR_MESSAGE = "숫자를 입력하세요.";
    private static final String NOT_OVER_ONE_ERROR_MESSAGE = "1 이상의 숫자를 입력하세요.";

    public RacingCarGame() {
    }

    public void start() {
        String carNamesInput = InputView.getCarNamesInput();
        List<String> splittedCarNames = SplitUtil.splitCarNames(carNamesInput);
        CarRepository.addCars(splittedCarNames);
        String lapInput = InputView.getLap();
        int laps = validateLaps(lapInput);
        race(laps);
    }

    public int validateLaps(String lapInput){
        if(!lapInput.matches(NUMERIC_REGULAR_EXPRESSION)) {
            throw new IllegalArgumentException(NOT_NUMERIC_ERROR_MESSAGE);
        }
        int laps = Integer.parseInt(lapInput);

        if(laps < 1) {
            throw new IllegalArgumentException(NOT_OVER_ONE_ERROR_MESSAGE);
        }
        return laps;
    }

    private void race(int laps) {
        for (int i = 0; i < laps; i++) {
            CarRepository.raceOneLap();
        }
    }
}
