package view;

import domain.Car;
import domain.Validator;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class View {
    private static final String FORMAT = "%s : %s";
    private final Scanner scanner = new Scanner(System.in);

    public List<Car> readCars() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String[] carNames = readCarNames();
        return getCars(carNames);
    }

    private String[] readCarNames() {
        String userInput = scanner.nextLine();
        return userInput.split(",");
    }

    private List<Car> getCars(String[] carNames) {
        try {
            Validator.validateParticipant(carNames);
            return makeCars(carNames);
        } catch (IllegalArgumentException e) {
            System.out.println("다시 입력해주세요.");
            return readCars();
        }
    }

    public Count readCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        try {
            int count = Integer.parseInt(scanner.nextLine());
            return new Count(count);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readCount();
        }
    }

    public void printResultNotice() {
        System.out.println("\n실행 결과");
    }

    public void printRace(List<Car> cars) {
        for (Car car : cars) {
            String location = "-".repeat(car.getLocation());
            String result = String.format(FORMAT, car.getName(), location);
            System.out.println(result);
        }
        System.out.println();
    }

    public void printWinners(List<Car> winners) {
        String winnerNotice = winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", ", "", "가 최종 우승했습니다."));
        System.out.println(winnerNotice);
    }
}
