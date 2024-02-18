package domain.car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import domain.moveStrategy.GeneratedNumberMoveStrategy;
import domain.moveStrategy.NeverGoMoveStrategy;
import domain.moveStrategy.OnlyGoMoveStrategy;
import domain.numbergenerator.RandomNumberGenerator;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class CarsTest {

    public static final GeneratedNumberMoveStrategy DEFAULT_STRATEGY = new GeneratedNumberMoveStrategy(
            new RandomNumberGenerator());
    public static final String DEFAULT_NAME = "pobi";

    @Nested
    @DisplayName("객체 생성 테스트")
    class ObjectCreateTest {
        @Test
        @DisplayName("객체가 정상적으로 생성된다.")
        void createObjectTest() {
            assertThatCode(() -> new Cars(List.of(DEFAULT_NAME), DEFAULT_STRATEGY))
                    .doesNotThrowAnyException();
        }

        @Test
        @DisplayName("입력된 이름이 없으면 예외가 발생한다.")
        void emptyListExceptionTest() {
            assertThatThrownBy(() -> new Cars(Collections.EMPTY_LIST, DEFAULT_STRATEGY))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("중복된 이름을 사용하면 예외가 발생한다.")
        void duplicatedNameExceptionTest() {
            assertThatThrownBy(() -> new Cars(List.of(DEFAULT_NAME, DEFAULT_NAME), DEFAULT_STRATEGY))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Nested
    @DisplayName("우승자 조회 테스트")
    class WinnerTest {

        @Test
        @DisplayName("단독 우승 테스트")
        void OneWinnerTest() {
            Cars cars = new Cars(List.of(
                    new Car("atto", new OnlyGoMoveStrategy()),
                    new Car("takan", new NeverGoMoveStrategy()),
                    new Car("siso", new NeverGoMoveStrategy())
            ));
            for (int round = 1; round <= 3; round++) {
                cars.tryMove();
            }

            assertThat(cars.getWinnersName())
                    .containsExactly("atto");
        }

        @Test
        @DisplayName("공동 우승 테스트")
        void ManyWinnersTest() {
            Cars cars = new Cars(List.of(
                    new Car("atto", new OnlyGoMoveStrategy()),
                    new Car("takan", new NeverGoMoveStrategy()),
                    new Car("siso", new OnlyGoMoveStrategy())
            ));
            for (int round = 1; round <= 3; round++) {
                cars.tryMove();
            }

            assertThat(cars.getWinnersName())
                    .containsExactly("atto", "siso");
        }
    }
}
