package calculator.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class NumbersTest {
	@Test
	void sum() {
		assertThat(new Numbers(new String[]{"1","2","3"}).sum()).isEqualTo(6);
	}

	@Test
	void erro() {
		assertThatThrownBy(()->{
			new Numbers(new String[]{"1","-1"});
		}).isInstanceOf(RuntimeException.class);
	}

	@Test
	void error() {
		assertThatThrownBy(()->{
			new Numbers(new String[]{"1","2","d"});
		}).isInstanceOf(RuntimeException.class);
	}
}