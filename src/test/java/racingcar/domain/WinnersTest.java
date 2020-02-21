package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domian.Winners;
import racingcar.domian.car.Car;
import racingcar.domian.car.Position;

import java.util.Arrays;
import java.util.List;

public class WinnersTest {
    @DisplayName("전체_자동차들_중_우승자를 찾는_테스트")
    @Test
    void findWinnerTest() {
        //given
        List<Car> cars = Arrays.asList(
                new Car(new Position(1), "car1"),
                new Car(new Position(2), "car2"),
                new Car(new Position(3), "car3"),
                new Car(new Position(3), "car4")
        );
        Winners winners = new Winners();
        //when
        //then
        Assertions.assertThat(winners.findWinner(cars).size()).isEqualTo(2);
    }
}
