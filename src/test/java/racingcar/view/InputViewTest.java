package racingcar.view;

/*
 * Copyright (c) 2020 by 또동페어
 * All rights reserved.
 *
 * InputViewTest.java
 * 입력 테스트
 *
 * @author      또동페어
 * @version     1.0
 * @date        12 Feb 2020
 *
 */

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputViewTest {
	private InputView inputView;

	@DisplayName("입력 값이 정상적으로 들어왔는지 테스트")
	@Test
	void inputCarNamesTest() {
		Scanner scanner = new Scanner(new ByteArrayInputStream("동글,또링,또도링".getBytes()));
		inputView = new InputView(scanner);
		assertThat(inputView.inputCarNames()).isEqualTo("동글,또링,또도링");
	}

	@DisplayName("라운드 횟수가 정상적으로 들어왔는지 테스트")
	@Test
	void inputNumberOfRoundTest() {
		Scanner scanner = new Scanner(new ByteArrayInputStream("3".getBytes()));
		inputView = new InputView(scanner);
		assertThat(inputView.inputNumberOfRound()).isEqualTo(3);
	}

}
