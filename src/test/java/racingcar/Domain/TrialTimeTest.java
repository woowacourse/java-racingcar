package racingcar.Domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * 클래스 이름 : TrialTimeTest.java
 *
 * @author 보스독
 * @author 작은곰
 * @author 토니
 * * @version 1.0
 * <p>
 * 날짜 : 2020/02/15
 */

public class TrialTimeTest {

	@Test
	@DisplayName("TrialTime 생성자 정상 케이스 테스트")
	void TrialTime_생성자_테스트() {
		//given
		int inputTrialTime = 1;
		//when
		TrialTime trialTime = new TrialTime(inputTrialTime);
		//then
		assertThat(trialTime).isInstanceOf(TrialTime.class);
	}

	@Test
	@DisplayName("시도횟수가 null")
	void TrialTime_생성자_null일시_예외처리() {
		//given
		Integer inputTrialTime = null;
		//when then
		assertThatNullPointerException().isThrownBy(() -> new TrialTime(inputTrialTime));
	}

	@Test
	@DisplayName("시도횟수가 음수")
	void TrialTime_생성자_음수일시_예외처리() {
		//given
		int inputTrialTime = -1;
		//when then
		assertThatIllegalArgumentException().isThrownBy(() -> new TrialTime(inputTrialTime));
	}

	@Test
	@DisplayName("시도횟수가 0")
	void TrialTime_생성자_0일시_예외처리() {
		//given
		int inputTrialTime = -1;
		//when then
		assertThatIllegalArgumentException().isThrownBy(() -> new TrialTime(inputTrialTime));
	}

	@Test
	@DisplayName("시도횟수가 최대범위 초과")
	void TrialTime_생성자_최대범위_초과() {
		//given
		int inputTrialTime = 1000;
		//when then
		assertThatIllegalArgumentException().isThrownBy(() -> new TrialTime(inputTrialTime));
	}
}
