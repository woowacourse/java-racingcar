/*
 * @(#)InputView.java      1.0 2019/05/12
 *
 * Copyright (c) 2019 Hyogeon Kim,
 * Calculator, Java, Seoul, KOREA
 */
package view;

import java.util.Scanner;

/**
 * @version 1.0 2019년 05년 12일
 * @author 김효건
 */
public class InputView {
    /*자동차게임 입력에 관한 클래스*/
    private static final Scanner scanner = new Scanner(System.in);

    public static String inputCarsNames() {
        System.out.println("경주할 자동차 이름을 입력하세요 (이름은 쉼표(,)를 기준으로 구분).");
        return scanner.nextLine();
    }

    public static String inputLapCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        return scanner.nextLine();
    }
}
