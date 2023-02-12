package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.NumberGenerator;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    private static final String CAR_A_NAME = "carA";
    private static final String CAR_B_NAME = "carB";
    private static final String CAR_C_NAME = "carC";

    @DisplayName("moveAll 메서드는 모든 자동차를 움직일 수 있다.")
    @Test
    void should_MoveAllCars_When_UsingMoveAllMethod() {
        //given
        Car carA = Car.from(CAR_A_NAME);
        Car carB = Car.from(CAR_B_NAME);
        Car carC = Car.from(CAR_C_NAME);
        Cars cars = new Cars(List.of(carA, carB, carC));

        //when
        NumberGenerator numberGenerator = new TestNumberGenerator(List.of(0, 9, 9));
        cars.moveAll(numberGenerator);

        //then
        assertThat(cars.getCars())
                .extracting("position")
                .containsExactly(0, 1, 1);
    }

    @DisplayName("findWinners 메서드는 우승한 자동차들을 반환한다.")
    @Test
    void should_ReturnWinners_When_UsingFindWinnersMethod() {
        //given
        Car carA = Car.of(CAR_A_NAME, 3);
        Car carB = Car.of(CAR_B_NAME, 0);
        Car carC = Car.of(CAR_C_NAME, 3);
        Cars cars = new Cars(List.of(carA, carB, carC));

        //when
        Cars winners = cars.findWinners();

        //then
        assertThat(winners.getCars())
                .extracting("name")
                .containsExactly(CAR_A_NAME, CAR_C_NAME);
    }

    static class TestNumberGenerator implements NumberGenerator {

        private final List<Integer> testNumberList;
        private int index = 0;

        public TestNumberGenerator(final List<Integer> testNumberList) {
            this.testNumberList = testNumberList;
        }

        @Override
        public int generate() {
            return testNumberList.get(index++);
        }
    }
}
