package racingcar.view;

import racingcar.controller.MainController;
import racingcar.domain.car.Car;
import racingcar.domain.car.CarRepository;
import racingcar.utils.ErrorUtils;
import racingcar.utils.ValidateUtils;

import java.util.List;
import java.util.stream.Collectors;

public class GamePage {
    private static final char SINGLE_VISUAL_POSITION = '-';

    public static void printGamePage() {
        System.out.println(System.lineSeparator() + "실행 결과");
    }

    public static void printSingleRoundResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(formatSingleRoundInformation(car));
        }
        System.out.println();
    }

    public static String formatSingleRoundInformation(Car car) {
        StringBuilder visualPosition = new StringBuilder();
        while (visualPosition.length() < car.getPosition()) {
            visualPosition.append(SINGLE_VISUAL_POSITION);
        }
        return car.getName() + " : " + visualPosition;
    }

    public static void printFinalResult(List<Car> winners) {
        try {
            ValidateUtils.validateData(winners);
        } catch (IllegalArgumentException e) {
            ErrorUtils.printError(e);
            CarRepository.deleteAll();
            MainController mainController = new MainController();
            mainController.run();
        }
        System.out.println(joinWinnerNames(winners) + "가 최종 우승했습니다.");
    }

    public static String joinWinnerNames(List<Car> winners) {
        return winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
    }

}
