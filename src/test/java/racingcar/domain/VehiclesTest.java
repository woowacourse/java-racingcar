package racingcar.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.stream.IntStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class VehiclesTest {

    @Test
    @DisplayName("자동차 이름을 넣으면 쉼표로 구분하여 자동차 객체들을 생성한다")
    public void fromTest() {
        //given
        String userInput = "chocochip,seyang,pobi";

        //when
        Vehicles vehicles = Vehicles.from(userInput);
        List<Car> cars = vehicles.getCars();

        //then
        IntStream.range(0, cars.size())
                .forEach(times -> assertEquals(cars.get(times).getName(), userInput.split(",")[times]));
    }
}