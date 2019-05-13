package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RacingResultTest {
    private List<Car> cars= new ArrayList<>();
    private RacingResult racingResult;

    @BeforeEach
    void setUp() {
        cars.add(new Car("pobi",3));
        cars.add(new Car("crong",5));
        racingResult = new RacingResult(cars);

    }

    @Test
    void create() {
        assertThat(new RacingResult(cars).equals(new RacingResult(cars))).isTrue();
    }

    @Test
    void 우승자_출력_테스트(){
        System.out.println(racingResult.toString());
    }

}
