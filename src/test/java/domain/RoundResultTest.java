package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class RoundResultTest {
    @ParameterizedTest
    @CsvSource({"4,true", "3,false"})
    void isGo(Integer randomNumber, boolean movingResult) {
        RoundResult roundResult = new RoundResult();
        Assertions.assertThat(roundResult.isGo(randomNumber)).isEqualTo(movingResult);
    }
}