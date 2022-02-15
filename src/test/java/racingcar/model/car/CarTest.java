package racingcar.model.car;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

@SuppressWarnings("NonAsciiCharacters")
class CarTest {
    @Test
    public void 자동차_생성() {
        // given
        String name = "test1";

        // when
        Car car = new Car(name);

        // then
        assertThat(car).isNotNull();
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "123456", " "})
    public void 자동차_생성_실패(String name) {
        // then
        assertThatThrownBy(() -> new Car(name)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"4:1", "3:0"}, delimiter = ':')
    public void goOrStop_테스트(int random, int expected) {
        // given
        Car car = new Car("test");

        // when
        car.goOrStop(random);

        // then
        assertThat(car.getPosition()).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"0:true", "1:false"}, delimiter = ':')
    public void 가장_멀리_간_위치인지_비교(int maxPosition, boolean expected) {
        // given
        Car car = new Car("foo");

        // then
        assertThat(car.isSameWithPosition(maxPosition)).isEqualTo(expected);
    }
}