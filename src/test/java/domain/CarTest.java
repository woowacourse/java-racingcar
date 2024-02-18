package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DisplayName("자동차 테스트")
class CarTest {

    @Nested
    @DisplayName("자동차 이름 테스트")
    class CarNameTest {

        @ParameterizedTest
        @ValueSource(strings = {"A", "ABCDE"})
        @DisplayName("정상적인 자동차 이름인가")
        void valid_car_name_test(String carName) {
            assertThatCode(() -> new Car(carName))
                    .doesNotThrowAnyException();
        }

        @ParameterizedTest
        @ValueSource(strings = {"", "ABCDEF"})
        @DisplayName("비정상적인 자동차 이름인가")
        void invalid_car_name_test(String carName) {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> new Car(carName));
        }
    }

    @Nested
    @DisplayName("자동차 위치 비교 테스트")
    class CarPositionComparisonTest {

        @Test
        @DisplayName("자동차가 올바른 위치에 있는가")
        void is_car_position_at_correct_position_test() {
            // given
            int position = 9;
            Car car = new Car("Mang", position);

            // when
            boolean actual = car.isPositionedAt(position);

            // then
            assertThat(actual).isTrue();
        }

        @Test
        @DisplayName("자동차가 잘못된 위치에 있는가")
        void is_car_position_at_wrong_position_test() {
            // given
            int correctPosition = 3, wrongPosition = 9;
            Car car = new Car("Mang", wrongPosition);

            // when
            boolean actual = car.isPositionedAt(correctPosition);

            // then
            assertThat(actual).isFalse();
        }
    }

    @Nested
    @DisplayName("자동차 움직임 테스트")
    class CarMovementTest {

        @ParameterizedTest
        @ValueSource(ints = {4, 5, 9})
        @DisplayName("자동차가 이동하는가")
        void is_car_moving(int power) {
            // given
            Car car = new Car("Mang");

            // when
            car.move(power);

            // then
            int expected = 1;
            assertThat(car.getPosition()).isEqualTo(expected);
        }

        @ParameterizedTest
        @ValueSource(ints = {0, 1, 3})
        @DisplayName("자동차가 이동하지 않는가")
        void is_car_not_moving(int power) {
            // given
            Car car = new Car("Mang");

            // when
            car.move(power);

            // then
            int expected = 0;
            assertThat(car.getPosition()).isEqualTo(expected);
        }
    }

}
