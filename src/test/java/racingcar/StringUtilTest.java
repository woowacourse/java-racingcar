package racingcar;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import racingcar.util.StringUtil;

@SuppressWarnings("NonAsciiCharacters")
public class StringUtilTest {

	@Test
	public void 컴마_기준으로_분리해서_가져오기_테스트() {
		List<String> carNames = StringUtil.split("이브,클레이,포비");
		assertThat(carNames.get(0)).isEqualTo("이브");
		assertThat(carNames.get(1)).isEqualTo("클레이");
		assertThat(carNames.get(2)).isEqualTo("포비");
	}

	@Test
	public void 시도_횟수_입력_테스트() {
		int gameCount = StringUtil.getTrialCount("3");
		assertThat(gameCount).isEqualTo(3);
	}

	@Test
	public void 숫자가_아닌_시도_횟수_테스트() {
		assertThatThrownBy(() -> StringUtil.getTrialCount("이브"))
			.isInstanceOf(RuntimeException.class)
			.hasMessageContaining("시도 횟수가 숫자가 아닙니다.");
	}

	@ParameterizedTest
	@ValueSource(strings = {"-1", "0"})
	public void 시도_횟수_음수_혹은_0_테스트(String trial) {
		assertThatThrownBy(() -> StringUtil.getTrialCount(trial))
			.isInstanceOf(RuntimeException.class)
			.hasMessageContaining("시도 횟수가 음수나 0이 될 수 없습니다.");
	}
}
