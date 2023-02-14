package racinggame.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CarGeneratorTest {
    static CarGenerator carGenerator;

    @BeforeAll
    static void setup() {
        carGenerator = new CarGenerator();
    }

    @DisplayName("차 이름을 받아 차 리스트를 잘 생성하는지 테스트")
    @Test
    void generateCars() {
        String[] carNames = {"jery", "jena", "poby"};
        assertThat(carGenerator.generateCars(carNames).size()).isEqualTo(3);
    }

    @DisplayName("유효하지 않은 차 이름을 받았을 때 에러 테스트")
    @Test
    void generateCarsWithErrorName() {
        String[] carNames = {"jena", "jena", "poby"};
        Assertions.assertThatThrownBy(() -> carGenerator.generateCars(carNames))
                .isInstanceOf(IllegalArgumentException.class);

    }
}
