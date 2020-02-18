package application.racingGame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinnersTest {
    private Winners winners;
    private List<Car> cars;
    private Car pobi;
    private Car lavin;
    private Car ramen;

    @BeforeEach
    void setUp() {
        winners = new Winners();
        cars = new ArrayList<>();
        pobi = new Car("pobi",2);
        lavin = new Car("lavin",3);
        ramen = new Car("ramen",3);
        cars.add(pobi);
        cars.add(lavin);
        cars.add(ramen);
    }

    @Test
    void getNameOfWinners_우승자의_이름을_계산_저장한다() {
        List<String> winnerNames = Arrays.asList("lavin","ramen");
        assertThat(winners.getNamesOfWinners(cars)).isEqualTo(winnerNames);
    }
}
