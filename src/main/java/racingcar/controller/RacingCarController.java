package racingcar.controller;

import racingcar.view.InputView;

import java.util.List;

public class RacingCarController {

    private void run() {
    }
    //,를 제거했을 때 빈 리스트가 되는 경우 예외 처리한다.
    //플레이어가 1명 이하인 경우 예외 처리한다.
    private List<String> initCarNames() {
        String input = InputView.inputCarNames();
        return splitCarNames(input);
    }

    private List<String> splitCarNames(String input) {
        return List.of(input.split(","));
    }

}
