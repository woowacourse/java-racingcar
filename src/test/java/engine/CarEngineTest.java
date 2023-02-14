package engine;

import domain.Car;
import domain.Cars;
import domain.Name;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.NumberMovableGenerator;
import utils.NumberNonMovableGenerator;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarEngineTest {

    @Test
    @DisplayName("moveCar() : 값이 3일 경우에는 자동차는 움직이지 않는다.")
    void test_notMoveCar() throws Exception {
        //given
        CarEngine carEngine = new CarEngine(new NumberNonMovableGenerator());

        Cars cars = new Cars(List.of(new Car(Name.fromName("a"))));

        //when
        carEngine.moveCar(cars);

        //then
        assertThat(cars.getCars()).extracting("distance")
                                  .containsExactly(0);
    }

    @Test
    @DisplayName("moveCar() : 값이 4일 경우에는 자동차는 움직인다.")
    void test_moveCar() throws Exception {
        //given
        CarEngine carEngine = new CarEngine(new NumberMovableGenerator());

        Cars cars = new Cars(List.of(new Car(Name.fromName("a"))));

        //when
        carEngine.moveCar(cars);

        //then
        assertThat(cars.getCars()).extracting("distance")
                                  .containsExactly(1);
    }
}
