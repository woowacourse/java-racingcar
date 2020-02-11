package racingcar;

import racingcar.view.InputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        System.out.println(inputView.EnterCarNames());
    }
}
