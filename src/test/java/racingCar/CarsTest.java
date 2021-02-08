package racingCar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    private Cars cars;
    private Car car1;
    private Car car2;

    @BeforeEach
    void setUp() {
        cars = new Cars();

        car1 = new Car("test");
        car2 = new Car("car2");

        car2.move(4);
        car2.move(5);

        cars.carAdd(car1);
        cars.carAdd(car2);
    }

    @Test
    public void get_cars() {
        List<Car> gameCars = cars.getCars();

        assertThat(gameCars.size()).isEqualTo(2);
    }

    @Test
    public void car_add() {
        List<Car> gameCars = cars.getCars();

        assertThat(gameCars.get(0).getName()).isEqualTo("test");
        assertThat(gameCars.get(1).getName()).isEqualTo("car2");
    }

    @Test
    public void find_winner() {
        List<String> winners = cars.findWinners(2);

        assertThat(winners.get(0)).isEqualTo("car2");
    }

    @Test
    public void find_max_distance() {
        int maxDistance = cars.findMaxDistance();

        assertThat(maxDistance).isEqualTo(2);
    }
}