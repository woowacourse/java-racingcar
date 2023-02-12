package car.controller;

import static car.option.Option.MIN_TRIAL_COUNT;

import java.util.List;
import java.util.stream.Collectors;

import car.domain.Car;
import car.domain.Game;
import car.domain.RandomMoveChance;
import car.view.Input;
import car.view.InputConsole;
import car.view.InputView;
import car.view.OutputView;

public class GameController {

    private final InputView inputView;
    private static final OutputView outputView = new OutputView();

    private Game game;
    private int trialCount;
    public GameController(Input input){
        this.inputView = new InputView(input);
    }
    public void startGame() {
        makeGame();
        makeTrialCount();
    }
    private void makeGame(){
        game = new Game(makeCarsWith(makeCarNameList()), new RandomMoveChance());
    }
    private List<String> makeCarNameList() {
        return List.of(inputView.inputCarNames());
    }

    private void makeTrialCount() {
        trialCount = inputView.inputTrialCount();
        validateNotNegativeInteger(trialCount);
    }


    public void play() {
        outputView.noticeResult();
        playMultipleTimes();
    }

    public void showResult() {
        outputView.printCarsWith(game.getCarsDto());
        outputView.printWinnersWith(game.getWinnersDto());
    }

    private List<Car> makeCarsWith(List<String> carNames) {
        return carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    private void validateNotNegativeInteger(int trialCount) {
        if (trialCount < MIN_TRIAL_COUNT) {
            throw new IllegalArgumentException("[ERROR] 시도횟수는 음수이면 안됩니다.");
        }
    }

    private void playMultipleTimes() {
        for (int i = 0; i < trialCount; i++) {
            game.playOnce();
            outputView.printCarsWith(game.getCarsDto());
        }
    }
}
