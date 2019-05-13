package domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Heebg
 * User: heebg
 * Date: 2019-05-11
 */
class RaceTest {
    List<Car> cars;
    Race race;

    @BeforeEach
    void setUp() {
        cars = new ArrayList<>();
        cars.add(new Car("hello"));
        cars.add(new Car("my"));
        cars.add(new Car("name"));

        race = new Race(cars);
    }

    @Test
    void create_객체_생성() {
        assertThat(race).isEqualTo(new Race(cars, Const.MIN_ROUND_COUNT + 1));
    }

    @Test
    void create_객체_횟수_초기화_생성() {
        assertThat(new Race(cars, Const.MIN_ROUND_COUNT + 2)).isEqualTo(new Race(cars, Const.MIN_ROUND_COUNT + 2));
    }

    @Test
    void create_객체_횟수_최소값_예외() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Race(cars, Const.MIN_ROUND_COUNT);
        });
    }

    @Test
    void getRaceCarInfo_확인() {
        List<String> carsInfo = new ArrayList<>();
        for (Car car : cars) {
            carsInfo.add(car.toString());
        }
        assertThat(race.getRaceCarsInfo()).isEqualTo(carsInfo);
    }

    @Test
    void hasNextRound_확인() {
        assertTrue(race.hasNextRound());
    }

    @Test
    void hasNextRound_전부_돌고_확인() {
        race.moveAllCarOneTime();
        assertFalse(race.hasNextRound());
    }

    @Test
    void moveAllCars_확인() {
        Race race = new Race(cars, Const.MIN_ROUND_COUNT + 10);
        race.moveAllCars();
        assertFalse(race.hasNextRound());
    }

    @AfterEach
    void tearDown() {
        cars = null;
        race = null;
    }
}