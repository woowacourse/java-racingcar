package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CarsTest {

    @Test
    void getChampions() {
        Cars cars = new Cars(new String[] {"car1", "car2", "car3"});

        cars.getCars().get(0).move(5);
        cars.getCars().get(1).move(5);
        cars.getCars().get(2).move(3);

        assertThat(cars.getChampions())
            .contains("car1")
            .contains("car2")
            .doesNotContain("car3");
    }
}