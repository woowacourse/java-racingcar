package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.SoftAssertions.assertSoftly;

class CarsTest {

    @Test
    @DisplayName("자동차들의 라운드 진행 테스트")
    void getTurnCountTest() {
        Car car1 = new Car("test1");
        Car car2 = new Car("test2");

        Cars cars = new Cars();
        cars.add(car1);
        cars.add(car2);

        cars.addNextCarValue(1);
        cars.addNextCarValue(1);

        int firstTurnCount = cars.getTurnCount();

        cars.addNextCarValue(5);
        cars.addNextCarValue(5);

        int secondTurnCount = cars.getTurnCount();

        assertSoftly(softly -> {
            softly.assertThat(firstTurnCount).isEqualTo(1);
            softly.assertThat(secondTurnCount).isEqualTo(2);
        });

    }

}