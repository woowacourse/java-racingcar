package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    @Test
    void Cars_생성_테스트() {
        Names names = new Names("pobi,elly,rutgo");
        Cars cars = new Cars(names);

        assertThat(cars.getCars().get(0).toString()).isEqualTo("pobi");
        assertThat(cars.getCars().get(1).toString()).isEqualTo("elly");
        assertThat(cars.getCars().get(2).toString()).isEqualTo("rutgo");
    }
}
