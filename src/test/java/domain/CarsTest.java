package domain;

import dto.CarState;
import dto.RacingStatus;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CarsTest {
    @Test
    void carsNameDuplicatedTest() {
        List<String> carNames = List.of(
                "toby", "tebah", "anna", "brown", "brown"
        );
        assertThrows(IllegalArgumentException.class, () ->
                Cars.from(carNames)
        );
    }

    @Test
    void carsRaceReturnTest() {
        List<String> carNames = List.of(
                "toby", "tebah", "anna", "brown", "bro"
        );
        Cars cars = Cars.from(carNames);
        assertEquals(cars.race().carStates().size(), 5);
    }

    @Test
    void raceTest() {
        List<String> carNames = List.of(
                "toby", "tebah"
        );
        Cars cars = Cars.from(carNames, new StaticPowerGenerator());
        RacingStatus racingStatus = cars.race();
        CarState tobyState = racingStatus.carStates().get(0);
        assertEquals(tobyState.position(), 0);
        CarState tebahState = racingStatus.carStates().get(1);
        assertEquals(tebahState.position(), 1);
    }
}

class StaticPowerGenerator extends RandomPowerGenerator {
    int staticPower;

    public StaticPowerGenerator() {
        this.staticPower = 3;
    }

    @Override
    public int generate() {
        return staticPower++;
    }
}