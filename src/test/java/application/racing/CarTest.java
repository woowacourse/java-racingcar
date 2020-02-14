package application.racing;

import application.racing.domain.Car;
import application.racing.domain.CarName;
import application.racing.domain.Racing;
import application.racing.domain.RacingLab;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

public class CarTest {
    @DisplayName("잘못된 문자열로 자동차를 생성할 때 예외 발생 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"", ",asd", "asdfrq,pobi", "pobi,pobi", "pobi,,crong", "pobi, ,crong", "  ,pobi"})
    public void validateCarNameTest(String input) {
        Assertions.assertThatThrownBy(() -> {
            new CarName(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("잘못된 문자열을 게임 시도 횟수로 입력시 예외 발생 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"", "a", "-1", "a,sd,fd"})
    public void validateRacingLabTest(String input) {
        Assertions.assertThatThrownBy(() -> {
            RacingLab racingLab = new RacingLab(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력받은 숫자에 따라 자동차의 위치 이동 테스트")
    @ParameterizedTest
    @CsvSource(value = {"0:0", "1:0", "2:0", "3:0", "4:1", "5:1", "6:1", "7:1", "8:1", "9:1"}, delimiter = ':')
    public void moveCarWhenNumberOverFourTest(String input, String expected) {
        Car car = new Car("test");
        car.moveCarWhenNumberOverFour(Integer.parseInt(input));
        Assertions.assertThat(car.getPosition()).isEqualTo(Integer.parseInt(expected));
    }

    @DisplayName("생성한 랜덤 숫자가 0 이상 9 이하인지 테스트")
    @Test
    public void generateRandomNumberTest() {
        Racing racing = new Racing();
        int randomNumber = racing.generateRandomNumber();
        Assertions.assertThat(randomNumber).isBetween(0, 9);
    }

    @DisplayName("우승자를 판단하는 메소드 테스트")
    @Test
    public void findWinnerTest() {
        List<Car> cars = setUpCars();
        List<String> winners = setUpWinners();
        Racing racing = new Racing();
        Assertions.assertThat(racing.findWinner(cars)).isEqualTo(winners);
    }

    public List<Car> setUpCars() {
        List<Car> cars = new ArrayList<>();
        Car pobi = new Car("pobi");
        Car lavin = new Car("lavin");
        Car ramen = new Car("ramen");
        pobi.moveCarWhenNumberOverFour(4);
        pobi.moveCarWhenNumberOverFour(4);
        lavin.moveCarWhenNumberOverFour(4);
        lavin.moveCarWhenNumberOverFour(4);
        ramen.moveCarWhenNumberOverFour(4);
        cars.add(pobi);
        cars.add(lavin);
        cars.add(ramen);
        return cars;
    }

    public List<String> setUpWinners() {
        List<String> winners = new ArrayList<>();
        winners.add("pobi");
        winners.add("lavin");
        return winners;
    }
}
