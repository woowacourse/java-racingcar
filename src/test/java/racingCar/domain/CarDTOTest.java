package racingCar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

@SuppressWarnings("NonAsciiCharacters")
public class CarDTOTest {
    @Test
    void 이름확인() {
        assertThat(new CarDTO(new Car("hunch", 0)).name)
                .isEqualTo("hunch");
    }

    @Test
    void position_확인() {
        assertThat(new CarDTO(new Car("hunch", 5)).position)
                .isEqualTo(5);
    }
}