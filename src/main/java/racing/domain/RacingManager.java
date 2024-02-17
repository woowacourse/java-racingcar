package racing.domain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;
import racing.dto.RacingResult;
import racing.input.CarNameInputManager;
import racing.input.RacingMaxTurnInputManager;
import racing.output.InputGuideOutputManager;
import racing.output.RacingResultOutputManager;
import util.RandomGenerator;
import util.RetryHelper;

public class RacingManager {
    public static void raceStart() {
        Scanner scanner = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        InputGuideOutputManager.printInputCarNames();
        List<String> carNames = getCarNames(br);
        Racing racing = play(scanner, carNames);
        List<String> winnerNames = racing.getWinnerNames();
        RacingResultOutputManager.printWinner(winnerNames);
    }

    private static Racing play(Scanner scanner, List<String> carNames) {
        int maxTurn = getMaxTurn(scanner);
        Cars cars = makeCars(carNames);
        Racing racing = new Racing(maxTurn, cars);
        List<RacingResult> racingResults = IntStream.range(0, maxTurn).mapToObj(value -> {
            List<Integer> racingConditions = RandomGenerator.generate(carNames.size());
            racing.nextTurn(racingConditions);
            return RacingDTOMapper.from(racing);
        }).toList();
        RacingResultOutputManager.printResult(racingResults);
        return racing;
    }

    private static List<String> getCarNames(BufferedReader br) {
        RetryHelper carNameInputManager = new RetryHelper(5);
        return carNameInputManager.retry(
                () -> {
                    try {
                        return CarNameInputManager.getNameFromConsole(br);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });
    }

    private static int getMaxTurn(Scanner scanner) {
        RetryHelper maxTurnInputManager = new RetryHelper(5);
        return maxTurnInputManager.retry(
                () -> {
                    InputGuideOutputManager.printInputMaxRacingTurn();
                    return RacingMaxTurnInputManager.getMaxTurnFromConsole(scanner);
                });
    }

    private static Cars makeCars(List<String> carNames) {
        List<Car> cars = carNames.stream()
                .map(name -> new Car(0, name))
                .toList();
        return new Cars(cars);
    }
}
