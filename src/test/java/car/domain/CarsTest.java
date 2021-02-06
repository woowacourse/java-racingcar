package car.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.function.Function;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {
    
    @Test
    @DisplayName("모든 자동차가 전진")
    void race_EveryCarsShouldMove_CarMoved() {
        
        // given
        final String carNames = "pobi,crong,honux";
        final Cars didNotRacedCars = Cars.from(carNames);
        
        // when
        final Cars racedCars = makeCarsWithFakeEngine(carNames, 4).race();
        
        // then
        assertThat(didNotRacedCars).isNotEqualTo(racedCars);
    }
    
    private static Cars makeCarsWithFakeEngine(String carNames, int moveCondition) {
        final Function<String, Car> nameToCarFunction = name -> new Car(name, new MockEngine(moveCondition));
        
        return Cars.of(carNames, nameToCarFunction);
    }
}
