package racing.view;

import java.util.List;
import java.util.stream.Collectors;
import racing.domain.car.Car;

public class OutputView {
    public void printResultTitle() {
        System.out.println("실행 결과");
    }

    public void printStatus(List<Car> cars) {
        for (Car car : cars) {
            String status = String.format("%s : %s", car.getName(), "-".repeat(car.getPosition()));
            System.out.println(status);
        }
        System.out.println();
    }

    public void printWinners(List<Car> winners) {
        List<String> winnersNames = winners.stream()
                .map(Car::getName)
                .collect(Collectors.toList());
        System.out.print(String.join(", ", winnersNames));
        System.out.print("가 최종 우승했습니다.");
    }

    public void printErrorMessage(String message) {
        System.out.println(message);
    }

}
