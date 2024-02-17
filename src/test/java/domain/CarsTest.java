package domain;

import domain.car.Car;
import domain.car.Cars;
import domain.name.Name;
import domain.name.Names;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CarsTest {
    @Test
    @DisplayName("이름들을 통해 자동차 목록을 포함한 일급객체를 만든다.")
    void createCars() {
        Names names = new Names(List.of(new Name("pond"), new Name("poby")));

        Cars cars = Cars.from(names);

        assertInstanceOf(Cars.class, cars);
        cars.getValue()
            .forEach(car -> assertInstanceOf(Car.class, car));

    }

    @Test
    @DisplayName("자동차들중 가장 많이 간 우승 자동차들을 모은 경기결과를 만든다.")
    public void createRaceResult() {
        Name pond = new Name("pond");
        Name poby = new Name("poby");
        Names names = new Names(List.of(pond,poby));
        Cars cars = Cars.from(names);

        cars.getValue().get(0).race(5);
        List<Car> winnerCars = cars.getMaxPositionCars();

        assertEquals(winnerCars.size(),1);
        assertEquals(winnerCars.get(0).getName(),pond);

    }
}
