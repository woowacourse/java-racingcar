package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CarsTest {

    @Test
    void getSingleChampion() {
        Cars cars = Cars.of(new String[] {"car1", "car2", "car3"});

        cars.getCars().get(0).move();

        assertThat(cars.getChampions())
            .containsOnly("car1");
    }

    @Test
    void getChampions() {
        Cars cars = Cars.of(new String[] {"car1", "car2", "car3"});

        cars.getCars().get(0).move();
        cars.getCars().get(1).move();

        assertThat(cars.getChampions())
            .contains("car1")
            .contains("car2")
            .doesNotContain("car3");
    }

    @Test
    void getChampionsWithAllHavingHighScore() {
        Cars cars = Cars.of(new String[] {"car1", "car2", "car3"});

        cars.getCars().get(0).move();
        cars.getCars().get(1).move();
        cars.getCars().get(2).move();

        assertThat(cars.getChampions())
            .contains("car1")
            .contains("car2")
            .contains("car3");
    }

    @Test
    void getChampionWithSingleParticipant() {
        Cars cars = Cars.of(new String[] {"car1"});

        cars.getCars().get(0).move();

        assertThat(cars.getChampions())
            .containsOnly("car1");
    }
}