package racingcar.utils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

class CarsGeneratorTest {

    final List<String> carNames = new ArrayList<>();

    @AfterEach
    void afterEach() {
        carNames.clear();
    }

    @Test
    @DisplayName("올바른 자동차 생성 검증")
    void generateTest() {
        carNames.add("pobi");
        carNames.add("crong");
        carNames.add("honux");
        assertThat(CarsGenerator.generateCars(carNames))
                .contains(new Car("pobi"), new Car("crong"), new Car("honux"));
    }
}