package view;

import domain.Car;
import domain.Count;
import domain.RaceCars;
import domain.RandomNumberGenerator;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private final Scanner scanner = new Scanner(System.in);

    public RaceCars readCars() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String carNames = scanner.nextLine();
        return getCars(carNames);
    }

    private RaceCars getCars(String carNames) {
        String[] names = carNames.split(",");
        List<Car> cars = Arrays.stream(names)
                .map(Car::new)
                .collect(Collectors.toList());
        return new RaceCars(cars, new RandomNumberGenerator());
    }

    public Count readCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        int count = Integer.parseInt(scanner.nextLine());
        return new Count(count);
    }
}
