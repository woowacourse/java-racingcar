package racingcargame.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@SuppressWarnings("NonAsciiCharacters")
public class EngineTest {

	@ParameterizedTest
	@CsvSource(value = {"3:false", "4:true", "5:true"}, delimiter = ':')
	void 전진가능한_엔진인지_검사(int power, boolean result) {
		Engine engine = Engine.createBy(power);
		assertThat(engine.canMove()).isEqualTo(result);
	}
}
