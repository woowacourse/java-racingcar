package racingcar.view;

import racingcar.message.Message;

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

    private InputView() {
    }

    public static String inputCarNames() {
        System.out.println(Message.INPUT_CAR_NAMES.getMessageText());
        return scanner.nextLine();
    }

    public static int inputNumberOfRound() {
        System.out.println(Message.INPUT_NUMBER_OF_ROUND.getMessageText());
        return scanner.nextInt();
    }
}
