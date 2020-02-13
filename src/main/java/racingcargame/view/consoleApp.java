package racingcargame.view;

import racingcargame.controller.CarDto;
import racingcargame.controller.RacingCarController;
import racingcargame.domain.Repeat;

import java.util.List;

import static racingcargame.view.consoleInput.inputNames;
import static racingcargame.view.consoleInput.inputRepeat;
import static racingcargame.view.consoleOutput.*;

public class consoleApp {
    public static void main(String[] args) {
        final String names = inputNames();
        final Repeat repeat = new Repeat(inputRepeat());

        printRaceResultMessage();
        final RacingCarController game = new RacingCarController();
        final List<CarDto> racingResult = game.run(names, repeat);
        printRaceResult(racingResult);

        String winner = game.winner;
        printWinner(winner);
    }

    private static void printRaceResult(List<CarDto> carStatus) {
        carStatus.forEach(consoleApp::printEachRaceStatus);
    }

    private static void printEachRaceStatus(CarDto carDto) {
        carDto.getCar().forEach(consoleOutput::printRaceStatus);
        System.out.println();
    }
}
