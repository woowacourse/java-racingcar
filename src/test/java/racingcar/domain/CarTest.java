package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static racingcar.exception.ExceptionMessage.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {
    @ParameterizedTest
    @ValueSource(strings = {"car", "CAR", "_car", "-car", "자동차", "ㅈㄷㅊ"})
    @DisplayName("[Success] 자동차가 정상적으로 생성됨")
    void createCars() {
        assertThatCode(() -> new Car("car"))
                .doesNotThrowAnyException();
    }

    @Nested
    class ValidateCarName {
        @ParameterizedTest
        @NullAndEmptySource
        @ValueSource(strings = {" ", "  ", "\t", "\n"})
        @DisplayName("[Exception] 자동차 이름이 공백이나 null이면 예외를 던진다")
        void createCarByNull(final String name) {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> new Car(name))
                    .withMessage(NOT_NULL_CAR_NAME.getMessage());
        }

        @ParameterizedTest
        @ValueSource(strings = {"!!", ",,"})
        @DisplayName("[Exception] 자동차 이름에 한글, 숫자, 영문, '-', '_' 외에 다른 문자가 포함되면 예외를 던진다")
        void createCarByInvalidCharacter(final String name) {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> new Car(name))
                    .withMessage(INVALID_CAR_NAME.getMessage());
        }

        @Test
        @DisplayName("[Exception] 자동차 이름의 길이가 5를 초과하면 예외를 던진다")
        void createCarByExcessLength() {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> new Car("ABCDEF"))
                    .withMessage(INVALID_CAR_NAME_SIZE.getMessage());
        }
    }

    @Nested
    class CarMovement {
        private Car car;

        @BeforeEach
        void BeforeEach() {
            car = new Car("a");
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
