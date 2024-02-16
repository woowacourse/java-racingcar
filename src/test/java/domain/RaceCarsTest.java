package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RaceCarsTest {

    @Nested
    @DisplayName("자동차 경주 생성 테스트")
    class CarNameTest {

        @ParameterizedTest
        @CsvSource(value = {"hi"})
        @DisplayName("이름은 중복일 수 없다")
        void invalidateCarName() {
            List<Car> cars = List.of(
                    new Car("hi"),
                    new Car("hi")
            );
            assertThatThrownBy(() -> new RaceCars(cars))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("참여자는 두명 이상이다")
        void invalidateParticipant() {
            List<Car> cars = List.of(
                    new Car("hi")
            );
            assertThatThrownBy(() -> new RaceCars(cars))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Test
    @DisplayName("Car 리스트를 반환한다.")
    void getCars() {
        List<Car> cars = List.of(
                new Car("hi"),
                new Car("hello")
        );

        RaceCars raceCars = new RaceCars(cars);

        assertThat(raceCars.getCars()).isEqualTo(cars);
    }
}