package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {
    Names names = new Names("pobi,elly,rutgo");
    Cars cars = new Cars(names);
    Car firstCar = cars.getCars().get(0);
    Car secondCar = cars.getCars().get(1);
    Car thirdCar = cars.getCars().get(2);

    @Test
    void Cars_생성_테스트() {
        assertThat(cars.getCars().get(0).toString()).isEqualTo("pobi");
        assertThat(cars.getCars().get(1).toString()).isEqualTo("elly");
        assertThat(cars.getCars().get(2).toString()).isEqualTo("rutgo");
    }

    @Test
    void 랜덤값_0에서_9까지_생성_테스트() {
        assertThat(cars.createRandomValue()).isBetween(0, 9);
    }

    @Test
    void 여러대의_차_진행상황_출력() {
        firstCar.movePosition(5);
        firstCar.movePosition(5);
        firstCar.movePosition(5);
        secondCar.movePosition(5);
        thirdCar.movePosition(5);
        assertThat(cars.getCurrentResult()).isEqualTo("pobi : ---\nelly : -\nrutgo : -\n");
    }
}
