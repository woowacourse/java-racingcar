package racingcar.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {
    @ParameterizedTest
    @ValueSource(strings = {"포비", "제이슨"})
    public void 자동차_객체_생성_테스트(String name) {
        Cars cars = new Cars(new String[]{"포비","제이슨"});
        assertThat(cars.getCarNames()).contains(name);
    }
}