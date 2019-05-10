package racingcar.view;

import java.util.*;
import java.util.regex.Pattern;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String pattern = "^-[0-9]$";

    public String[] inputName() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String[] inputName = scanner.nextLine().trim().split(",");

        if (overLengthName(inputName) || hasBlank(inputName) || hasNotAnotherPlayer(inputName)
                || overLapName(inputName) || hasMiddleBlank(inputName)) {
            return inputName();
        }

        return inputName;
    }

    public int inputNumber() {
        System.out.println("시도할 회수는 몇회인가요?");
        String inputNumber = scanner.nextLine();

        if (hasBlankNumber(inputNumber) || hasCharacter(inputNumber) || hasNegativeNumber(inputNumber)) {
            return inputNumber();
        }

        return Integer.parseInt(inputNumber);
    }

    private boolean hasBlank(String[] inputName) {
        if (inputName.length == 1 && inputName[0].trim().equals("")) {
            System.err.println("에러 : 아무것도 입력 안되었습니다.");
            return true;
        }
        return false;
    }

    private boolean overLengthName(String[] inputName) {
        if (Arrays.stream(inputName).anyMatch(name -> name.length() >= 5)) {
            System.err.println("에러 : 5글자 이하로만 써주세요.");
            return true;
        }

        return false;
    }

    private boolean hasNotAnotherPlayer(String[] inputName) {
        if (inputName.length == 1) {
            System.err.println("에러 : 플레이어를 2명이상 입력해주세요.");
            return true;
        }
        return false;
    }

    private boolean overLapName(String[] inputName) {
        Set<String> compareName = new HashSet<>(Arrays.asList(inputName));

        if (inputName.length != compareName.size()) {
            System.err.println("에러 : 중복된 이름이 있습니다.");
            return true;
        }
        return false;
    }

    private boolean hasMiddleBlank(String[] inputName) {
        if (Arrays.asList(inputName).contains("")) {
            System.err.println("에러 : 중간에 공백이름이 있습니다.");
            return true;
        }

        return false;
    }

    private boolean hasBlankNumber(String inputNumber) {
        if (inputNumber.trim().equals("")) {
            System.err.println("에러 : 아무것도 입력되지 않았습니다.");
            return true;
        }

        return false;
    }

    private boolean hasNegativeNumber(String inputNumber) {
        if (Integer.parseInt(inputNumber) <= 0) {
            System.err.println("에러 : 양의정수가 아닌 수가 입력되었습니다.");
            return true;
        }

        return false;
    }

    private boolean hasCharacter(String inputNumber) {
        char[] inputChar = inputNumber.toCharArray();

        if (inputChar[0] == '-') {
            return false;
        }
        if (!Pattern.matches(pattern, inputNumber)) {
            System.err.println("에러 : 문자가 입력되었습니다.");
            return true;
        }

        return false;
    }

}
