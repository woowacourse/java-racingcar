package racing.view.output;

import racing.domain.Car;
import racing.domain.Cars;

public class OutputView {

    public static final String CANT_CONTAIN_SPACE = "자동차 이름에 공백이 포함될 수 없습니다.";
    public static final String UNSUITABLE_LENGTH = "자동차 이름은 1자~5자만 입력할 수 있습니다.";
    public static final String INPUT_ONLY_DIGIT = "시도 회수는 숫자만 입력할 수 있습니다.";
    public static final String FINAL_WINNER = "가 최종 우승했습니다.";
    private static final String EXECUTE_RESULT = "실행 결과";
    public static final String COLON = " : ";
    public static final String HYPHEN = "-";
    public static final String COMMA = ", ";

    public static void printPhrase() {
        System.out.println();
        System.out.println(EXECUTE_RESULT);
    }

    public static void printStep(Cars cars) {
        cars.printCarsState();
    }

    public static void printCarState(Car car) {
        System.out.print(car.getName() + COLON);
        printHyphen(car);
        System.out.println();
    }

    private static void printHyphen(Car car) {
        System.out.println(HYPHEN.repeat(car.getStep()));
    }

    public static void printFinalResult(StringBuilder sb) {
        System.out.println(sb.toString() + FINAL_WINNER);
    }
}
