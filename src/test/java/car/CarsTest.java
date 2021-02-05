package car;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {
    
    @Test
    void name() {
        
        // given
        final String carNames = "pobi,crong,honux";
        final Cars didNotRacedCars = Cars.from(carNames);
        
        // when
        final Cars racedCars = Cars.fromCarNamesWithFakeEngine(carNames, 4).race();
        
        // then
        assertThat(didNotRacedCars).isNotEqualTo(racedCars);
    }
}
