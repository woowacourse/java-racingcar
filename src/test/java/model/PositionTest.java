package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class PositionTest {

    @DisplayName("포지션 이동 검사")
    @ParameterizedTest
    @CsvSource(value = {"3,0", "4,1"})
    void move(int randomNumber, int position) {
        Position p = new Position();
        p.move(randomNumber);
        assertThat(p.getPosition()).isEqualTo(position);
    }

}
