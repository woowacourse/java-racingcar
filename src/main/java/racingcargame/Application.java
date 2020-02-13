package racingcargame;

import racingcargame.domain.Car;
import racingcargame.domain.CarDto;
import racingcargame.domain.RacingCarGame;
import racingcargame.view.InputView;
import racingcargame.view.OutputView;

import java.util.List;

public class Application {
    public static void main(String[] args) throws Exception {

        try {
            OutputView.inputNameInstruction();
            final String userInputName = InputView.inputNames();
            OutputView.inputRepeatInstruction();
            final int userInputRepeat = InputView.inputRepeat();

            RacingCarGame game = new RacingCarGame();
            List<CarDto> carStatus = game.run(userInputName, userInputRepeat);
            OutputView.resultInstruction();
            for (CarDto carDto : carStatus) {
                printEachRaceStatus(carDto);
            }

            String winner = game.winner;
            OutputView.winnerInstruction(winner);
        }
        catch (Exception e) {
            OutputView.errorMessage(e.getMessage());
        }
    }

    private static void printEachRaceStatus(CarDto carDto) {
        for (Car car: carDto.getCar()) {
            OutputView.carNameAndPosition(car);
        }
        OutputView.newLine();
    }
}
