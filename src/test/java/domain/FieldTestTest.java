package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.NumberGenerator;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FieldTestTest {

    @DisplayName("자동차들을 정상적으로 이동시키는가")
    @Test
    void cars_movement_test() {
        // given
        final CarGroup carGroup = new CarGroup(new String[]{"pobi", "weve"});
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8);
        NumberGenerator numberGenerator = new FixedNumberGenerator(numbers);
        Field field = new Field(numberGenerator);

        // when
        for (int i = 0; i < numbers.size() / 2; i++) {
            field.moveCars(carGroup);
        }

        // then
        List<Car> cars = carGroup.getAllCars();
        Car pobiCar = cars.get(0);
        Car weveCar = cars.get(1);

        assertThat(pobiCar.getPosition()).isEqualTo(2);
        assertThat(weveCar.getPosition()).isEqualTo(3);
    }
}

class FixedNumberGenerator implements NumberGenerator {
    private final List<Integer> numbers;
    private Integer index = 0;

    FixedNumberGenerator(final List<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public int getNumber() {
        return numbers.get(index++);
    }
}
