package racinggame.controller;

import racinggame.domain.RacingGame;
import racinggame.view.Input;
import racinggame.view.Output;

public class RacingGameController {
    private String[] carNames;
    private int tryCount;
    private RacingGame racingGame;

    public void run() {
        init();
        racingGame = new RacingGame(this.carNames, this.tryCount);
        racingGame.run();
    }

    private void init(){
        Output.printMessage("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        this.carNames = Input.getCarNames(Input.getInput());
        Output.printMessage("시도할 회수는 몇회인가요?");
        this.tryCount = Input.getTryCount(Input.getInput());
    }

    private void printResult(){
        Output.printMessage("실행 결과");
        Output.printWinner(racingGame.getWinner());
    }
}
