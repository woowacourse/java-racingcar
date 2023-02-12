package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import validation.ErrorMessage;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class CarsTest {

    @Test
    @DisplayName("중복된 자동차 이름이 있으면 예외가 발생한다")
    public void createDuplicateCarNames() {
        List<Car> cars = List.of(new Car("grey"), new Car("grey"), new Car("hoi"));

        assertThatThrownBy(() -> new Cars(cars))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.DUPLICATE_CAR_NAME.getMessage());
    }

}
