package racingcar.domain.car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.exception.InvalidInputException;

class CarNameTest {
    @ParameterizedTest
    @ValueSource(strings = {"한글", "en", "123", "한en12"})
    void 자동차_이름이_생성_성공(final String name) {
        //when
        final CarName carName = new CarName(name);

        //then
        assertThat(carName.getName()).isEqualTo(name);
    }

    @Nested
    class 유효하지_않은_자동차_이름일_경우_실패 {
        @ParameterizedTest
        @ValueSource(strings = {"", "   ", "육육육육육육"})
        void 자동차_이름의_길이가_유효하지_않은_경우(final String name) {
            // when
            assertThatThrownBy(() -> new CarName(name)).isInstanceOf(InvalidInputException.class);
        }

        @ParameterizedTest
        @ValueSource(strings = {"en!!", "한글##", "12345%%"})
        void 자동차_이름의_형식이_유효하지_않은_경우(final String name) {
            // when
            assertThatThrownBy(() -> new CarName(name)).isInstanceOf(InvalidInputException.class);
        }
    }
}