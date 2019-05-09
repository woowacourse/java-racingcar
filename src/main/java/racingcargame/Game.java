package racingcargame;

import racingcargame.model.Result;
import racingcargame.view.InputView;
import racingcargame.view.OutputView;

import java.io.IOException;

public class Game {
    InputView inputView;
    OutputView outputView;
    Result result;
    int countOfRound;

    private final String ROUND_RESULT = "실행 결과";

    public Game(){
        this.inputView = new InputView();
    }

    public void play() throws IOException {
        start();
        round();
    }

    void start() throws IOException {
        String names = inputView.readNames();
        result = new Result(names.split(","));
    }

    void round(){
        System.out.println(ROUND_RESULT);
        for (int i = 0 ; i < countOfRound; i++){
            outputView.printRound(result.roundResult());
        }
    }

}