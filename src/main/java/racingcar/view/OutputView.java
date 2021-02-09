package racingcar.view;

import racingcar.dto.CarDto;
import racingcar.dto.CarsDto;
import racingcar.dto.WinnersDto;

import java.util.Collections;
import java.util.List;

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

    public static void printLeaderBoard(CarsDto carsDto) {
        for (CarDto car : carsDto.toList()) {
            String positionStick = makeStick(car);
            System.out.printf(LEADER_BOARD_DATA_FORMAT, car.getNameAsString(), positionStick);
        }
        System.out.println();
    }

    public static String makeStick(CarDto car) {
        return String.join("", Collections.nCopies(car.getPositionAsInt(), DASH));
    }

    public static void announceWinners(WinnersDto winnersDto) {
        List<String> winnerNames = winnersDto.getWinnerNames();
        System.out.println(String.join(COMMA_AND_BLANK, winnerNames).concat("가 최종 우승했습니다."));
    }
}
