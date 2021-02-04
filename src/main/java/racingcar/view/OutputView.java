package racingcar.view;

import racingcar.dto.CarResponseDto;
import racingcar.dto.CarsResponseDto;

import java.util.Collections;
import java.util.stream.Collectors;

public class OutputView {
    private static final String DASH = "-";
    private static final String LEADER_BOARD_DATA_FORMAT = "%s : %s%n";
    private static final String WINNER_ANNOUNCE_MSG = "가 최종 우승했습니다.";
    private static final String COMMA_AND_BLANK = ", ";

    public static void output(String message) {
        System.out.println(message);
    }

    public static void printLeaderBoard(CarsResponseDto carsResponseDto) {
        for (CarResponseDto car : carsResponseDto.getCarResponseDtoList()) {
            String positionStick = makeStick(car);
            System.out.printf(LEADER_BOARD_DATA_FORMAT, car.getName(), positionStick);
        }
        System.out.println();
    }

    public static String makeStick(CarResponseDto car) {
        return String.join("", Collections.nCopies(car.getPosition(), DASH));
    }

    public static void announceWinners(CarsResponseDto carsResponseDto) {
        System.out.println(carsResponseDto
                .getCarResponseDtoList()
                .stream()
                .map(CarResponseDto::getName)
                .collect(Collectors.joining(COMMA_AND_BLANK)).concat(WINNER_ANNOUNCE_MSG));
    }
}
