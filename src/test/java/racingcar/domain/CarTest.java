package racingcar.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {
    @DisplayName("Car의 이름을 null 또는 빈문자로 주었을때")
    @Test
    public void car_이름_null_또는_빈문자() {
        String carName = "";
        assertThatThrownBy(() -> {
            Car car = new Car(carName);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("Car의 이름이 한글 혹은 영어로 이루어지지 않은 경우")
    @Test
    public void car_이름_한글_영어_이외() {
        String carName = "";
        assertThatThrownBy(() -> {
            Car car = new Car(carName);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("Car의 이름의 길이가 5 초과인 경우")
    @Test
    public void car_이름_길이_5_초과() {
        String carName = "pobbbbbbi";
        assertThatThrownBy(() -> {
            Car car = new Car(carName);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
