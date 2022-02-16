package racingcar.servicetest;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import racingcar.service.CheckingService;

public class CheckingServiceTest {
	@Test
	public void 자동차_이름_공백_빈칸() {
		assertThatThrownBy(() -> CheckingService.checkCarNamesBlank(""))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	public void 자동차_이름_공백_NULL() {
		assertThatThrownBy(() -> CheckingService.checkCarNamesBlank(null))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	public void 자동차_이름_예외처리() {
		assertThatThrownBy(() -> CheckingService.checkCarNameLength("배카라쿠배네"))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	public void 횟수_숫자_확인() {
		assertThatThrownBy(() -> CheckingService.checkGameTurnNumber("two"))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	public void 횟수_양수_확인() {
		assertThatThrownBy(() -> CheckingService.checkGameTurnNumber("-2"))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	public void 횟수_양수_확인_0() {
		assertThatThrownBy(() -> CheckingService.checkGameTurnNumber("0"))
			.isInstanceOf(IllegalArgumentException.class);
	}
}
