package racingcar.view;

import racingcar.dto.CarResponseDto;
import racingcar.dto.CarsResponseDto;

import java.util.Collections;
import java.util.stream.Collectors;

public class OutputView {
    private static final String DASH = "-";
    private static final String LEADER_BOARD_DATA_FORMAT = "%s : %s%n";
    private static final String COMMA_AND_BLANK = ", ";

    public static void printCarNameInputRequestMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    }

    public static void printNumberOfRoundsInputRequestMessage() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public static void printResultMessage() {
        System.out.println("실행 결과");
    }

    public static void printLeaderBoard(CarsResponseDto carsResponseDto) {
        for (CarResponseDto car : carsResponseDto.getCarsResponseDto()) {
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
                .getCarsResponseDto()
                .stream()
                .map(CarResponseDto::getName)
                .collect(Collectors.joining(COMMA_AND_BLANK)).concat("가 최종 우승했습니다."));
    }
}
