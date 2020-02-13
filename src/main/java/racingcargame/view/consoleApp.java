package racingcargame.view;

import racingcargame.controller.RacingCarController;
import racingcargame.domain.CarStatus;
import racingcargame.domain.RepeatTimes;

import java.util.List;

import static racingcargame.view.consoleInput.inputNames;
import static racingcargame.view.consoleInput.inputRepeat;
import static racingcargame.view.consoleOutput.printRaceResultMessage;
import static racingcargame.view.consoleOutput.printWinner;

public class consoleApp {
    public static void main(String[] args) {
        final String names = inputNames();
        final int repeat = parseStringToInt(inputRepeat());
        final RepeatTimes repeatTimes = new RepeatTimes(repeat);

        printRaceResultMessage();
        final RacingCarController game = new RacingCarController();
        final List<CarStatus> racingResult = game.run(names, repeatTimes);
        printRaceResult(racingResult);

        final String winner = game.winner;
        printWinner(winner);
    }

    private static int parseStringToInt(String inputRepeat) {
        try {
            return Integer.parseInt(inputRepeat);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수를 입력해주세요.");
        }
    }

    private static void printRaceResult(List<CarStatus> carStatus) {
        carStatus.forEach(consoleApp::printEachRaceStatus);
    }

    private static void printEachRaceStatus(CarStatus carStatus) {
        carStatus.getCars().forEach(consoleOutput::printRaceStatus);
        System.out.println();
    }
}
