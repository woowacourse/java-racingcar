package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CountTest {
    @ParameterizedTest
    @CsvSource(value = {"2,true", "4,false", "0,true", "1000,false", "-1000,true"})
    @DisplayName("주어진 범위 내의 횟수 확인한다")
    void isValidRange(int range, boolean expected) {
        Count count = Count.from(3);

    }
}
