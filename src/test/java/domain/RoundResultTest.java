package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class MovementManagerTest {
    @ParameterizedTest
    @CsvSource({"4,true", "3,false"})
    void isGo(Integer randomNumber, boolean movingResult) {
        MovementManager movementManager = new MovementManager();
        Assertions.assertThat(movementManager.isGo(randomNumber)).isEqualTo(movingResult);
    }
}