package racing.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racing.utils.GoNumberGenerator;
import racing.utils.StopNumberGenerator;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {
    private Cars cars;

    @BeforeEach
    void setup() {
        cars = new Cars(Arrays.asList(
                new Car("자동차1", 10),
                new Car("자동차2", 3),
                new Car("자동차3", 10)
        ));
    }

    @Test
    void playRoundTest() {
        cars.playRound(new GoNumberGenerator());

        assertThat(cars.getCars().get(0).getPosition()).isEqualTo(11);
        assertThat(cars.getCars().get(1).getPosition()).isEqualTo(4);
        assertThat(cars.getCars().get(2).getPosition()).isEqualTo(11);

        cars.playRound(new StopNumberGenerator());

        assertThat(cars.getCars().get(0).getPosition()).isEqualTo(11);
        assertThat(cars.getCars().get(1).getPosition()).isEqualTo(4);
        assertThat(cars.getCars().get(2).getPosition()).isEqualTo(11);
    }

    @Test
    public void winnerTest() {
        List<String> winners = cars.findWinner();
        String winnersName = String.join(",", winners);

        assertThat(winnersName).contains("자동차1");
        assertThat(winnersName).contains("자동차3");
        assertThat(winnersName).doesNotContain("자동차2");
    }
}
