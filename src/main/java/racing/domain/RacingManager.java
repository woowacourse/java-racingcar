package racing.domain;

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
        InputGuideOutputManager.printInputCarNames();
        List<String> carNames = getCarNames(scanner);
        InputGuideOutputManager.printInputMaxRacingTurn();
        int maxTurn = getMaxTurn(scanner);

        List<Car> cars = makeCars(carNames);
        Racing racing = new Racing(cars, maxTurn);
        List<RacingResult> racingResults = doRace(carNames, maxTurn, cars, racing);
        RacingResultOutputManager.printResult(racingResults);
        List<Car> winners = racing.getWinners();
        List<String> winnerNames = winners.stream()
                .map(Car::getName)
                .toList();
        RacingResultOutputManager.printWinner(winnerNames);
    }

    private static List<String> getCarNames(Scanner scanner) {
        RetryHelper carNameInputManager = new RetryHelper(5);
        return carNameInputManager.retry(
                () -> CarNameInputManager.getNameFromConsole(scanner));
    }

    private static int getMaxTurn(Scanner scanner) {
        RetryHelper maxTurnInputManager = new RetryHelper(5);
        return maxTurnInputManager.retry(
                () -> RacingMaxTurnInputManager.getMaxTurnFromConsole(scanner));
    }

    private static List<Car> makeCars(List<String> carNames) {
        return carNames.stream()
                .map(name -> new Car(0, name))
                .toList();
    }

    private static List<RacingResult> doRace(List<String> carNames, int maxTurn, List<Car> cars,
                                             Racing racing) {
        return IntStream.range(0, maxTurn).mapToObj(value -> {
            List<Integer> raceConditions = RandomGenerator.generate(cars.size());
            racing.doRace(raceConditions);
            List<String> distances = cars.stream()
                    .map(car -> "-".repeat(car.getDistance()))
                    .toList();
            return new RacingResult(carNames, distances);
        }).toList();
    }
}
