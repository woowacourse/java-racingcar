package view;

import java.util.Scanner;

public class InputView {
    /**
     * 사용자 입력
     */

    private static final String ROUND_INPUT_MESSAGE = "시도할 횟수를 입력하세요";
    private static final String NAME_INPUT_MESSAGE = "자동차의 이름을 입력하세요.(',' 기준으로 구분, 5글자 이하)";
    private static final Scanner SCANNER = new Scanner(System.in);

    public static String[] inputCarNames() {
        System.out.println(NAME_INPUT_MESSAGE);
        return SCANNER.nextLine()
                .trim()
                .split(",");
    }

    public static String inputRound() {
        System.out.println(ROUND_INPUT_MESSAGE);
        return SCANNER.nextLine();
    }


//    private static final String ROUND_INPUT_MESSAGE = "시도할 횟수를 입력하세요";
//    private static final String SPLIT_DELIMITER = ",";
//    private static final Scanner SCANNER = new Scanner(System.in);

//    public static String[] inputCarName() {
//        System.out.println(CAR_NAME_INPUT_MESSAGE);
//        String input = SCANNER.nextLine()
//                .replace(" ", "");
//        return ValidateInput.validateName(nameSplit(input));
//    }
//
//    public static int inputRound() {
//        System.out.println(ROUND_INPUT_MESSAGE);
//        String input = SCANNER.next();
//        return ValidateInput.ValidateCount(input);
//    }
//
//    public static String[] nameSplit(String input) {
//        return input.split(SPLIT_DELIMITER);
//    }
}
