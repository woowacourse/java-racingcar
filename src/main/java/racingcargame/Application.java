package racingcargame;

import racingcargame.domain.Car;
import racingcargame.domain.CarDto;
import racingcargame.domain.RacingCarGame;
import racingcargame.view.InputView;
import racingcargame.view.OutputView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        OutputView.inputNameInstruction();
        final String userInputName = InputView.inputNames();

        OutputView.inputRepeatInstruction();
        final int userInputRepeat = InputView.inputRepeat();

        OutputView.resultInstruction();
        RacingCarGame game = new RacingCarGame();

        List<CarDto> carStatus = game.run(userInputName, userInputRepeat);

        for (CarDto carDto : carStatus) {
            for (Car car: carDto.getCar()) {
                OutputView.carNameAndPosition(car);
            }
            OutputView.newLine();
        }

        String winner = game.winner;
        OutputView.winnerInstruction(winner);



    }


}
