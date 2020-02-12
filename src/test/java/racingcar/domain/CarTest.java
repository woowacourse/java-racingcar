package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {
    @Test
    void 자동차_이름이_빈_문자열인지_검증() {
        String input = "";
        assertThatThrownBy(() -> {
            Car.validateEmptyName(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_이름이_5자초과인_경우_검증_실패() {
        String input = "두강두강무늬무늬";
        assertThatThrownBy(() -> {
            Car.validateNameLength(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 위치를_알려주는_기능_테스트() {
        Car car = new Car("무늬");
        assertThat(car.getLocation()).isEqualTo(0);
    }

    @Test
    void print() {
        Car car = new Car("무늬");
        System.out.println(car.getResult());
    }
}
