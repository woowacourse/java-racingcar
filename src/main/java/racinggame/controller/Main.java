package racinggame.controller;

import racinggame.domain.game.RacingGame;
import racinggame.domain.data.GameStatus;
import racinggame.domain.data.Names;
import racinggame.domain.data.Repeat;
import racinggame.view.InputView;
import racinggame.view.OutputView;

/**
 * Main 클래스는 메인 로직의 최상위 운영을 담당하는 클래스이다.
 * Input,Output 객체의 인스턴스를 보유하고,
 * 이를 RacingGame 클래스에 전달하여 게임을 진행한다.
 * 프로그램이 시작하는 main 메서드를 가지고 있다.
 */
public class Main {
    public static void main(String... args) {
        Names names = new Names(InputView.inputName());
        Repeat repeat = new Repeat(InputView.inputRepeat());
        GameStatus gameStatus = new GameStatus(names.splitNamesByComma());

        RacingGame racingGame = new RacingGame(names);
        OutputView.printResultFormat();

        for(int repeatIterator = 0; repeat.isLoopDone(repeatIterator); repeatIterator++){
            racingGame.moveCars(gameStatus);
            OutputView.printLog(gameStatus.getStatusLog());
        }
        gameStatus.makeWinnerNames();
        OutputView.printWinners(gameStatus.getWinnerNames());
    }
}

