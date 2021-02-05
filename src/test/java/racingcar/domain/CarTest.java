package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {

    @DisplayName("이름에 따른 equals 테스트")
    @Test
    public void equalsTest() {
        Car car1 = Car.from("car");
        Car car2 = Car.from("car");
        assertThat(car1).isEqualTo(car2);
    }

    @DisplayName("이름 길이 제한으로 인한 예외 발생 테스트")
    @Test
    public void nameLengthExceptionTest() {
        assertThatThrownBy(() -> Car.from("abcdefg")).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차 position을 기준으로 하는 compare 메소드 테스트")
    @Test
    public void compareTest() {
        Car car1 = Car.from("car1");
        Car car2 = Car.from("car2");
        IntStream.rangeClosed(0, Integer.MAX_VALUE / 256)
                .forEach(i -> car2.move()); // 높은 확률로
        assertThat(car1.compareTo(car2)).isEqualTo(-1);
    }
}
