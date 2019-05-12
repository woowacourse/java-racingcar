/*
 * @(#)InputView.java
 *
 * v 2.0.0
 *
 * 2019.05.11
 *
 * Copyright (c) 2019 MrKwon, imkimheejoo
 * WoowahanTechCamp, Seoul, KOREA
 * All right Reserved
 */

package racing.view;

import java.util.Scanner;


/**
 * 레이싱 게임에 필요한 입력을 받는 뷰 클래스
 *
 * @author imkimheejoo
 * @author MrKwon
 * @version 2.0.0
 */
public class InputView {
    private static final String TIMES_INVALID_MESSAGE = "이동 횟수는 양수입니다.";
    private static final String CAR_NAME_INPUT_DELIMITER = ",";

    private final Scanner sc = new Scanner(System.in);

    public String[] getCarNames() {
        try {
            String[] tmp = sc.next().split(CAR_NAME_INPUT_DELIMITER);
            return tmp;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getCarNames();
        }
    }

    public int getRuns() {
        try {
            return validRuns();
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return getRuns();
        }
    }

    private int validRuns() {
        int runs = sc.nextInt();
        if (runs <= 0) {
            throw new IllegalArgumentException(TIMES_INVALID_MESSAGE);
        }
        return runs;
    }
}
