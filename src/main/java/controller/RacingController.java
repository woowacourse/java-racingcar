package controller;

import model.Car;
import model.MovableStrategy;
import model.Racing;
import view.InputView;
import view.OutputView;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.IntStream;

public class RacingController {
    
    public static final int START_POSITION = 0;

    private final InputView inputView;
    private final OutputView outputView;

    public RacingController() {
        inputView = new InputView(System.in);
        outputView = new OutputView();
    }

    public void racingStart() {
        List<String> carNames = inputView.inputCarNames();
        LinkedHashMap<MovableStrategy, Integer> scoreBoard = new LinkedHashMap<>();
        carNames.forEach(name -> scoreBoard.put(new Car(name), START_POSITION));

        Racing racing = new Racing(scoreBoard);
        int numberOfTimes = inputView.inputRepeatCount();
        process(racing, numberOfTimes);
        end(racing);
    }

    private void process(Racing racing, int numberOfTimes) {
        outputView.resultHeader();
        IntStream.range(0, numberOfTimes).forEach(i -> eachProcess(racing));
    }

    private void eachProcess(Racing racing) {
        racing.moveAll();
        outputView.result(racing);
    }

    private void end(Racing racing) {
        outputView.result(racing);
        outputView.winner(racing.getWinner());
    }
}

