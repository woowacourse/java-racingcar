package racingcargame.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcargame.domain.car.Name;

class RacingCarsTest {

    @Test
    @DisplayName("이름 리스트가 들어가면 RacingCars 객체가 제대로 생성되는지")
    void createRacingCarsTest() {
        List<Name> names = Name.createNameObjects("a,b,c");
        new RacingCars(names);
        assertThat(new RacingCars(names).getRacingCars().size()).isEqualTo(3);
    }
}
