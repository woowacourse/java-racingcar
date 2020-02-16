package racinggame.controller;

import racinggame.domain.game.RacingGame;
import racinggame.domain.data.GameStatus;
import racinggame.domain.data.Names;
import racinggame.domain.data.Repeat;
import racinggame.view.InputView;
import racinggame.view.OutputView;

/**
 * Application 클래스는 메인 로직의 최상위 운영을 담당하는 클래스이다.
 * 컨트롤러의 역할도 맡아, 뷰와 도메인 사이에서 값을 전달한다.
 * 프로그램이 시작하는 main 메서드를 가지고 있다.
 */
public class Application {
    public static void main(String... args) {
        Names names = new Names(InputView.inputName());
        Repeat repeat = new Repeat(InputView.inputRepeat());
        GameStatus gameStatus = new GameStatus(names.splitNamesByComma());

        RacingGame racingGame = new RacingGame(names);
        OutputView.printResultFormat();

        for (int repeatIterator = 0; repeat.isLoopDone(repeatIterator); repeatIterator++) {
            racingGame.moveCars(gameStatus);
            OutputView.printLog(gameStatus.getStatusLog());
        }
        gameStatus.makeWinnerNames();
        OutputView.printWinners(gameStatus.getWinnerNames());
    }
}

