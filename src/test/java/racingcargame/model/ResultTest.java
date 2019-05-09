package racingcargame.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultTest {

    @Test
    void 최종_우승자_1명_판단(){
        List<Car> cars = Arrays.asList(new Car("pobi", 2),
                new Car("crong", 3),
                new Car("honux", 1));
        Result result = new Result(cars);
        List<String> winners = result.gameResult();

        assertThat(winners.size()).isEqualTo(1);
    }

    @Test
    void 최종_우승자_여러명_판단(){
        List<Car> cars = Arrays.asList(new Car("pobi", 2),
                new Car("crong", 3),
                new Car("honux", 3),
                new Car("jason", 1));
        Result result = new Result(cars);
        List<String> winners = result.gameResult();

        assertThat(winners.size()).isEqualTo(2);
    }

}
