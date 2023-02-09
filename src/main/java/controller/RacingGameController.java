package controller;

import domain.RacingCar;
import domain.RacingCars;
import domain.TryCount;
import java.util.List;
import java.util.stream.Collectors;
import util.CommaSeparator;
import view.InputView;
import view.OutputView;

public class RacingGameController {

    private RacingCars racingCars;
    private TryCount tryCount;

    public void start(){
        setUpGame();
        playGame();
    }

    private void setUpGame(){
        racingCars = createRacingCar();
        tryCount = getTryCount();
    }

    private RacingCars createRacingCar(){
        List<String> names = CommaSeparator.sliceNameByComma(getNames());
        return new RacingCars(createRacingCar(names));
    }

    private String getNames() {
        return InputView.requestCarName();
    }

    private List<RacingCar> createRacingCar(List<String> names) {
        return names.stream()
                .map(RacingCar::new)
                .collect(Collectors.toList());
    }

    private TryCount getTryCount(){
        return new TryCount(InputView.requestTryCount());
    }

    private void playGame() {
        OutputView.printResultMessage();

        while (canProceed()) {
            racingCars.moveAll();
            this.tryCount = tryCount.deduct();
            OutputView.printScoreBoard(racingCars);
        }

        OutputView.printWinner(racingCars);
    }

    private boolean canProceed() {
        return !tryCount.isZero();
    }
}
