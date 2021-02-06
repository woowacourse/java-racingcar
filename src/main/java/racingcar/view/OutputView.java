package racingcar.view;

import racingcar.dto.CarResponseDto;
import racingcar.dto.CarsResponseDto;

import java.util.Collections;
import java.util.stream.Collectors;

public class OutputView {
    private static final String DASH = "-";
    private static final String LEADER_BOARD_DATA_FORMAT = "%s : %s%n";
    private static final String WINNER_ANNOUNCE_MSG = "가 최종 우승했습니다.";
    private static final String EXECUTE_RESULT_MSG = "실행 결과";
    private static final String INPUT_CARS_NAME_MSG = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String INPUT_NUMBER_OF_ROUNDS_MSG = "시도할 회수는 몇회인가요?";
    private static final String COMMA_AND_BLANK = ", ";

    public static void output(String message) {
        System.out.println(message);
    }

    public static void printLeaderBoard(CarsResponseDto carsResponseDto) {
        for (CarResponseDto car : carsResponseDto.getCarResponseDtoList()) {
            String positionStick = makeStick(car);
            printf(LEADER_BOARD_DATA_FORMAT, car.getName(), positionStick);
        }
        println();
    }

    public static String makeStick(CarResponseDto car) {
        return String.join("", Collections.nCopies(car.getPosition(), DASH));
    }

    public static void announceWinners(CarsResponseDto carsResponseDto) {
        println(carsResponseDto
                .getCarResponseDtoList()
                .stream()
                .map(CarResponseDto::getName)
                .collect(Collectors.joining(COMMA_AND_BLANK)).concat(WINNER_ANNOUNCE_MSG));
    }

    public static void printResultMessage() {
        println(EXECUTE_RESULT_MSG);
    }

    public static void printInputCarsNameMessage(){
        println(INPUT_CARS_NAME_MSG);
    }

    public static void printInputNumberOfRoundsMessage() {
        println(INPUT_NUMBER_OF_ROUNDS_MSG);
    }

    public static void println(){
        println("");
    }

    public static void println(String message){
        System.out.println(message);
    }

    public static void printf(String format, Object... args){
        System.out.printf(format, args);
    }
}
