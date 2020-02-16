package racingTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racing.model.Car;
import racing.model.CarLineUp;

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
    void 우승자_찾기(){
        String winner = lineUp.findWinner();
        assertThat(winner).isEqualTo("보스독");
    }

}
