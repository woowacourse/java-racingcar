package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.util.BoundedRandomNumberGenerator;

@SuppressWarnings("NonAsciiCharacters")
public class CarsTest {
    @ParameterizedTest
    @CsvSource(value = {"0:이브", "1:클레이", "2:포비"}, delimiter = ':')
    public void 자동차_생성_테스트(int input, String expected) {
        Cars cars = new Cars(Arrays.asList("이브", "클레이", "포비"));
        List<Car> result = cars.getCars();

        String actualValue = result.get(input).getCarName();
        assertThat(expected).isEqualTo(actualValue);
    }

    @Test
    public void 자동차_경주_실행_테스트_전진() {
        Cars cars = new Cars(Arrays.asList("이브", "클레이", "포비"));
        cars.executeCarRacing(new BoundedRandomNumberGenerator(9, 4));
        List<Car> result = cars.getCars();

        for (Car car : result) {
            assertThat(car.getCarPosition()).isEqualTo(1);
        }
    }

    @Test
    public void 자동차_경주_실행_테스트_멈춤() {
        Cars cars = new Cars(Arrays.asList("이브", "클레이", "포비"));
        cars.executeCarRacing(new BoundedRandomNumberGenerator(3, 0));
        List<Car> result = cars.getCars();

        for (Car car : result) {
            assertThat(car.getCarPosition()).isEqualTo(0);
        }
    }
}
