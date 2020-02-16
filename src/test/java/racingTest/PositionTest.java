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

    @Test
    void 포지션객체_끼리_같은지_확인(){
        Position position1  =  new Position(5);
        Position position2  =  new Position(5);

        assertThat(position1).isEqualTo(position2);
    }

    @Test
    void 정수_포지션_크기_비교(){
        Position position1  =  new Position(10);
        Position position2  =  new Position(7);

        boolean result = position1.isBiggerThan(position2);
        assertThat(result).isTrue();
    }
}
