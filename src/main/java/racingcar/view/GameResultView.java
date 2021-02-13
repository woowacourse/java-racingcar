package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.RacingGameResult;

public class GameResultView {

    public static final String RESULT_PREFIX =
            "\n실행 결과";
    public static final String PRINT_WINNERS =
            "%s가 최종 우승했습니다.";

    public static void printResultPrefix() {
        System.out.println(RESULT_PREFIX);
    }

    public static void printCarsBeforeRace(Cars cars) {
        printCars(cars.getCars());
    }

    public static void printCars(List<Car> carList) {
        carList.forEach(GameResultView::printCar);
        System.out.println();
    }

    public static void printCar(Car car) {
        System.out.printf("%s : %s\n", car.getName(), getPositionToString(car));
    }

    private static String getPositionToString(Car car) {
        StringBuilder sb = new StringBuilder();
        IntStream.range(0, car.getPosition().toInt()).forEach(i -> sb.append("-"));
        return sb.toString();
    }

    public static void printWinners(List<Car> winners) {
        String winnersName = winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));

        System.out.printf(PRINT_WINNERS, winnersName);
    }

    public static void printGameResult(RacingGameResult gameResult) {
        String winnersName = gameResult.getWinners().stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));

        System.out.printf(PRINT_WINNERS, winnersName);
    }
}
