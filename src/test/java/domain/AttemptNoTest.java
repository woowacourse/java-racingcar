package domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import org.junit.jupiter.api.Test;

public class AttemptNoTest {
	@Test
	void createAttemptNumber_적합한_횟수() {
		new AttemptNo("1");
	}

	@Test
	void createAttemptNumber_부적합한_횟수_문자() {
		assertThatThrownBy(() -> new AttemptNo("타미"))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void createAttemptNumber_부적합한_횟수_음수() {
		assertThatThrownBy(() -> new AttemptNo("-1"))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void isEndTest_1이상() {
		AttemptNo attemptNo = new AttemptNo("1");
		assertThat(attemptNo.isEnd()).isFalse();
	}

	@Test
	void isEndTest_1미만() {
		AttemptNo attemptNo = new AttemptNo("1");
		attemptNo.execute();        // No -> 0
		assertThat(attemptNo.isEnd()).isTrue();
	}

	@Test
	void executeTest_실행_가능할_때() {
		AttemptNo attemptNo = new AttemptNo("1");
		assertThat(attemptNo.execute()).isTrue();
	}

	@Test
	void executeTest_실행_불가능할_때() {
		AttemptNo attemptNo = new AttemptNo("1");
		attemptNo.execute();		// No -> 0
		assertThat(attemptNo.execute()).isFalse();
	}
}
