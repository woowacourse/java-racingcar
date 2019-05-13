package racingcar.domain.result;

import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.RacingGamePlayers;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RacingGameRoundTest {
    @Test
    void toString_메소드가_정상적으로_작동하는지_테스트() {
        List<Car> cars = Arrays.asList(new Car("red", 1),
                new Car("blue", 2), new Car("green", 0));
        RacingGamePlayers players = new RacingGamePlayers(cars);
        String expected = new RacingGameRound(players).toString();

        assertEquals(expected, "red   : -\nblue  : --\ngreen : \n");
    }

    @Test
    void 우승자_리스트를_생성하는_메소드가_정상적으로_작동하는지_테스트() {
        List<Car> cars = Arrays.asList(new Car("red", 2),
                new Car("blue", 2), new Car("green", 0));
        RacingGamePlayers players = new RacingGamePlayers(cars);
        List<String> expected = new RacingGameRound(players).getNamesOfWinners();
        List<String> actual = Arrays.asList("red", "blue");

        assertEquals(expected, actual);
    }
}