package racing.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {
    private final Car boxster = new Car("박스터");
    private final Car sonata = new Car("소나타");
    private final Car benz = new Car("벤츠");

    private final List<Car> dummy = List.of(
            boxster,
            sonata,
            benz
    );


    @Test
    @DisplayName("Position이 가장 큰 Car를 여러개 반환한다.")
    void getFirstCarsTest() {
        Cars cars = new Cars(dummy);

        int moveNumber = 4;
        boxster.move(moveNumber);
        sonata.move(moveNumber);

        List<Car> firstCars = cars.findFirstCars();

        assertThat(firstCars).containsOnly(boxster, sonata);
    }

    @Test
    @DisplayName("Position이 가장 큰 Car 하나를 반환한다.")
    void getFirstPositionTest() {
        Cars cars = new Cars(dummy);

        int moveNumber = 4;
        boxster.move(moveNumber);

        List<Car> firstCars = cars.findFirstCars();

        assertThat(firstCars).containsOnly(boxster);
    }
}
