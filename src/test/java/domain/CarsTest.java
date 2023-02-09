package domain;

import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.NumberGenerator;

class CarsTest {

    private NumberGenerator numberGenerator = new TestNumberGenerator(new ArrayList<>(List.of(3,4,5)));

    @Test
    void carsGenerateTest(){
        //Given
        List<Car> testCase = new ArrayList<>();

        //When
        Throwable result = catchThrowable(()->{new Cars(testCase);});

        //Then
        assertThat(result).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void decideWinnerTest() {
        //Given
        Car pobi = new Car("pobi", new TestNumberGenerator(new ArrayList<>(List.of(3,4,5))));
        Car neo = new Car("neo", new TestNumberGenerator(new ArrayList<>(List.of(3,4,5))));
        Car hiiro = new Car("hiiro", new TestNumberGenerator(new ArrayList<>(List.of(1,4,2))));

        for(int i = 0; i < 3; i++) {
            pobi.goForward();
            neo.goForward();
            hiiro.goForward();
        }

        Cars cars = new Cars(new ArrayList<>(List.of(pobi, neo, hiiro)));

        //When
        List<Car> result = cars.decideWinner();

        //Then
        assertThat(result.size()).isEqualTo(2);
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