package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {

    @Test
    @DisplayName("우승자들을 리스트에 넣어 반환한다.")
    void getWinnersTest() {
        //given
        Car one = new Car("one", 5);
        Car two = new Car("two", 0);
        Car three = new Car("three", 5);
        Cars cars = new Cars(Arrays.asList(one, two, three));

        RacingGame racingGame = new RacingGame(cars, new Count(1));

        //when
        List<Car> winners = racingGame.getWinners();

        //then
        assertThat(winners).contains(one, three);
    }
}
