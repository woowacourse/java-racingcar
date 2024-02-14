package racingcar.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.stream.IntStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("자동차들")
class VehiclesTest {

    @Test
    @DisplayName("이름을 넣으면 쉼표로 구분하여 자동차 객체들을 생성한다.")
    void createVehicleTest() {
        //given
        String userInput = "choco,seyan,pobi";

        //when
        Vehicles vehicles = Vehicles.from(userInput);
        List<Car> cars = vehicles.getCars();

        //then
        IntStream.range(0, cars.size())
                .forEach(times -> assertEquals(cars.get(times).getName(), userInput.split(",")[times].trim()));
    }

    @Test
    @DisplayName("이름은 쉼표로 분리된 뒤 앞뒤 공백이 제거된다.")
    void trimCarNamesTest() {
        //given
        String userInput = "  choco , seyan, po bi ";

        //when
        Vehicles vehicles = Vehicles.from(userInput);
        List<Car> cars = vehicles.getCars();

        //then
        IntStream.range(0, cars.size())
                .forEach(times -> assertEquals(cars.get(times).getName(), userInput.split(",")[times].trim()));
    }

    @Test
    @DisplayName("중복된 자동차 이름이 있을 경우 예외가 발생한다.")
    public void verifyNonDuplicateCarNames() {
        //given
        String userInput = "choco,seyan,choco";

        //when & then
        assertThrows(IllegalArgumentException.class, () -> Vehicles.from(userInput));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "    "})
    @DisplayName("사용자 입력이 빈칸이면, 예와가 발생한다.")
    public void verifyBlankUserInput(String userInput) {
        //given&when & then
        assertThrows(IllegalArgumentException.class, () -> Vehicles.from(userInput));
    }
}