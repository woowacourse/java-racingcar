package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarFactoryTest {
    @Test
    @DisplayName("CarFactory 통한 차 여러대 생성")
    public void generate_cars_through_carFactory() {
        assertThat(CarFactory.of("forky,kun"))
                .containsExactlyInAnyOrder(new Car("forky"), new Car("kun"));
    }
}
