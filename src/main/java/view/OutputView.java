package view;

import dto.CarDto;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    public void printResultTitle() {
        System.out.println("실행 결과");
    }

    public void printStatus(final List<CarDto> cars) {
        for (final CarDto car : cars) {
            final String status = String.format("%s : %s", car.getName(), "-".repeat(car.getPosition()));
            System.out.println(status);
        }
        System.out.println();
    }

    public void printWinners(final List<CarDto> winners) {
        final List<String> winnersNames = winners.stream()
                .map(CarDto::getName)
                .collect(Collectors.toList());
        System.out.print(String.join(", ", winnersNames));
        System.out.print("가 최종 우승했습니다.");
    }

    public void printErrorMessage(final String message) {
        System.out.println(message);
    }

}
