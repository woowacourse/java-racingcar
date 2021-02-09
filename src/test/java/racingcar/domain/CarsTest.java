package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {
    @Test
    public void Cars_객체_생성_테스트() {
        Cars cars = new Cars(new String[]{"포비", "제이슨"});
        assertThat(cars.carList().size()).isEqualTo(2);
    }
}