package domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingCarsTest {

    private RacingCar pobi;
    private RacingCar honux;
    private RacingCar ethan;

    @BeforeEach
    void setUp() {
        pobi = createMoveRacingCar("pobi");
        honux = createMoveRacingCar("honux");
        ethan = createNotMoveRacingCar("ethan");
    }

    private RacingCar createMoveRacingCar(final String carName) {
        return new RacingCar(new Name(carName)) {
            @Override
            protected int getRandomInteger() {
                return 4;
            }
        };
    }

    private RacingCar createNotMoveRacingCar(final String carName) {
        return new RacingCar(new Name(carName)) {
            @Override
            protected int getRandomInteger() {
                return 3;
            }
        };
    }

    @Test
    @DisplayName("3대의 자동차를 보관하는 RacingCars가 정상 생성되는지 확인")
    void createRacingCars() {
        //given
        List<RacingCar> racingCars = List.of(pobi, honux, ethan);

        //when
        RacingCars result = new RacingCars(racingCars);

        //then
        assertThat(result.getRacingCars()).containsExactly(pobi, honux, ethan);
    }
}