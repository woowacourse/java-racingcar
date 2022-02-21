package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import racingcar.utils.RandomNumberGenerator;

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
    @DisplayName("입력한 이름값이 한개인 경우")
    void onlyName() {
        Assertions.assertThatThrownBy(() -> {
                    new Cars(new String[]{"pobi"});
                }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Cars.ERROR_ONLY_NAME);
    }

    @Test
    @DisplayName("중복된 이름이 있을 경우")
    void duplicateName() {
        Assertions.assertThatThrownBy(() -> {
                    new Cars(new String[]{"pobi", "pobi"});
                }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Cars.ERROR_DUPLICATE_NAME);
    }

    @Test
    @DisplayName("가장 멀리간 자동차 한대를 찾을 수 있는가")
    void findOneWinner() {
        Cars cars = new Cars(new String[]{"pobi", "troy"});
        Car elsa = new Car("elsa", 3);
        cars.addCar(elsa);
        List<Car> winners = cars.findWinners();
        assertThat(winners).contains(elsa);
    }

    @Test
    @DisplayName("가장 멀리간 자동차를 모두 찾을 수 있는가")
    void findMultiWinner() {
        Cars cars = new Cars(new String[]{"pobi", "troy"});
        Car elsa = new Car("elsa", 3);
        Car woods = new Car("woods", 3);
        cars.addCar(elsa);
        cars.addCar(woods);
        List<Car> winners = cars.findWinners();
        assertThat(winners).containsExactly(elsa, woods);
    }

    @Test
    @DisplayName("toString 이 Cars의 중요 정보를 모두 담고 있는가?")
    void carsToString() {
        Cars cars = new Cars(new String[]{"pobi", "elsa"});
        System.out.println(cars);
        assertThat(cars.toString()).contains("pobi", "elsa");
    }



    @Test
    @DisplayName("항상 4보다 작은 값이 주어졌을 때 모든차가 움직이지 않는가?")
    void noMoveAllCars() {
        Cars cars = new Cars(new String[]{"pobi", "elsa"});
        cars.startEachRace(new NonMovableNumberGenerator());
        int maxPosition = findWinnersPosition(cars);
        assertThat(maxPosition).isEqualTo(0);
    }

    @Test
    @DisplayName("항상 4보다 큰 값이 주어졌을 때 모든차가 움직이는가?")
    void allMoveAllCars() {
        Cars cars = new Cars(new String[]{"pobi", "elsa"});
        cars.startEachRace(new MovableNumberGenerator());
        int maxPosition = findWinnersPosition(cars);
        assertThat(maxPosition).isNotEqualTo(0);
    }

    private int findWinnersPosition(Cars cars) {
        List<Car> winners = cars.findWinners();
        int maxPosition = 0;
        for (Car winner : winners) {
            maxPosition = Math.max(maxPosition, winner.getPosition());
        }
        return maxPosition;
    }
}
