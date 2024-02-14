package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import net.bytebuddy.implementation.bytecode.Throw;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CarsTest {

    @DisplayName("경주에 참가한 자동차들에 대한 예외 발생 테스트")
    @Nested
    class CarsExceptionTest {
        @DisplayName("참가 자동차가 2대 미만 이라면 예외를 발생시킨다.")
        @Test
        void carsMinSizeExceptionTest() {
            assertThatThrownBy(() -> Cars.from(List.of(Car.from("pobi"))))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("참가 자동차가 20대를 초과한다면 예외를 발생시킨다.")
        @Test
        void carsMaxSizeExceptionTest() {
            List<Car> cars = new ArrayList<>();
            for (int i = 65; i < 86; i++) {
                cars.add(Car.from("car" + (char) i));
            }
            assertThatThrownBy(() -> Cars.from(cars))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("중복된 자동차 이름이 있으면 예외가 발생한다.")
        @Test
        void carsDuplicationExceptionTest() {
            assertThatThrownBy(() -> Cars.from(List.of(Car.from("pobi"), Car.from("pobi"))))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @DisplayName("경주에 참가한 자동차들에 대한 성공 테스트")
    @Nested
    class CarsSuccessTest {

        @DisplayName("2대의 자동차가 참여하는 것은 예외가 발생하지않는다.")
        @Test
        void successTest1() {
            assertThatCode(() -> Cars.from(List.of(Car.from("pobi"), Car.from("jun"))))
                    .doesNotThrowAnyException();
        }

        @DisplayName("20대의 자동차까지는 참가를 허용한다.")
        @Test
        void successTest2() {
            List<Car> cars = new ArrayList<>();
            for (int i = 65; i < 85; i++) {
                cars.add(Car.from("car" + (char) i));
            }
            assertThatCode(() -> Cars.from(cars))
                    .doesNotThrowAnyException();
        }
    }
}