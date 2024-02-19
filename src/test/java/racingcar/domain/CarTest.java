package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {
    @ParameterizedTest
    @ValueSource(strings = {"car", "CAR", "_car", "-car", "자동차", "ㅈㄷㅊ"})
    @DisplayName("[Success] 자동차가 정상적으로 생성됨")
    void createCars() {
        assertThatCode(() -> Car.from("Car"))
                .doesNotThrowAnyException();
    }

    @Nested
    @DisplayName("자동차 전진을 요청 받으면")
    class CarMovement {
        private Car car;

        @BeforeEach
        void BeforeEach() {
            car = Car.from("car");
        }

        @ParameterizedTest
        @ValueSource(ints = {4, 5, 6, 7, 8, 9})
        @DisplayName("[Success] 4 이상 9 이하의 값을 받으면 전진한다.")
        void moveCar(final int threshold) {
            car.move(threshold);

            assertThat(car.getCarStatus().position())
                    .isEqualTo(1);
        }

        @ParameterizedTest
        @ValueSource(ints = {0, 1, 2, 3})
        @DisplayName("[Success] 0 이상 3 이하의 값을 받으면 전진하지 않는다.")
        void noMoveCar(final int threshold) {
            car.move(threshold);

            assertThat(car.getCarStatus().position())
                    .isEqualTo(0);
        }
    }
}
