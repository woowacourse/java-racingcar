/*
 * @(#)InputView.java
 *
 * v 1.0.0
 *
 * 2019.05.09
 *
 * Copyright (c) 2019 MrKwon, imkimheejoo
 * WoowahanTechCamp, Seoul, KOREA
 * All right Reserved
 */

package racing.view;

import racing.validator.InputValidator;

import java.util.Scanner;

/**
 * 사용자의 입력에 관한 클래스
 *
 * @author imkimheejoo
 * @version 1.0.0
 */
public class InputView {
    private static final String INPUT_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분.)";
    private static final String INPUT_TIMES_MESSAGE = "시도할 횟수는 몇회인가요?";
    public static final String COMMA = ",";
    private static Scanner sc = new Scanner(System.in);

    public static String[] inputCarNames() {
        try {
            System.out.println(INPUT_NAMES_MESSAGE);
            return splitNames(sc.nextLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputCarNames();
        }
    }

    private static String[] splitNames(String carNames) {
        String[] names = InputValidator.checkDuplication(carNames.split(COMMA));
        for (String name : names) {
            InputValidator.checkValidName(name);
        }
        return names;
    }

    public static int inputExecution() {
        try {
            System.out.println(INPUT_TIMES_MESSAGE);
            int execution = Integer.parseInt(sc.nextLine());
            return InputValidator.checkValidExecution(execution);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputExecution();
        }
    }
}
