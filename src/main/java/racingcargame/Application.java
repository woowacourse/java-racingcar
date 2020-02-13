package racingcargame;

import racingcargame.controller.CarDto;
import racingcargame.controller.RacingCarController;
import racingcargame.domain.Car;
import racingcargame.domain.Repeat;
import racingcargame.view.InputView;
import racingcargame.view.OutputView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        final String names = InputView.inputNames();
        final Repeat repeat = new Repeat(InputView.inputRepeat());

        OutputView.printRaceResultMessage();
        final RacingCarController game = new RacingCarController();
        final List<CarDto> carStatus = game.run(names, repeat);
        printRaceResult(carStatus);

        String winner = game.winner;
        OutputView.printWinner(winner);
    }

    private static void printRaceResult(List<CarDto> carStatus) {
        for (CarDto carDto : carStatus) {
            printEachRaceStatus(carDto);
        }
    }

    private static void printEachRaceStatus(CarDto carDto) {
        for (Car car : carDto.getCar()) {
            OutputView.printRaceStatus(car);
        }
        System.out.println();
    }
}
