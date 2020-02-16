package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class RandomNoTest {

	@Test
	void createRandomNoTest_성공() {
		new RandomNo(9);
		new RandomNo(0);
	}

	@Test
	void createRandomNoTest_실패_0미만() {
		assertThatThrownBy(() -> new RandomNo(-1))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void createRandomNoTest_실패_10초과() {
		assertThatThrownBy(() -> new RandomNo(11))
			.isInstanceOf(IllegalArgumentException.class);

	}

	@Test
	void isMoveTest_성공() {
		assertThat(new RandomNo(4).isMove()).isTrue();
		assertThat(new RandomNo(9).isMove()).isTrue();
	}

	@Test
	void isMoveTest_실패() {
		assertThat(new RandomNo(3).isMove()).isFalse();
		assertThat(new RandomNo(0).isMove()).isFalse();
	}
}
