package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.controller.CarController;
import racingcar.domain.AttemptNumber;
import racingcar.domain.Car;
import racingcar.domain.Cars;

public class CarTest {

    @Test
    @DisplayName("자동차 이름이 잘 들어갔는지 테스트")
    void carNameTest(String text) {
        Car car = new Car("benz");
        assertThat(car.getName()).isEqualTo(text);
    }

    @ParameterizedTest
    @ValueSource(strings = {"grandeur", "sportsCar", "sonata"})
    @DisplayName("자동차 이름길이에 따른 에러가 나는지 테스트")
    void carNameLengthErrorTest(String text) {
        assertThatThrownBy(() -> {
            new Car(text);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"pobi,crong,honux:3", "mt:1", "oz,mt:2"}, delimiter = ':')
    @DisplayName("자동차를 여러대 생성할때 생성된 사이즈 테스트")
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
    @DisplayName("입력한 이름과 객체의 이름이 같은지 테스트")
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
    @ValueSource(ints = {0, -1, -2, -3})
    @DisplayName("시도횟수가 0 이하일대 에러가 나는지 테스트")
    void attemptsNumberErrorTest(int number) {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> {
                new AttemptNumber(number);
            });
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 5, 8, 10})
    @DisplayName("시도횟수가 잘 입력되었는지 테스트")
    void attemptsNumberTest(int number) {
        AttemptNumber attemptNumber = new AttemptNumber(number);
        assertThat(attemptNumber.getAttemptNumber()).isEqualTo(number);
    }

    @ParameterizedTest
    @CsvSource(value = {"9:1", "3:0", "5:1"}, delimiter = ':')
    @DisplayName("랜덤한 숫자에 따라서 이동이 되는지 안되는지 테스트")
    void randomNumberPositionTest(String input, String expected) {
        Car car = new Car("temp");
        car.move(Integer.parseInt(input));
        assertThat(car.getPosition()).isEqualTo(Integer.parseInt(expected));
    }

    @ParameterizedTest
    @CsvSource(value = {"3:---", "2:--", "5:-----"}, delimiter = ':')
    @DisplayName("전진한 거리만큼 문자열이 잘 반환되는지 테스트")
    void carPositionToStringTest(String input, String expected) {
        Car car = new Car("temp");
        for (int i = 0; i < Integer.parseInt(input); i++) {
            car.move(4);
        }
        assertThat(car.positionToString()).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"mt,oz,pobi@0,2:mt, pobi", "pobi,crong,honux@0:pobi",
        "pobi,crong,honux@1:crong", "pobi,crong,honux@2:honux", "pobi,crong,honux@1,2:crong, honux",
        "pobi,crong,honux@0,1,2:pobi, crong, honux"}, delimiter = ':')
    @DisplayName("우승한 자동차가 잘 출력되는지 테스트")
    void winnerCarTest(String input, String expected) {
        String[] inputArray = input.split("@");
        String[] carNames = inputArray[0].split(",");
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < carNames.length; i++) {
            carList.add(new Car(carNames[i]));
        }
        String[] indexArray = inputArray[1].split(",");
        for (String index : indexArray) {
            carList.get(Integer.parseInt(index)).move(4);
        }
        Cars cars = new Cars(carList);
        String winners = CarController.winnerListToString(cars.getWinners());
        assertThat(winners).isEqualTo(expected);
    }
}