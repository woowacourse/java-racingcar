package domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import dto.CarStatus;
import dto.CarsStatus;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class CarsTest {
    @Nested
    @DisplayName("자동차 생성 테스트")
    class CarGenerationTest {
        @DisplayName("자동차들이 성공적으로 생성된다.")
        @Test
        void success() {
            List<String> carNames = List.of(
                    "toby", "tebah", "anna"
            );
            assertDoesNotThrow(() -> Cars.from(carNames));
        }

        @DisplayName("자동차들의 이름이 중복되어 자동차 생성에 실패한다.")
        @Test
        void fail() {
            List<String> carNames = List.of(
                    "toby", "tebah", "anna", "brown", "brown"
            );
            assertThrows(IllegalArgumentException.class, () ->
                    Cars.from(carNames)
            );
        }
    }


    @DisplayName("이동 테스트")
    @Nested
    class MoveTest {
        @DisplayName("랜덤 값이 4 이상이어서 자동차들이 전진한다.")
        @Test
        void MoveTest() {
            // given
            List<String> carNames = List.of("toby", "pobi", "anna", "brown");
            Cars cars = Cars.from(carNames);

            // when
            CarsStatus carsStatus = cars.move(() -> 7);

            // then
            for (CarStatus status : carsStatus.status()) {
                assertThat(status.position()).isEqualTo(1);
            }
        }

        @DisplayName("랜덤 값이 4 미만이어서 자동차들이 전진하지 않는다.")
        @Test
        void doesNotMoveTest() {
            // given
            List<String> carNames = List.of("toby", "pobi", "anna", "brown");
            Cars cars = Cars.from(carNames);

            // when
            CarsStatus carsStatus = cars.move(() -> 3);

            // then
            for (CarStatus status : carsStatus.status()) {
                assertThat(status.position()).isEqualTo(0);
            }
        }
    }
}
