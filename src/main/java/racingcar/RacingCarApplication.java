package racingcar;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.RacingGame;
import racingcar.dto.RacingStatus;
import racingcar.io.Input;
import racingcar.io.Output;

public class RacingCarApplication {
    public static void main(String[] args) {
        Input input = new Input();
        Output output = new Output();
        startGame(input, output);
    }

    private static void startGame(Input input, Output output) {
        RacingGame racingGame = new RacingGame(input.inputCarNames(), input.inputTrials());
        while (!racingGame.isEnd()) {
            racingGame.race();
            output.printCurrentPosition(convertCarsToRacingStatus(racingGame.getCars()));
        }
        output.printWinner(racingGame.getWinners());
    }

    private static List<RacingStatus> convertCarsToRacingStatus(List<Car> cars) {
        return cars.stream()
            .map(RacingStatus::new)
            .collect(Collectors.toList());
    }
}
