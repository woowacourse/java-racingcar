package carracinggame.view;

import carracinggame.domain.CarNames;
import carracinggame.domain.Cars;

public class OutputView {

    public static final String ENTER_CAR_NAMES = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    public static final String NAME_BLANK_ERROR = "[ERROR] 이름이 공백이면 안됩니다. 다시 입력해주세요.";
    public static final String NAME_LENGTH_ERROR = "[ERROR] 이름의 길이가 " + CarNames.NAME_MIN_LENGTH + "이하 또는 " +
            CarNames.NAME_MAX_LENGTH + "이상이면 안됩니다. 다시 입력해주세요.";
    public static final String WHAT_TIMES = "시도할 횟수는 몇회인가요?";
    public static final String TIMES_ERROR = "[ERROR] 시도 횟수는 양수인 정수여야 합니다. 다시 입력해주세요.";
    public static final String RESULT = "실행결과";
    public static final String NAME_AND_POSITION_DELIMITER = " : ";
    public static final String DISTANCE_OUTPUT = "-";

    public static void printEnterCarNames() {
        System.out.println(ENTER_CAR_NAMES);
    }

    public static void printWhatTimes() {
        System.out.println(WHAT_TIMES);
    }

    public static void printNameBlankError() {
        System.out.println(NAME_BLANK_ERROR);
    }

    public static void printNameLengthError() {
        System.out.println(NAME_LENGTH_ERROR);
    }

    public static void printTimesError() {
        System.out.println(TIMES_ERROR);
    }

    public static void printResultMessage() {
        System.out.println(RESULT);
    }

    public static void printResult(String name, int position) {
        System.out.print(name + NAME_AND_POSITION_DELIMITER);
        while(position-- > 0) {
            System.out.print("-");
        }
        System.out.println();
    }

    public static void println() {
        System.out.println();
    }


}
