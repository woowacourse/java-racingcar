package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarsTest {

    @ParameterizedTest
    @CsvSource(value = {"pobi,crong,honux:3", "mt:1", "oz,mt:2"}, delimiter = ':')
    @DisplayName("자동차 여러 대를 만들 때 Cars 리스트에 정상적으로 추가가 되었는지 테스트")
    void carCreateLengthTest(String input, String expected) {
        List<Car> carList = new ArrayList<>();
        String[] carNames = input.split(",");
        for (String carName : carNames) {
            carList.add(new Car(carName));
        }
        Cars cars = new Cars(carList);
        assertEquals(cars.getCars().size(), Integer.parseInt(expected));
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi,crong,honux", "mt,oz", "oz,mt"})
    @DisplayName("자동차 여러 대를 만들 때 이름이 일치하는지 테스트")
    void multiCarNameEqualTest(String text) {
        List<Car> carList = new ArrayList<>();
        String[] carNames = text.split(",");
        for (String carName : carNames) {
            carList.add(new Car(carName));
        }
        Cars cars = new Cars(carList);
        carList = cars.getCars();
        for (int i = 0; i < carList.size(); i++) {
            assertEquals(carList.get(i).getName(), carNames[i]);
        }
    }

    @ParameterizedTest
    @CsvSource(value = {"mt,oz,pobi@0,2:mt, pobi", "pobi,crong,honux@0:pobi",
            "pobi,crong,honux@1:crong", "pobi,crong,honux@2:honux", "pobi,crong,honux@1,2:crong, honux",
            "pobi,crong,honux@0,1,2:pobi, crong, honux"}, delimiter = ':')
    @DisplayName("원하는 자동차 이동 후 우승자 문자열이 잘 반환되는지 테스트")
    void winnerCarTest(String input, String expected) {
        String[] inputArray = input.split("@");
        Cars cars = Cars.createCars(inputArray[0]);
        String[] indexArray = inputArray[1].split(",");
        for (String index : indexArray) {
            cars.getCars().get(Integer.parseInt(index)).move(() -> 4);
        }
        assertThat(cars.getWinners()).isEqualTo(expected);
    }
}
