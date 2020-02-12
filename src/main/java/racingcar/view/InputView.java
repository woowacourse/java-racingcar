package racingcar.view;

import java.util.Scanner;

/*
 * Copyright (c) 2020 by 또동페어
 * All rights reserved.
 *
 * InputView.java
 * 입력을 담당하는 클래스
 *
 * @author      또동페어
 * @version     1.0
 * @date        12 Feb 2020
 *
 */
public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static String inputCarNames() {
        return scanner.nextLine();
    }

    public static int inputNumberOfRound() {
        return scanner.nextInt();
    }
}
