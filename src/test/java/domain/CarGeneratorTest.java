package domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;


public class CarGeneratorTest {
    @Test
    public void carGenerateTest_적절한_경우() {
        String carNames = "타미,둔덩";
        List<Car> cars = CarGenerator.create(carNames);
        assertThat(cars.get(0).getName()).isEqualTo("타미");
        assertThat(cars.get(1).getName()).isEqualTo("둔덩");
    }

    @Test
    public void carGenerateTest_쉼표만_입력한_경우() {
        String carNames = ",";
        assertThatThrownBy(() -> CarGenerator.create(carNames) )
                .isInstanceOf(IllegalArgumentException.class);
    }
}
