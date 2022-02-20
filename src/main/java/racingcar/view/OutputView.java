package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.dto.CarResponse;
import racingcar.dto.CarsResponse;

public class OutputView {

    private static final String CAR_DELIMITER = " : ";
    private static final String CAR_PROGRESS = "-";
    private static final String WINNER_DELIMITER = ", ";

    public void printProcessPrompt() {
        System.out.println("실행 결과");
    }

    public void printCarsPosition(CarsResponse cars) {
        cars.getCars().forEach(this::printCarPosition);
        System.out.println();
    }

    private void printCarPosition(CarResponse car) {
        System.out.print(car.getName() + CAR_DELIMITER);
        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print(CAR_PROGRESS);
        }
        System.out.println();
    }

    public void printWinners(List<CarResponse> carList) {
        List<String> nameList = toNames(carList);
        System.out.println(String.join(WINNER_DELIMITER, nameList) + "가 최종 우승했습니다.");
    }

    private List<String> toNames(List<CarResponse> carList) {
        return carList.stream()
            .map(CarResponse::getName)
            .collect(Collectors.toList());
    }
}
