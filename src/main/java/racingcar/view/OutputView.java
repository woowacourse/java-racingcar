package racingcar.view;

import racingcar.dto.CarDto;
import racingcar.dto.CarsDto;
import racingcar.dto.WinnersDto;

import java.util.Collections;

public class OutputView implements Outputable {
    private static final String DASH = "-";
    private static final String LEADER_BOARD_DATA_FORMAT = "%s : %s%n";
    private static final String WINNER_ANNOUNCE_MSG = "가 최종 우승했습니다.";
    private static final String EXECUTE_RESULT_MSG = "실행 결과";
    private static final String INPUT_CARS_NAME_MSG = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String INPUT_NUMBER_OF_ROUNDS_MSG = "시도할 회수는 몇 회인가요?";
    private static final String COMMA_AND_BLANK = ", ";
    private static final String EMPTY = "";

    @Override
    public void printLeaderBoard(CarsDto carsDto) {
        for (CarDto car : carsDto.getCarDtoList()) {
            String positionStick = makeStick(car);
            printf(LEADER_BOARD_DATA_FORMAT, car.getName(), positionStick);
        }
        println();
    }

    public String makeStick(CarDto car) {
        return String.join("", Collections.nCopies(car.getPosition(), DASH));
    }

    @Override
    public void announceWinners(WinnersDto winnersDto) {
        printResultMessage();
        println(String.join(COMMA_AND_BLANK, winnersDto.getNames())
                .concat(WINNER_ANNOUNCE_MSG));
    }

    @Override
    public void printInputCarsNameMessage() {
        println(INPUT_CARS_NAME_MSG);
    }

    public void printInputNumberOfRoundsMessage() {
        println(INPUT_NUMBER_OF_ROUNDS_MSG);
    }

    public void println() {
        println(EMPTY);
    }

    public void println(String message) {
        System.out.println(message);
    }

    public void printf(String format, Object... args) {
        System.out.printf(format, args);
    }

    private void printResultMessage() {
        println(EXECUTE_RESULT_MSG);
    }
}
