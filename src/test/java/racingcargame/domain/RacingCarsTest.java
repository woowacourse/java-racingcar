package racingcargame.domain;

import org.junit.jupiter.api.Test;
import racingcargame.view.OutputView;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarsTest {
    @Test
    void 자동차들의_위치값_출력() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("pobi",3));
        cars.add(new Car("jason",1));
        cars.add(new Car("brown",4));
        RacingCars racingCars = new RacingCars(cars);
        String result = OutputView.printPosition(racingCars);
        String expected = "pobi : ---" + "\n" + "jason : -" + "\n" + "brown : ----" + "\n";
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void 최종우승자_추출() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("pobi",3));
        cars.add(new Car("jason",1));
        cars.add(new Car("brown",4));
        cars.add(new Car("coil",4));
        RacingCars racingCars = new RacingCars(cars);
        Winners winners = new Winners(racingCars.extractWinners());
        boolean result = winners.contain("brown");
        assertThat(result).isTrue();
        result = winners.contain("coil");
        assertThat(result).isTrue();
        result = winners.contain("pobi");
        assertThat(result).isFalse();
    }
}
