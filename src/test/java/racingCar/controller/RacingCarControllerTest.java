package racingCar.controller;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingCar.domain.RacingCars;

public class RacingCarControllerTest {
	private RacingCarController racingCar = new RacingCarController();

	@Test
	@DisplayName("자동차 이름 정상 입력")
	void separateCarNameTest() {
		String[] names = racingCar.separateCarNames("a,bqwer,cdb");
		assertThat(names).isEqualTo(new String[] {"a", "bqwer", "cdb"});
	}

	@Test
	@DisplayName("자동차 이름 중복 입력")
	void duplicateCarNameTest() {
		String[] names = racingCar.separateCarNames("a,a,c");
		assertThat(names).isEqualTo(new String[] {"a", "a", "c"});
	}

	@Test
	@DisplayName("자동차 이름 공백 제거")
	void trimCarNameTest() {
		String[] names = racingCar.separateCarNames("   abc, a ,cde  ");
		assertThat(names).isEqualTo(new String[] {"abc", "a", "cde"});
	}

	@Test
	@DisplayName("자동차 생성 테스트")
	void makeCarTest() {
		RacingCars racingCars = racingCar.makeCars(new String[] {"runa", "dun"});
		assertThat(racingCars.getRacingCars().size()).isEqualTo(2);
	}
}
