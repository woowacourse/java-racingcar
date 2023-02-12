package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    private final Car boxster = new Car("박스터");
    private final Car sonata = new Car("소나타");
    private final Car benz = new Car("벤츠");

    List<Car> dummy = List.of(
            boxster,
            sonata,
            benz
    );

    @Test
    @DisplayName("Position이 가장 큰 Car List를 반환한다.")
    void getFirstPositionTest() {
        Cars cars = new Cars(dummy);

        boxster.move(4);
        sonata.move(4);

        List<Car> firstPosition = cars.decideWinners();

        assertThat(firstPosition).containsOnly(boxster, sonata);
    }
}