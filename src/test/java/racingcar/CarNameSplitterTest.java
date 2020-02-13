package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.CarNameSplitter;
import racingcar.domain.Name;

import java.util.ArrayList;
import java.util.List;

/**
 * 자동차 이름 분리 테스트 클래스
 *
 * @version 1.0.0
 * @author K.S.KIM
 * @author HyoChan
 * @since 2020/02/13
 */
public class CarNameSplitterTest {
    private List<Name> names = new ArrayList<>();

    @BeforeEach
    void initilize() {
        names.add(new Name("pobi"));
        names.add(new Name("crong"));
        names.add(new Name("honux"));
        names.add(new Name("alt"));
        names.add(new Name("ravie"));
    }

    @ParameterizedTest
    @DisplayName("입력 받은 자동차 이름을 split하는 경우")
    @ValueSource(strings = {"pobi, crong, honux, alt, ravie", "pobi,crong,honux,alt,ravie"})
    void splitCarName(String input) {
        Assertions.assertThat(CarNameSplitter.split(input))
                .isEqualTo(names);
    }
}
