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
	private static final String INPUT_CAR_NAMES_MESSAGE = "자동차 이름을 입력하세요 (1 - 5글자) :";
	private static final String INPUT_NUMBER_OF_ROUND_MESSAGE = "게임라운드를 입력하세요 :";

	private InputView() {
	}

	public static String inputCarNames() {
		System.out.print(INPUT_CAR_NAMES_MESSAGE);
		return scanner.nextLine();
	}

	public static int inputNumberOfRound() {
		System.out.print(INPUT_NUMBER_OF_ROUND_MESSAGE);
		return scanner.nextInt();
	}
}
