package racingcar.domain.car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.exception.InvalidInputException;

class CarNameTest {
    @ParameterizedTest
    @ValueSource(strings = {"일", "오오오오오"})
    void 자동차_이름이_생성_성공(final String name) {
        //when
        final CarName carName = new CarName(name);

        //then
        assertThat(carName.getName()).isEqualTo(name);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "   ", "육육육육육육"})
    void 자동차_이름의_길이가_유효하지_않으면_실패(final String name) {
        // when
        assertThatThrownBy(() -> new CarName(name)).isInstanceOf(InvalidInputException.class);
    }
}