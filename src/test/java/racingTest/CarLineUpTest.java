package racingTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racing.model.Car;
import racing.model.CarLineUp;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
        assertThatThrownBy(() -> {
            Car car = new Car("토니");
            lineUp.add(car);
        }).isInstanceOf(IllegalArgumentException.class)
        .hasMessage("차 이름이 중복되었습니다.");
    }

    @Test
    void 우승자_찾기(){
        List<Car> winner = lineUp.findWinner();
        assertThat(winner).contains(lineUp.getLineUp().get(2));
    }

}
