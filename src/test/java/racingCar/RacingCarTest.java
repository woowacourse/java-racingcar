package racingCar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class RacingCarTest {
	@Test
	void 자동차_이름_정상_입력() {
		String[] names = RacingCar.getCarName("a,bqwer,cdb");
		assertThat(names).isEqualTo(new String[] {"a", "bqwer", "cdb"});
	}

	@Test
	void 자동차_이름_중복() {
		String[] names = RacingCar.getCarName("a,a,c");
		assertThat(names).isEqualTo(new String[] {"a", "a", "c"});
	}

	@Test
	void 자동차_이름_앞뒤_공백() {
		String[] names = RacingCar.getCarName("   abc, a ,cde  ");
		assertThat(names).isEqualTo(new String[] {"abc", "a", "cde"});
	}

	@Test
	void 자동차_이름_6자_에러() {
		assertThatThrownBy(() -> RacingCar.getCarName("woowahan,techCourse"))
			.isInstanceOf(RuntimeException.class);
	}

	@Test
	void 자동차_이름_공백_에러() {
		assertThatThrownBy(() -> RacingCar.getCarName(",,a"))
			.isInstanceOf(RuntimeException.class);
	}

}
