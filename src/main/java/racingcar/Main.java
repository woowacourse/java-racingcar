package racingcar;

import racingcar.controller.RacingGame;
import racingcar.domain.Round;
import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;
import racingcar.domain.result.RacingResult;
import racingcar.view.InputView;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String inputForCarNames = InputView.inputCarNames();
        List<Car> cars = Cars.generateCarsByInput(inputForCarNames);

        String inputForRound = InputView.inputRound();
        Round round = new Round(inputForRound);

        RacingGame racingGame = new RacingGame(cars, round);
        RacingResult racingResult = racingGame.play();


//        System.out.println("우승자 명단");
//        Winners winners = new Winners(cars);
//        OutputView.printResult(winners.getWinnersName());
    }
}
