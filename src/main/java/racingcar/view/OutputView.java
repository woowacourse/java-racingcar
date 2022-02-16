package racingcar.view;

import static java.util.stream.Collectors.*;

import java.util.List;

import racingcar.controller.dto.CarDto;
import racingcar.controller.dto.CarsDto;

public class OutputView {
    private static final String STATUS_MESSAGE = "\n실행 결과";
    private static final String CARS_STATUS_JOIN_DELIMITER = "\n";
    private static final String CAR_STATUS_CRITERIA = " : ";
    private static final int DEFAULT_POSITION = 0;
    private static final String CAR_STATUS_POSITION = "-";
    private static final String WINNER_NAME_DELIMITER = ", ";
    private static final String END_MESSAGE = "가 최종 우승했습니다.";

    public void printStatusMessage() {
        System.out.println(STATUS_MESSAGE);
    }

    public void printStatus(CarsDto carsDto) {
        System.out.println(makeCarsStatus(carsDto));
        System.out.println();
    }

    public String makeCarsStatus(CarsDto carsDto) {
        return carsDto.getCars()
            .stream()
            .map(this::makeCarStatus)
            .collect(joining(CARS_STATUS_JOIN_DELIMITER));
    }

    private String makeCarStatus(CarDto carDto) {
        StringBuilder carStatus = new StringBuilder(carDto.getName());
        carStatus.append(CAR_STATUS_CRITERIA);
        int position = carDto.getPosition();
        while (position-- > DEFAULT_POSITION) {
            carStatus.append(CAR_STATUS_POSITION);
        }
        return carStatus.toString();
    }

    public void printResult(List<String> winners) {
        System.out.println(String.join(WINNER_NAME_DELIMITER, winners) + END_MESSAGE);
    }

    public void printErrorMessage(String message) {
        System.out.println(message + "\n");
    }
}
