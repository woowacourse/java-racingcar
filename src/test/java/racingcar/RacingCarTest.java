package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.AttemptNumber;
import racingcar.domain.Car;
import racingcar.domain.Cars;

public class RacingCarTest {

    @ParameterizedTest
    @ValueSource(strings = {"benz", "bmw", "suv"})
    @DisplayName("이름이 5글자 이하일 때 Car 객체가 생성되는지 테스트")
    void carNameTest(String text) {
        Car car = new Car(text);
        assertThat(car.getName()).isEqualTo(text);
    }

    @ParameterizedTest
    @ValueSource(strings = {"grandeur", "sportsCar", "sonata"})
    @DisplayName("이름이 6글자 이상일 때 Car 객체 생성 시 에러 발생하는지 테스트")
    void carNameLengthErrorTest(String text) {
        assertThatThrownBy(() -> {
            new Car(text);
        }).isInstanceOf(IllegalArgumentException.class);
    }

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
    @ValueSource(ints = {0, -1, -2, -3})
    @DisplayName("양의 정수가 아닐 때 AttemptNumber 객체 생성 시 에러 발생하는지 테스트")
    void attemptsNumberErrorTest(int number) {
        // 에러가 잘 출력되는지 테스트
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> {
                new AttemptNumber(number);
            });
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 5, 8, 10})
    @DisplayName("양의 정수일 때 AttemptNumber 객체 생성되는지 테스트")
    void attemptsNumberTest(int number) {
        // 에러가 출력이 안되고 잘 동작하는지 테스트
        AttemptNumber attemptNumber = new AttemptNumber(number);
        assertThat(attemptNumber.getAttemptNumber()).isEqualTo(number);
    }

    @ParameterizedTest
    @CsvSource(value = {"9:1", "3:0", "5:1"}, delimiter = ':')
    @DisplayName("랜덤 값이 4이상 일때 자동차 위치가 변하는지 테스트")
    void randomNumberPositionTest(String input, String expected) {
        Car car = new Car("temp");
        car.move(Integer.parseInt(input));
        assertThat(car.getPosition()).isEqualTo(Integer.parseInt(expected));
    }

    @ParameterizedTest
    @CsvSource(value = {"3:---", "2:--", "5:-----"}, delimiter = ':')
    @DisplayName("위치값이 문자열로 잘 변환되는지 테스트")
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
    @DisplayName("원하는 자동차 이동 후 우승자 문자열이 잘 반환되는지 테스트")
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
        assertThat(cars.getWinners()).isEqualTo(expected);
    }
}