package car.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {
    
    @Test
    @DisplayName("모든 자동차가 전진")
    void race_EveryCarsShouldMove_CarMoved() {
        
        // given
        final String carNames = "pobi,crong,honux";
        final Cars didNotRacedCars = Cars.from(carNames);
        
        // when
        final Cars racedCars = Cars.fromCarNamesWithFakeEngine(carNames, 4)
                                   .race();
        
        // then
        assertThat(didNotRacedCars).isNotEqualTo(racedCars);
    }
}
