package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import racingcar.dto.CarNamesRequestDTO;

class CarNamesTest {
    @ParameterizedTest(name = "자동차 이름이 delimiter로 분리되는지 테스트")
    @ValueSource(strings = {"test1,test2,test3", "a,a,a"})
    void carNamesTest(String string) {
        assertThat(new CarNames(new CarNamesRequestDTO(string)).getNames()).hasSize(3);
    }
}