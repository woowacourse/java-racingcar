package racingcar;

import racingcar.utils.SplitUtil;
import racingcar.view.InputView;

import java.util.List;

public class RacingCarGame {
    public RacingCarGame() {
    }

    public void start() {
        String carNamesInput = InputView.getCarNamesInput();
        List<String> splittedCarNames = SplitUtil.splitCarNames(carNamesInput);
        CarNameRepository.addCarNames(splittedCarNames);
    }
}
