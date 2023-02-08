package racingcar.controller;

import racingcar.view.InputView;

import java.util.InputMismatchException;
import java.util.List;

public class RacingCarController {

    public void run() {
        initCarNames();
        initTries();
    }
    //,를 제거했을 때 빈 리스트가 되는 경우 예외 처리한다.
    //플레이어가 1명 이하인 경우 예외 처리한다.
    private void initCarNames() {
        String input = InputView.inputCarNames();

        List<String> carNames = splitCarNames(input);
        //레포지토리에서 차 객체를 생성한다.
        //car 레포에 전달.
    }

    private List<String> splitCarNames(String input) {
        return List.of(input.split(","));
    }

    private void initTries() {
        try{
            int input = InputView.inputTries();
            // 게임 도메인에 값 전달하기
        } catch (InputMismatchException e) {
            initTries();
        }
    }
}
