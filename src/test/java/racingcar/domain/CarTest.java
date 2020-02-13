package racingcar.domain;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import racingcar.domian.Car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {

    @ParameterizedTest
    @CsvSource(value = {"1,false", "2,false", "3,false", "4,true", "5,true", "6,true", "7,true", "8,true", "9,true"})
    void 생성된_랜덤값이_4이상이면_이동한다(int inputValue, boolean expected) {
        Car car = new Car("user");
        Car expectedCar = new Car(1, "user");
        car.move(inputValue);
        assertThat(car.equals(expectedCar)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,user1,''", "2,user2,''", "3,user3,user3"})
    void 우승자_찾기(int position, String name, String expected) {
        int max = 3;
        Car car = new Car(position, name);
        assertThat(car.isWinner(max)).isEqualTo(expected);
    }

    @ParameterizedTest
    @NullAndEmptySource
    void 입력값이_null_혹은_empty(String input) {
        assertThatThrownBy(() -> {
            new Car(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("빈 값 혹은 Null");
    }

    @Test
    void 이름이_5자_초과() {
        assertThatThrownBy(() -> {
            new Car("아무거나 입력했어요");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름 길이 5자 초과");
    }
}
