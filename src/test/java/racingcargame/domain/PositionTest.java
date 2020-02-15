package racingcargame.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class PositionTest {
    @ParameterizedTest
    @CsvSource(value = {"0:0:true", "1:0:false"}, delimiter = ':')
    void 현재_포지션이_입력한_포지션과_같은지_검사(int positionNumber, int comparedPositionNumber, boolean expected) {
        Position position = new Position(positionNumber);
        boolean actual = position.isSamePosition(comparedPositionNumber);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 포지션이_현재_위치에서_n만큼_변경된다() {
         Position position = new Position(0);
         position.move();
         assertThat(position).hasFieldOrPropertyWithValue("position", 1);
    }
}
