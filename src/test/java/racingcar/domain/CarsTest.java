package racingcar.domain;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {
    @Test
    void 자동차들_이름_나누기() {
        //given
        String inputNames = "123,324,456";
        Cars cars = new Cars(inputNames);
        List<String> expectedNameList = List.of("123", "324", "456");
        //when
        List<String> carNames = cars.getCars()
                .stream()
                .map(car -> car.getName())
                .collect(Collectors.toList());
        //then
        assertThat(carNames).isEqualTo(expectedNameList);
    }
}