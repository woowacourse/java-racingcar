package cal;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class InputViewTest {
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