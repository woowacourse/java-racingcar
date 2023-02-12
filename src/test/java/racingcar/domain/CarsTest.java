package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.constant.ErrorMessage;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

class CarsTest {

    private Cars cars;
    private Rule rule = Rule.MOVING_FORWARD_STANDARD;

    @BeforeEach
    void setup() {
        cars = new Cars(List.of(
                new Car("test1"),
                new Car("test2"),
                new Car("test3")
        ));
    }


    @Test
    @DisplayName("자동차들의 라운드 진행 테스트")
    void getTurnCountTest() {
        cars.moveNextCarWith(1, rule);
        cars.moveNextCarWith(1, rule);
        cars.moveNextCarWith(1, rule);

        int firstTurnCount = cars.getCurrentRound();

        cars.moveNextCarWith(5, rule);
        cars.moveNextCarWith(5, rule);
        cars.moveNextCarWith(5, rule);

        int secondTurnCount = cars.getCurrentRound();

        assertSoftly(softly -> {
            softly.assertThat(firstTurnCount).isEqualTo(1);
            softly.assertThat(secondTurnCount).isEqualTo(2);
        });
    }

    @Test
    @DisplayName("자동차들의 라운드 턴수가 다른 예외 상황 테스트")
    void turnCountExceptionTest() {
        for (int i = 0; i < 4; i++) {
            cars.moveNextCarWith(4, rule);
        }
        assertThatThrownBy(() -> cars.getCurrentRound())
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining(ErrorMessage.ROUND_NOT_OVER.getMessage());
    }

    @Test
    @DisplayName("라운드 결과 테스트")
    void getRoundResultTest() {
        cars.moveNextCarWith(4, rule);
        cars.moveNextCarWith(7, rule);
        cars.moveNextCarWith(1, rule);

        cars.moveNextCarWith(9, rule);
        cars.moveNextCarWith(8, rule);
        cars.moveNextCarWith(2, rule);

        Map<String, Integer> actualResult = cars.getRoundResult();

        assertSoftly(softly -> {
            softly.assertThat(actualResult.get("test1")).isEqualTo(2);
            softly.assertThat(actualResult.get("test2")).isEqualTo(2);
            softly.assertThat(actualResult.get("test3")).isEqualTo(0);
        });
    }

    @Test
    @DisplayName("우승자를 확인하는 기능 테스트")
    void getWinnersTest() {
        cars.moveNextCarWith(4, rule);
        cars.moveNextCarWith(7, rule);
        cars.moveNextCarWith(1, rule);
        cars.moveNextCarWith(9, rule);
        cars.moveNextCarWith(8, rule);
        cars.moveNextCarWith(2, rule);

        assertThat(cars.getWinners()).containsExactly("test1", "test2");
    }
}
