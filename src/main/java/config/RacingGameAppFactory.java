package config;

import domain.RacingGame;
import application.RacingGameApplication;
import utils.ExceptionHandler;
import utils.NumberGenerator;
import utils.RandomNumberGenerator;
import view.InputView;
import view.InputViewImpl;
import view.OutputView;
import java.lang.reflect.Proxy;

public class RacingGameAppFactory {

    private RacingGameAppFactory() {
        throw new IllegalStateException("인스턴스화 할 수 없는 클래스입니다.");
    }

    public static RacingGameApplication generate() {
        return new RacingGameApplication(initInputView(), initOutputView(), initRacingGame());
    }

    private static InputView initInputView() {
        InputView inputView = new InputViewImpl();
        InputView inputViewRetry = (InputView) Proxy.newProxyInstance(InputView.class.getClassLoader(),
                new Class[]{InputView.class},
                new ExceptionHandler(inputView));
        return inputViewRetry;
    }

    private static OutputView initOutputView() {
        return new OutputView();
    }

    private static RacingGame initRacingGame() {
        return new RacingGame(initNumberGenerator());
    }

    private static NumberGenerator initNumberGenerator() {
        return new RandomNumberGenerator();
    }
}
