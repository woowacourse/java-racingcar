package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CarsTest {

    @Test
    void getSingleChampion() {
        Cars cars = Cars.of(new String[] {"car1", "car2", "car3"});

        cars.getCars().get(0).move(() -> true);
        cars.getCars().get(1).move(() -> false);
        cars.getCars().get(2).move(() -> false);

        assertThat(cars.getChampions())
            .containsOnly("car1");
    }

    @Test
    void getChampions() {
        Cars cars = Cars.of(new String[] {"car1", "car2", "car3"});

        cars.getCars().get(0).move(() -> true);
        cars.getCars().get(1).move(() -> true);
        cars.getCars().get(2).move(() -> false);

        assertThat(cars.getChampions())
            .contains("car1")
            .contains("car2")
            .doesNotContain("car3");
    }

    @Test
    void getChampionsWithAllHavingHighScore() {
        Cars cars = Cars.of(new String[] {"car1", "car2", "car3"});

        cars.getCars().get(0).move(() -> true);
        cars.getCars().get(1).move(() -> true);
        cars.getCars().get(2).move(() -> true);

        assertThat(cars.getChampions())
            .contains("car1")
            .contains("car2")
            .contains("car3");
    }

    @Test
    void getChampionWithSingleParticipant() {
        Cars cars = Cars.of(new String[] {"car1"});

        cars.getCars().get(0).move(() -> true);

        assertThat(cars.getChampions())
            .containsOnly("car1");
    }
}