package racingcargame;

import racingcargame.domain.Car;
import racingcargame.domain.CarDto;
import racingcargame.domain.RacingCarGame;
import racingcargame.domain.Repeat;
import racingcargame.view.InputView;
import racingcargame.view.OutputView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        final String names = InputView.inputNames();
        final Repeat repeat = new Repeat(InputView.inputRepeat());

        OutputView.printRaceResult();
        final RacingCarGame game = new RacingCarGame();
        final List<CarDto> carStatus = game.run(names, repeat);
        for (CarDto carDto : carStatus) {
            printEachRaceStatus(carDto);
        }

        String winner = game.winner;
        OutputView.printWinner(winner);
    }

    private static void printEachRaceStatus(CarDto carDto) {
        for (Car car : carDto.getCar()) {
            OutputView.printRaceStatus(car);
        }
        System.out.println();
    }
}
