package racingTest;

import org.junit.jupiter.api.Test;
import racing.model.Position;

import static org.assertj.core.api.Assertions.assertThat;

public class PositionTest {

    @Test
    void 현재_포지션_만큼_연속된_대쉬_문자열반환(){
        Position position  =  new Position();
        String currentPositionByDash = position.getPositionByDash(5);
        assertThat(currentPositionByDash).isEqualTo("-----");
    }
}
