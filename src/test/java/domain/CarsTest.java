package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.NumberGenerator;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    private static final String CAR_A = "carA";
    private static final String CAR_B = "carB";
    private static final String CAR_C = "carC";

    private Cars cars;

    @BeforeEach
    void init() {
        Car carA = new Car(CAR_A);
        Car carB = new Car(CAR_B);
        Car carC = new Car(CAR_C);
        cars = new Cars(List.of(carA, carB, carC));
    }

    @DisplayName("moveAll 메서드는 모든 자동차를 움직일 수 있다.")
    @Test
    void should_MoveAllCars_When_UsingMoveAllMethod() {
        //given
        NumberGenerator numberGenerator = new TestNumberGenerator(List.of(0, 9, 9));

        //when
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
        NumberGenerator numberGenerator = new TestNumberGenerator(List.of(9, 0, 9));

        //when
        cars.moveAll(numberGenerator);
        Cars winners = cars.findWinners();

        //then
        assertThat(winners.getCars())
                .extracting("name")
                .containsExactly(CAR_A, CAR_C);
    }

    static class TestNumberGenerator implements NumberGenerator {

        private final List<Integer> testNumberList;
        private int index = 0;

        public TestNumberGenerator(List<Integer> testNumberList) {
            this.testNumberList = testNumberList;
        }

        @Override
        public int generate() {
            return testNumberList.get(index++);
        }
    }
}
