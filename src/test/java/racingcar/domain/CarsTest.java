package racingcar.domain;

import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {

    @Test
    @DisplayName("자동차 이름이 없어서 빈 리스트가 넘어오면 오류가 발생한다.")
    void carsGenerateTest() {
        //Given
        List<Car> testCase = new ArrayList<>();

        //When
        Throwable result = catchThrowable(() -> {
            new Cars(testCase);
        });

        //Then
        assertThat(result).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("우승한 자동차를 제공한다.")
    void decideWinnerTest() {
        //Given
        Car pobi = new Car("pobi", new TestNumberGenerator(new ArrayList<>(List.of(3, 4, 5))));
        Car neo = new Car("neo", new TestNumberGenerator(new ArrayList<>(List.of(3, 4, 5))));
        Car hiiro = new Car("hiiro", new TestNumberGenerator(new ArrayList<>(List.of(1, 4, 2))));

        for (int i = 0; i < 3; i++) {
            pobi.goForward();
            neo.goForward();
            hiiro.goForward();
        }

        Cars cars = new Cars(new ArrayList<>(List.of(pobi, neo, hiiro)));

        //When
        List<Car> result = cars.findAllWinner();

        //Then
        assertThat(result.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("모든 자동차들이 전진을 1회 시도한다.")
    void eachCarMoveTest() {
        //Given
        Car pobi = new Car("pobi", new TestNumberGenerator(new ArrayList<>(List.of(3))));
        Car neo = new Car("neo", new TestNumberGenerator(new ArrayList<>(List.of(4))));
        Cars cars = new Cars(new ArrayList<>(List.of(pobi, neo)));

        //When
        List<Car> result = cars.moveEachCar();

        //Then
        assertThat(result.get(0).getPosition()).isEqualTo(0);
        assertThat(result.get(1).getPosition()).isEqualTo(1);
    }


    static class TestNumberGenerator implements NumberGenerator {

        private final List<Integer> numbers;

        public TestNumberGenerator(List<Integer> numbers) {
            this.numbers = numbers;
        }

        @Override
        public int generate() {
            return numbers.remove(0);
        }
    }
}
