package io;

import java.util.Scanner;
import java.util.regex.Pattern;

public class InputView {
    private static final String CAR_NAMES_REGEX = "[가-힣a-zA-Z]{2,5}(,[가-힣a-zA-Z]{2,5})*";
    public static final Pattern CAR_NAMES_PATTERN = Pattern.compile(CAR_NAMES_REGEX);
    public static final String CAR_NAMES_DELIMITER = ",";

    Scanner sc = new Scanner(System.in);

    public String readCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return sc.nextLine();
    }

    public String readTryAmount() {
        System.out.println("시도할 회수는 몇회인가요?");
        return sc.nextLine();
    }
}
