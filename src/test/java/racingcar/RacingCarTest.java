package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.AttemptNumber;
import racingcar.domain.Car;
import racingcar.domain.Cars;

public class RacingCarTest {

    @ParameterizedTest
    @ValueSource(strings = {"benz", "bmw", "suv"})
    void carNameTest(String text) {
        // 자동차 객체가 만들어질때 에러가 안나고, 이름이 잘 저장되는가?
        // 5글자 이하만 넣었을때
        Car car = new Car(text);
        assertThat(car.getName()).isEqualTo(text);
    }

    @ParameterizedTest
    @ValueSource(strings = {"grandeur", "sportsCar", "sonata"})
    void carNameLengthErrorTest(String text) {
        // 자동차 객체가 만들어질때 에러가 나는가?
        // 5글자 이상을 넣었을때
        assertThatThrownBy(() -> {
            new Car(text);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"pobi,crong,honux:3", "mungto:1", "oz,mungto:2"}, delimiter = ':')
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
    @ValueSource(strings = {"pobi,crong,honux", "mungto,oz", "oz,mungto"})
    void multiCarNameEqualTest(String text) {
        // 입력한 이름과 객체들의 이름이 같은지 테스트
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
    void attemptsNumberErrorTest(int number) {
        // 에러가 잘 출력되는지 테스트
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> {
                new AttemptNumber(number);
            });
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 5, 8, 10})
    void attemptsNumberTest(int number) {
        // 에러가 출력이 안되고 잘 동작하는지 테스트
        AttemptNumber attemptNumber = new AttemptNumber(number);
        assertThat(attemptNumber.getAttemptNumber()).isEqualTo(number);
    }

    @ParameterizedTest
    @CsvSource(value = {"9:1", "3:0", "5:1"}, delimiter = ':')
    void randomNumberPositionTest(String input, String expected) {
        // 랜덤한 숫자에 따른 자동차 위치변환 상태확인
        Car car = new Car("temp");
        car.move(Integer.parseInt(input));
        assertThat(car.getPosition()).isEqualTo(Integer.parseInt(expected));
    }

    @ParameterizedTest
    @CsvSource(value = {"9:1", "3:0", "5:1"}, delimiter = ':')
    void winnerTestAfterFixingRandomSeed(String input, String expected) {
        // 시드를 고정할때 우승자가 원하는대로 잘 나오는가?

    }

    @ParameterizedTest
    @CsvSource(value = {"3:---", "2:--", "5:-----"}, delimiter = ':')
    void carPositionToStringTest(String input, String expected) {
        // 전진한 거리만큼의 문자열이 잘 반환되는가?
    }
}