package domain;

import domain.car.Car;
import domain.car.Cars;
import domain.name.Name;
import domain.name.Names;
import domain.race.RaceProgress;
import mock.SequenceNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.NumberGenerator;

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
        Cars cars = Cars.from(이름_목록_생성());

        Car winnerCar = cars.getValue()
                            .get(0);
        winnerCar.race(5);
        List<Car> winnerCars = cars.getMaxPositionCars();

        assertEquals(winnerCars.size(), 1);
        assertEquals(winnerCars.get(0), winnerCar);
    }

    @Test
    @DisplayName("진행 횟수와 파워 생성기를 통해 , 경기를 진행한다")
    public void performRace() {
        Cars cars = Cars.from(이름_목록_생성());

        List<RaceProgress> result = cars.performRace(3, new SequenceNumberGenerator());

        assertEquals(result.size(),3);
    }

    private Names 이름_목록_생성() {
        Name name1 = new Name("스티치");
        Name name2 = new Name("조이썬");
        return new Names(List.of(name1, name2));
    }
}
