package racingcar.controller;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Name;

class CarDtoTest {

    @DisplayName("Position from CarDto 값 확인")
    @Test
    void get_valid_position_from_cardto() {
        Car 코니 = Car.fromName(Name.from("코니"));
        코니.drive(4);
        코니.drive(4);
        CarDto carDto = CarDto.from(코니);

        String name = carDto.getName().toString();
        int position = carDto.getPosition().getPositionValue();

        assertThat(name).isEqualTo("코니");
        assertThat(position).isEqualTo(2);
    }
}
