package view;

import model.Car;
import model.Cars;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    public static void printUserPromptCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    }

    public static void printUserPromptTrials() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public static void printErrorRetrialMessage() {
        System.out.println("다시 입력해주세요.");
    }

    public static void printRoundMessage() {
        System.out.println("실행결과");
    }

    public static void printRoundResult(Cars cars) {
        cars.getCars().stream().forEach(car -> printCarStatus(car.getName(), car.getPosition()));
        System.out.println();
    }

    public static void printCarStatus(String carName, int carPosition) {
        System.out.print(carName + " : ");
        for (int i = 0; i < carPosition; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public static void printWinners(List<Car> winners) {
        StringBuilder winnerMessage = new StringBuilder(winners
                .stream()
                .map(Car::getName)
                .collect(Collectors.joining(",")));
        winnerMessage.append("가 최종 우승했습니다.");
        System.out.println(winnerMessage);
    }

}
