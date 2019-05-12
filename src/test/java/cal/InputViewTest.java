/*
 * @(#)InputViewTesst.java      1.0 2019/05/12
 *
 * Copyright (c) 2019 Hyogeon Kim,
 * Calculator, Java, Seoul, KOREA
 */
package cal;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @version 1.0 2019년 05년 12일
 * @author 김효건
 */
class InputViewTest {
	/*계산기 입력 형식을 검사하는 클래스*/
	@Test
	void 식형태검사() {
		assertThat(InputView.checkExpression("5 + 3 + 2 * 5 * 2321 / 2 * -51512")).isEqualTo(true);
		assertThat(InputView.checkExpression("-5 + 3")).isEqualTo(true);
		assertThat(InputView.checkExpression("-5 + -3")).isEqualTo(true);
		assertThat(InputView.checkExpression("-5+ 3")).isEqualTo(false);
		assertThat(InputView.checkExpression("-5 + 3 /")).isEqualTo(false);
		assertThat(InputView.checkExpression("-5 +  3")).isEqualTo(false);
		assertThat(InputView.checkExpression("-5 +* 3")).isEqualTo(false);
		assertThat(InputView.checkExpression("5 + 3 + 2 * 5 * b / 2 * -51512")).isEqualTo(false);
		assertThat(InputView.checkExpression("-5 + d")).isEqualTo(false);
	}
}