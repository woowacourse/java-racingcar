package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {
    Names names = new Names("pobi,elly,rutgo");
    Cars cars = new Cars(names);

    @Test
    void Cars_생성_테스트() {
        assertThat(cars.getCars().get(0).toString()).isEqualTo("pobi");
        assertThat(cars.getCars().get(1).toString()).isEqualTo("elly");
        assertThat(cars.getCars().get(2).toString()).isEqualTo("rutgo");
    }

    @Test
    void Cars_차가_움직이는지_확인(){
        cars.moveCars();
        assertThat(cars.getCars().get(0).getPosition()).isEqualTo(1);
        assertThat(cars.getCars().get(1).getPosition()).isEqualTo(1);
        assertThat(cars.getCars().get(2).getPosition()).isEqualTo(1);
    }
}
