package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.CarName;

import static org.assertj.core.api.Assertions.*;

public class CarNameTest {

    @DisplayName("1~5 범위 넘어가는 이름 체크")
    @ParameterizedTest
    @ValueSource(strings = {"sixsix", ""})
    void checkNameLength(String value) {
        assertThatThrownBy(() -> {
            CarName carName = new CarName(value);
        }).isInstanceOf(RuntimeException.class);
    }

}
