package racingcar;

import racingcar.controller.RacingController;
import racingcar.model.car.strategy.MovingStrategy;
import racingcar.model.car.strategy.RandomMovingStrategy;
import racingcar.view.inputview.KoreanInputView;
import racingcar.view.outputview.KoreanOutputView;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        KoreanInputView koreanInputView = new KoreanInputView(scanner);
        KoreanOutputView koreanOutputView = new KoreanOutputView();
        MovingStrategy randomMovingStrategy = new RandomMovingStrategy();
        RacingController racingController = new RacingController(koreanInputView, koreanOutputView);

        racingController.start(randomMovingStrategy);
    }
}
