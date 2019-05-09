package racing.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class RaceTest {
    Race race;
    @BeforeEach
    void setUp(){
        race = new Race();
    }
    @Test
    void createCarTest() {
        String [] carNames = {"pobi","crong","honux"};
        race.createCars(Arrays.asList(carNames));
        List<Car> createdCars = race.getCars();
        assertThat(createdCars).isNotEqualTo(null);
    }
}
