package domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {

    @ParameterizedTest
    @ValueSource(strings = {"자동차", "1", "일이삼사오"})
    void 자동차_생성_성공_테스트(final String name) {
        final Car car = new Car(name);

        assertThat(car.getName()).isEqualTo(name);
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(strings = {"123456", "일이삼사오육"})
    void 자동차_생성_이름길이_예외_테스트(final String name) {
        assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @NullAndEmptySource
    void 자동차_생성_이름_공백또는Null_예외_테스트(final String name) {
        assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"-1:false", "0:false", "3:false", "4:true", "5:true", "9:true"}, delimiter = ':')
    void 자동차_전진_또는_유지_테스트(final int power, final boolean expected) {
        final Car car = new Car("자동차");

        assertThat(car.moveOrStayByPower(power)).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, Integer.MAX_VALUE})
    void 자동차_전진_후_위치증가_테스트(final int count) {
        final Car car = new Car("자동차");

        for (int i = 0; i < count; i++) {
            car.moveOrStayByPower(4);
        }

        assertThat(car.getPosition()).isEqualTo(count);
    }
}
