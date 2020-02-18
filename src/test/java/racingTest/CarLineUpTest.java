package racingTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racing.model.Car;
import racing.model.CarLineUp;
import racing.model.Position;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarLineUpTest {

    private CarLineUp lineUp;

    @BeforeEach
    void setUp(){
        lineUp = new CarLineUp();
        lineUp.add(new Car("토니", 5));
        lineUp.add(new Car("작은곰", 6));
        lineUp.add(new Car("보스독", 7));
    }

    @Test
    void 중복이름여부_확인(){
        boolean result = lineUp.isAlready(new Car("토니"));
        assertThat(result).isTrue();

        result = lineUp.isAlready(new Car("토니22"));
        assertThat(result).isFalse();
    }

    @Test
    void 레이스_원_타임_테스트(){
        assertThat(lineUp.getLineUp().get(0).getPosition()).isEqualTo(new Position(5));
        assertThat(lineUp.getLineUp().get(1).getPosition()).isEqualTo(new Position(6));
        assertThat(lineUp.getLineUp().get(2).getPosition()).isEqualTo(new Position(7));

        lineUp.raceOneTime(4);
        assertThat(lineUp.getLineUp().get(0).getPosition()).isEqualTo(new Position(6));
        assertThat(lineUp.getLineUp().get(1).getPosition()).isEqualTo(new Position(7));
        assertThat(lineUp.getLineUp().get(2).getPosition()).isEqualTo(new Position(8));
    }

    @Test
    void 우승자_찾기(){
        List<Car> winner = lineUp.findWinner();
        assertThat(winner).contains(new Car("보스독", 7));
    }

}
