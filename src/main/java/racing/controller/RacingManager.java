package racing.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.IntStream;

import racing.domain.Car;
import racing.domain.Cars;
import racing.domain.Racing;
import racing.dto.RacingResult;
import racing.input.CarNameInputManager;
import racing.input.RacingMaxTurnInputManager;
import racing.output.InputGuideOutputManager;
import racing.output.RacingResultOutputManager;
import util.RandomGenerator;
import util.RetryHelper;

public class RacingManager {
    public void raceStart() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> carNames = getCarNames(br);
        Racing racing = play(br, carNames);
        List<String> winnerNames = racing.getWinnerNames();
        RacingResultOutputManager.printWinner(winnerNames);
    }

    private Racing play(BufferedReader br, List<String> carNames) {
        int maxTurn = getMaxTurn(br);
        Cars cars = makeCars(carNames);
        Racing racing = new Racing(maxTurn, cars);
        List<RacingResult> racingResults = IntStream.range(0, maxTurn).mapToObj(value -> {
            List<Integer> racingConditions = RandomGenerator.generate(carNames.size());
            racing.nextTurn(racingConditions);
            return new RacingResult(racing.getCarsStatus());
        }).toList();
        RacingResultOutputManager.printResult(racingResults);
        return racing;
    }

    private List<String> getCarNames(BufferedReader br) {
        RetryHelper carNameInputManager = new RetryHelper(5);
        return carNameInputManager.retry(
                () -> {
                    try {
                        InputGuideOutputManager.printInputCarNames();
                        return CarNameInputManager.getNameFromConsole(br);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });
    }

    private static int getMaxTurn(BufferedReader br) {
        RetryHelper maxTurnInputManager = new RetryHelper(5);
        return maxTurnInputManager.retry(
                () -> {
                    InputGuideOutputManager.printInputMaxRacingTurn();
                    try {
                        return RacingMaxTurnInputManager.getMaxTurnFromConsole(br);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });
    }

    private static Cars makeCars(List<String> carNames) {
        List<Car> cars = carNames.stream()
                .map(name -> new Car(0, name))
                .toList();
        return new Cars(cars);
    }
}
