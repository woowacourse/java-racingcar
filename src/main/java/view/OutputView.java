package view;

import domain.CarDTO;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    public void printResultTitle() {
        System.out.println("실행 결과");
    }

    public void printStatus(List<CarDTO> cars) {
        for (CarDTO car : cars) {
            String status = String.format("%s : %s", car.name, "-".repeat(car.position));
            System.out.println(status);
        }
        System.out.println();
    }

    public void printWinners(List<CarDTO> winners) {
        List<String> winnersNames = winners.stream()
                .map(c -> c.name)
                .collect(Collectors.toList());
        System.out.print(String.join(", ", winnersNames));
        System.out.print("가 최종 우승했습니다.");
    }
}
