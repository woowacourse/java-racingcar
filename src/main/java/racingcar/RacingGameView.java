package racingcar;

import java.util.Scanner;
import java.util.List;

public class RacingGameView {

    private static final String START_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String TRIAL_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String CAR_SITUATION_MESSAGE_FORMAT = "%s : %s%n";
    private static final String WINNERS_MESSAGE_FORMAT = "%s가 최종 우승했습니다.%n";
    private static final String LIST_SEPARATOR = ", ";
    private static final String MOVEMENT = "-";

    private static final Scanner scanner = new Scanner(System.in);

    public static String requestCars() {
        System.out.println(START_MESSAGE);
        String result = scanner.nextLine();
        return result;
    }

    public static String requestTrial() {
        System.out.println(TRIAL_MESSAGE);
        String result = scanner.nextLine();
        return result;
    }

    public static void printResult() {
        System.out.println(RESULT_MESSAGE);
    }

    public static void printCarPosition(Car car) {
        String movement = "";
        for (int p=0; p<car.getPosition(); p++){
            movement = movement.concat(MOVEMENT);
        }
        System.out.printf(CAR_SITUATION_MESSAGE_FORMAT, car.getName(), movement);
    }

    public static void printNewLine() {
        System.out.println();
    }
}
