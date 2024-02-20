package domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import dto.CarStatus;
import dto.CarsStatus;
import dto.Winners;
import java.util.List;
import org.assertj.core.api.Assertions;
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

    @DisplayName("우승자 결정 테스트")
    @Nested
    class JudgeTest {
        @DisplayName("한 명의 우승자가 결정된다.")
        @Test
        void oneWinnerJudgeTest() {
            // given
            List<String> carNames = List.of("toby", "pobi", "anna");
            Cars cars = Cars.from(carNames);

            // when
            cars.move(new TestOneWinnerGenerator());
            Winners winners = cars.judge();

            // then
            Assertions.assertThat(winners.winners().size()).isEqualTo(1);
            Assertions.assertThat(winners.winners().get(0)).isEqualTo("anna");
        }

        @DisplayName("두 명의 우승자가 결정된다.")
        @Test
        void bothWinnerJudgeTest() {
            // given
            List<String> carNames = List.of("toby", "pobi", "anna");
            Cars cars = Cars.from(carNames);

            // when
            cars.move(new TestBothWinnerGenerator());
            Winners winners = cars.judge();

            // then
            Assertions.assertThat(winners.winners().size()).isEqualTo(2);
            Assertions.assertThat(winners.winners().get(0)).isEqualTo("pobi");
            Assertions.assertThat(winners.winners().get(1)).isEqualTo("anna");
        }
    }

    static class TestOneWinnerGenerator implements NumberGenerator {
        private static List<Integer> numbers = List.of(3, 2, 9);
        private static int index = 0;
        @Override
        public int generate() {
            return numbers.get(index++);
        }
    }

    static class TestBothWinnerGenerator implements NumberGenerator {
        private static List<Integer> numbers = List.of(3, 6, 9);
        private static int index = 0;
        @Override
        public int generate() {
            return numbers.get(index++);
        }
    }
}
