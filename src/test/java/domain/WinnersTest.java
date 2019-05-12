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
 * Date: 2019-05-13
 */
class WinnersTest {
    List<Car> cars;
    Winners winners;

    @BeforeEach
    void setUp() {
        cars = new ArrayList<>();
        cars.add(new Car("win", Const.CAR_OBJ_INIT_POSITION + 3));
        cars.add(new Car("ner", Const.CAR_OBJ_INIT_POSITION + 3));
        cars.add(new Car("!!", Const.CAR_OBJ_INIT_POSITION + 1));
        winners = new Winners(cars);
    }

    @Test
    void getWinnersName_확인() {
        assertThat(winners.getWinnersName()).isEqualTo("win,ner");
    }

    @Test
    void isMatchMaxPosition_확인() {
        assertTrue(winners.isMatchMaxPosition(Const.CAR_OBJ_INIT_POSITION + 3));
    }

    @AfterEach
    void tearDown() {
        cars = null;
        winners = null;
    }
}