package racing.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {
    Cars cars;

    @Test
    public void winnerTest() {
        Cars cars = new Cars(Arrays.asList(
                new Car("자동차1", 10),
                new Car("자동차2", 3),
                new Car("자동차3", 10)
        ));

        List<String> winners = cars.findWinner();
        String winnersName = String.join(",", winners);

        assertThat(winnersName).contains("자동차1");
        assertThat(winnersName).contains("자동차3");
        assertThat(winnersName).doesNotContain("자동차2");
    }
}
