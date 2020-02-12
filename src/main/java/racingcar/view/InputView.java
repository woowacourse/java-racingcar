package racingcar.view;

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

import java.util.Scanner;

public class InputView {
	private final Scanner scanner;

	public InputView(Scanner scanner) {
		this.scanner = scanner;
	}

	public String inputCarNames() {
		return scanner.nextLine();
	}

	public int inputNumberOfRound() {
		return scanner.nextInt();
	}
}
