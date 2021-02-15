package racingCar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    private Cars cars;
    private Car car1;
    private Car car2;

    @BeforeEach
    void setUp() {
        car1 = new Car("test");
        car2 = new Car("car2");

        List<Car> testCars = new ArrayList<>();
        testCars.add(car1);
        testCars.add(car2);

        car2.move(4);
        car2.move(5);

        cars = new Cars(Arrays.asList(car1, car2));
    }

    @Test
    @DisplayName("BeforeEach 가 제대로 동작하여 cars에 Car가 제대로 들어갔는지 확인")
    public void get_cars() {
        List<Car> gameCars = cars.getCars();

        assertThat(gameCars).isEqualTo(Arrays.asList(car1, car2));
    }

    @Test
    @DisplayName("우승자의 이름을 제대로 반환하는지 확인")
    public void find_winner() {
        List<CarName> winners = cars.findWinners(2);

        assertThat(winners).isEqualTo(Arrays.asList(new CarName("car2")));
    }

    @Test
    @DisplayName("자동차 경주의 우승자의 이동 거리를 반환하는지 확인")
    public void find_max_distance() {
        int maxDistance = cars.findMaxDistance();

        assertThat(maxDistance).isEqualTo(2);
    }
}