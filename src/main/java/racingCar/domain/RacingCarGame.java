package racingCar.domain;

import racingCar.view.InputView;
import racingCar.view.OutputView;

import java.util.List;

public class RacingCarGame {

    public void play() {
        int numberToMove = InputView.setupGame();
        RacingCar[] competitors = playRace(numberToMove);
        showResult(competitors);
    }

    private RacingCar[] playRace(int numberToMove) {
        String[] names = RacingCarNameGenerator.generate("pobi,crong,honux");
        RacingCar[] competitors = new RacingCar[3];
        for (int i = 0; i < names.length; i++) {
            competitors[i] = new RacingCar(names[i]);
        }

        OutputView.printGuideOfResult();
        for (int i = 0; i < numberToMove; i++ ) {
            for (RacingCar competitor : competitors) {
                int randomNumber = RandomNumberCreator.create();
                competitor.goWithNumberOverFour(randomNumber);
            }

            OutputView.printStateOfRacingCars(competitors);
        }

        return competitors;
    }

    private void showResult(RacingCar[] competitors) {
        List<RacingCar> winners = RacingCarWinnersSortOuter.sortOut(competitors);
        OutputView.printResult(winners);
    }
}
