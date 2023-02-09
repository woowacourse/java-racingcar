package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

class CarsTest {

    private Cars cars;

    @BeforeEach
    void setup() {
        cars = new Cars();
        cars.add(new Car("test1"));
        cars.add(new Car("test2"));
        cars.add(new Car("test3"));
    }


    @Test
    @DisplayName("자동차들의 라운드 진행 테스트")
    void getTurnCountTest() {
        cars.addNextCarValue(1);
        cars.addNextCarValue(1);
        cars.addNextCarValue(1);

        int firstTurnCount = cars.getTurnCount();

        cars.addNextCarValue(5);
        cars.addNextCarValue(5);
        cars.addNextCarValue(5);

        int secondTurnCount = cars.getTurnCount();

        assertSoftly(softly -> {
            softly.assertThat(firstTurnCount).isEqualTo(1);
            softly.assertThat(secondTurnCount).isEqualTo(2);
        });
    }

    @Test
    @DisplayName("자동차들의 라운드 턴수가 다른 예외 상황 테스트")
    void turnCountExceptionTest() {
        for (int i = 0; i < 4; i++) {
            cars.addNextCarValue(4);
        }
        assertThatThrownBy(() -> cars.getTurnCount()).isInstanceOf(IllegalStateException.class);
    }

    @Test
    @DisplayName("우승자를 확인하는 기능 테스트")
    void getWinnersTest() {
        cars.addNextCarValue(4);
        cars.addNextCarValue(7);
        cars.addNextCarValue(1);
        cars.addNextCarValue(9);
        cars.addNextCarValue(8);
        cars.addNextCarValue(2);

        assertThat(cars.getWinners()).containsExactly("test1", "test2");
    }
}