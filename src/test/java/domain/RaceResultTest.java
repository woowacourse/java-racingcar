package domain;

import domain.car.Car;
import domain.name.Name;
import domain.race.RaceResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RaceResultTest {
    @Test
    @DisplayName("자동차들중 가장 많이 간 우승 자동차들을 모은 경기결과를 만든다.")
    public void createRaceResult(){
        Car car = new Car(new Name("poby"));
        car.race(9);
        Car car1 = new Car(new Name("pond"));
        List<Car>cars = List.of(car,car1);

        RaceResult raceResult = RaceResult.of(cars);

        Car winnerCar = raceResult.getWinnerCars().get(0);
        assertEquals(winnerCar,car);
    }
}
