package view;

import domain.Car;
import domain.Count;
import domain.RaceCars;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class View {
    private static final String FORMAT = "%s : %s";
    private final Scanner scanner = new Scanner(System.in);

    public RaceCars readCars() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String carNames = scanner.nextLine();
        return getCars(carNames);
    }

    private RaceCars getCars(String carNames) {
        try {
            String[] names = carNames.split(",");
            List<Car> cars = Arrays.stream(names)
                    .map(Car::new)
                    .collect(Collectors.toList());
            return new RaceCars(cars);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
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

    public void printRace(RaceCars raceCars) {
        List<Car> cars = raceCars.getCars();
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
