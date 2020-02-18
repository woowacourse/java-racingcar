package racingcargame.view;

import com.sun.corba.se.impl.io.TypeMismatchException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {
    private static final int ZERO = 0;
    private static final int NAME_UPPER_LIMIT = 5;

    private static Scanner scanner = new Scanner(System.in);

    public static String inputNames() {
        OutputView.inputNameInstruction();
        try {
            String userInput = scanner.nextLine();
            String[] names = userInput.split(",");
            checkNames(names);
            return userInput;
        } catch (Exception e) {
            OutputView.errorMessage(e.getMessage());
            return inputNames();
        }
    }

    public static int inputRepeat() {
        OutputView.inputRepeatInstruction();
        try {
            String repeatString = scanner.nextLine();
            checkRepeat(repeatString);
            return Integer.parseInt(repeatString);
        } catch (Exception e) {
            OutputView.errorMessage(e.getMessage());
            return inputRepeat();
        }
    }

    private static void checkRepeat(String repeat) {
        try {
            if (Integer.parseInt(repeat) <= ZERO) throw new IllegalArgumentException("양수만 가능합니다.");
        } catch (NumberFormatException e) {
            throw new NumberFormatException("숫자만 입력해주세요.");
        }
    }


    private static void checkNames(String[] names) {
        validateOnlyComma(names);
        for (String name : names) {
            validateNotNull(name);
            validateLength(name);
            validateNoBlank(name);
        }
    }

    private static void validateLength(String name) {
        if (name.length() <= ZERO || name.length() > NAME_UPPER_LIMIT || name.contains(",")) {
            throw new IllegalArgumentException("이름은 1자 이상 5자 이하여야 합니다.");
        }
    }

    private static void validateNotNull(String name) {
        if (name == null) {
            throw new IllegalArgumentException("이름은 null값이 될 수 없습니다.");
        }
    }

    private static void validateNoBlank(String name) {
        if (name.contains(" ")) {
            throw new IllegalArgumentException("이름에는 띄어쓰기가 포함될 수 없습니다.");
        }
    }

    private static void validateOnlyComma(String[] names) {
        if (names.length == 0) {
            throw new IllegalArgumentException("쉼표만 입력하실 수 없습니다.");
        }
    }


}
