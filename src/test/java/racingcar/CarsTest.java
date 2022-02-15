package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.Cars;

@SuppressWarnings("NonAsciiCharacters")
public class CarsTest {
    @Test
    public void 우승자_찾기() {
        Cars cars = new Cars(Arrays.asList(new Car("배카라", 4), new Car("아스피", 5), new Car("아놀드", 3)));
        List<String> result = cars.findWinnerCars();
        assertThat(result).isEqualTo(Arrays.asList("아스피"));
    }

    @Test
    public void 우승자_여러명_찾기() {
        Cars cars = new Cars(Arrays.asList(new Car("배카라", 4), new Car("아스피", 4), new Car("아놀드", 3)));
        List<String> result = cars.findWinnerCars();
        assertThat(result).isEqualTo(Arrays.asList("배카라", "아스피"));
    }
}
