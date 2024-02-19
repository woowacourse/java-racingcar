package domain.car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

import domain.moveStrategy.GeneratedNumberMoveStrategy;
import domain.moveStrategy.OnlyGoMoveStrategy;
import domain.numbergenerator.RandomNumberGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {

    public static final GeneratedNumberMoveStrategy DEFAULT_STRATEGY =
            new GeneratedNumberMoveStrategy(new RandomNumberGenerator());
    public static final String DEFAULT_NAME = "pobi";
    private Car car;

    @BeforeEach
    void setup() {
        car = new Car(DEFAULT_NAME, DEFAULT_STRATEGY);
    }

    @Nested
    @DisplayName("객체 생성 테스트")
    class ObjectCreateTest {
        @Test
        @DisplayName("객체가 정상적으로 생성된다.")
        void createObjectTest() {
            assertThatCode(() -> new Car(DEFAULT_NAME, DEFAULT_STRATEGY))
                    .doesNotThrowAnyException();
        }

        @Test
        @DisplayName("초기 이름이 정상적으로 설정된다.")
        void checkInitNameTest() {
            assertThat(car.createResult().name())
                    .isEqualTo(DEFAULT_NAME);
        }

        @Test
        @DisplayName("초기 위치가 0으로 설정된다.")
        void checkInitLocationTest() {
            assertThat(car.createResult().location())
                    .isEqualTo(0);
        }
    }

    @Nested
    @DisplayName("이동 및 위치 테스트")
    class MoveAndLocationTest {
        @ParameterizedTest(name = "{0}번 움직인 자동차의 위치는 {0}이다.")
        @ValueSource(ints = {0, 1, 2, 3})
        void MoveTest(int moveCount) {
            Car car = new Car(DEFAULT_NAME, new OnlyGoMoveStrategy());
            for (int moveRound = 0; moveRound < moveCount; moveRound++) {
                car.tryMove();
            }
            assertThat(car.createResult().location())
                    .isEqualTo(moveCount);
        }
    }
}
