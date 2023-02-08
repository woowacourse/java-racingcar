package racing.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {

    Car boxster = new Car("박스터");
    Car sonata = new Car("소나타");

    List<Car> dummy = List.of(
            boxster,
            sonata,
            new Car("벤츠")
    );

    @Test
    @DisplayName("Position이 가장 큰 Car List를 반환한다.")
    void getFirstPositionTest() {
        Cars cars = new Cars(dummy);

        boxster.move();
        sonata.move();

        List<Car> firstPosition = cars.getFirstPosition();

        assertThat(firstPosition).containsOnly(boxster, sonata);
    }
}