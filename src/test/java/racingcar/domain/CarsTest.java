package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {
    @Test
    @DisplayName("자동차 목록이 잘 등록되는지 테스트")
    void carsGenerateTest() {
        String[] carNames = {"pobi", "crong", "huan"};
        Cars cars = new Cars(carNames);
        assertThat(cars.getSize()).isEqualTo(carNames.length);
    }

    @Test
    @DisplayName("가장 멀리간 자동차 한대를 찾을 수 있는가")
    void findOneWinner() {
        Cars cars = new Cars(new String[]{"pobi"});
        Car elsa = new Car("elsa", 3);
        cars.addCar(elsa);
        List<Car> winners = cars.findWinners();
        assertThat(winners).contains(elsa);
    }

    @Test
    @DisplayName("가장 멀리간 자동차를 모두 찾을 수 있는가")
    void findMultiWinner() {
        Cars cars = new Cars(new String[]{"pobi"});
        Car elsa = new Car("elsa", 3);
        Car woods = new Car("woods", 3);
        cars.addCar(elsa);
        cars.addCar(woods);
        List<Car> winners = cars.findWinners();
        assertThat(winners).containsExactly(elsa,woods);
    }

    @Test
    @DisplayName("toString 이 Cars의 중요 정보를 모두 담고 있는가?")
    void name() {
        Cars cars = new Cars(new String[]{"pobi", "elsa"});
        System.out.println(cars);
        assertThat(cars.toString()).contains("pobi", "elsa");
    }
}