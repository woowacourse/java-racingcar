package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;

import racingcar.client.OutputClient;
import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;

public class OutputView {

    private static final String CAR_DELIMITER = " : ";
    private static final String CAR_PROGRESS = "-";
    private static final String WINNER_DELIMITER = ", ";

    private final OutputClient outputClient;

    public OutputView(OutputClient outputClient) {
        this.outputClient = outputClient;
    }

    public void printProcessPrompt() {
        outputClient.output("실행 결과\n");
    }

    public void printCarsPosition(Cars cars) {
        cars.getCarList().forEach(this::printCarPosition);
        outputClient.output("\n");
    }

    private void printCarPosition(Car car) {
        outputClient.output(car.getName() + CAR_DELIMITER);
        for (int i = 0; i < car.getPosition(); i++) {
            outputClient.output(CAR_PROGRESS);
        }
        outputClient.output("\n");
    }

    public void printWinners(List<Car> carList) {
        List<String> nameList = toNames(carList);
        System.out.println(String.join(WINNER_DELIMITER, nameList) + "가 최종 우승했습니다.\n");
    }

    private List<String> toNames(List<Car> carList) {
        return carList.stream()
            .map(Car::getName)
            .collect(Collectors.toList());
    }
}
