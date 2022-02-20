package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;
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
}
