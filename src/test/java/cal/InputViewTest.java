package cal;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class InputViewTest {
	@Test
	void 식_예외_검사() {
		assertThrows(IllegalArgumentException.class, () -> {
			InputView.checkExpression("5");
			InputView.checkExpression("5+3");
			InputView.checkExpression("5 +3");
			InputView.checkExpression("5 +3");
			InputView.checkExpression("5 + 3 /");
			InputView.checkExpression("5 + 3 / as");
		});
	}
}