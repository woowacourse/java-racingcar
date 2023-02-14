package racingcar.view;

import racingcar.exception.*;
import racingcar.model.car.Car;
import racingcar.model.car.Cars;

import java.util.StringJoiner;
import java.util.stream.Collectors;

public class OutputView {
    public static final String POSITION_CAR_FORMAT_SYMBOL = "-";
    public static final String POSITION_CAR_STATE_FORMAT = "%s : %s";
    private static final String WINNER_MESSAGE = "%s가 최종 우승했습니다.";
    private static final String CAR_SEPARATOR = ", ";
    private static final String LINE_BREAK = "\n";

    public static final String DUPLICATE_CAR_NAMES_ERROR_MESSAGE = "[ERROR] 중복된 차 이름이 존재합니다.";
    public static final String EXCEED_CAR_NAME_ERROR_MESSAGE = "[ERROR] 자동차 이름은 다섯 글자 이하여야 합니다.";
    public static final String HAS_BLANK_CAR_NAME_ERROR_MESSAGE = "[ERROR] 비어있는 자동차 이름이 존재합니다.";
    public static final String INVALID_CAR_NAME_FORMAT_ERROR_MESSAGE = "[ERROR] 자동차 이름은 문자와 숫자만 가능합니다.";
    public static final String INVALID_RANGE_TRIAL_TIMES_ERROR_MESSAGE = "[ERROR] 시도 횟수는 1 이상 100 이하여야 합니다.";
    public static final String INVALID_TRIAL_TIMES_FORMAT_ERROR_MESSAGE = "[ERROR] 시도 횟수는 숫자만 입력 가능합니다.";
    public static final String NOT_EXIST_CARS_ERROR_MESSAGE = "[ERROR] 게임에 참여한 자동차가 없습니다.";





    public void printCurrentCarsPosition(final Cars cars) {
        StringJoiner stringJoiner = new StringJoiner(LINE_BREAK);

        cars.getCarsCurrentInfo().forEach(car -> {
            stringJoiner.add(String.format(POSITION_CAR_STATE_FORMAT,
                    car.getCarName(),
                    POSITION_CAR_FORMAT_SYMBOL.repeat(car.getPosition())));
        });

        System.out.println(stringJoiner + LINE_BREAK);
    }

    public void printWinnerCars(final Cars cars) {
        String winnerCarsFormat = cars.getWinnerCars().stream()
                .map(Car::getCarName)
                .collect(Collectors.joining(CAR_SEPARATOR));

        System.out.println(String.format(WINNER_MESSAGE, winnerCarsFormat));
    }

    public void printErrorMessage(final IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }
}
