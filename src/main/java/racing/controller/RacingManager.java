package racing.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

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
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            List<String> carNames = getCarNames(br);
            Racing racing = play(br, carNames);
            List<String> winnerNames = racing.getWinnerNames();
            RacingResultOutputManager.printWinner(winnerNames);
            br.close();
        } catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    private Racing play(BufferedReader br, List<String> carNames) {
        int maxTurn = getMaxTurn(br);
        Cars cars = makeCars(carNames);
        Racing racing = new Racing(maxTurn, cars);
        List<RacingResult> racingResults = new ArrayList<>();
        for (int turn = 0; turn < maxTurn; turn++) {
            List<Integer> racingConditions = RandomGenerator.generate(carNames.size());
            racingResults.add(new RacingResult(racing.nextTurn(racingConditions)));
        }
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
