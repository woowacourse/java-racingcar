package domain;

import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Cars;

class CarsTest {

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
        Car pobi = new Car("pobi");
        Car neo = new Car("neo");
        Car hiiro = new Car("hiiro");

        for(int i = 0; i < 2; i++) {
            pobi.increasePosition();
            neo.increasePosition();
        }

        Cars cars = new Cars(new ArrayList<>(List.of(pobi, neo, hiiro)));

        //When
        List<Car> result = cars.decideWinner();

        //Then
        assertThat(result.size()).isEqualTo(2);
    }
}