package racingcar.domain;

import org.junit.jupiter.api.Test;
import racingcar.domain.Generator.CarMoveValueGenerator;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {
    Names names = new Names("pobi,elly,rutgo");
    Cars cars = new Cars(names);

    @Test
    void Cars_생성_테스트() {
        assertThat(cars.getCars().get(0).getName()).isEqualTo("pobi");
        assertThat(cars.getCars().get(1).getName()).isEqualTo("elly");
        assertThat(cars.getCars().get(2).getName()).isEqualTo("rutgo");
    }

    @Test
    void Cars_차가_움직이는지_확인() {
        CarMoveValueGenerator carMoveValueGenerator = () -> 5;
        cars.moveCars(carMoveValueGenerator);
        assertThat(cars.getCars().get(0).getPosition()).isEqualTo(1);
        assertThat(cars.getCars().get(1).getPosition()).isEqualTo(1);
        assertThat(cars.getCars().get(2).getPosition()).isEqualTo(1);
    }
}
