package racingcargame.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingCarsTest {

    private static final int MOVE_POSITIONN = 1;
    private static final int NO_MOVE_POSITION = 0;
    private static LimitEngine limitEngine;

    @BeforeAll
    static void initialize() {
        limitEngine = new LimitEngine();
    }

    @Test
    void 생성자_테스트() {
        String inputCarNames = "pobi,jason";
        assertThat(RacingCars.createRacingCars(inputCarNames, limitEngine))
                .isInstanceOf(RacingCars.class);
    }

    @Test
    @SuppressWarnings("NonAsciiCharacters")
    void 중복이름_RacingCars_생성() {
        assertThatThrownBy(() -> {
            String duplicatedInput = "pobi, pobi, jason";
            RacingCars.createRacingCars(duplicatedInput, limitEngine);
        }).isInstanceOf(IllegalStateException.class);
    }

    @Test
    @SuppressWarnings("NonAsciiCharacters")
    void 이름_입력이_한개_들어왔을_때() {
        assertThatThrownBy(() -> {
            String oneSizeInput = "pobi";
            RacingCars.createRacingCars(oneSizeInput, limitEngine);
        }).isInstanceOf(IllegalStateException.class);
    }

    @Test
    @SuppressWarnings("NonAsciiCharacters")
    void 이름입력이_안들어왔을때() {
        assertThatThrownBy(() -> {
            String zeroInput = "";
            RacingCars.createRacingCars(zeroInput, limitEngine);
        }).isInstanceOf(IllegalStateException.class);
    }

    @Test
    @SuppressWarnings("NonAsciiCharacters")
    void 공백으로_이름_입력이_들어왔을_때() {
        assertThatThrownBy(() -> {
            String duplicatedInput = "    ";
            RacingCars.createRacingCars(duplicatedInput, limitEngine);
        }).isInstanceOf(IllegalStateException.class);
    }

    @Test
    @SuppressWarnings("NonAsciiCharacters")
    void 모든_자동차_이동() {
        // given
        String inputCarsNames = "pobi, jason";
        Engine movableEngine = new Engine() {
            @Override
            public boolean isMovable(int power) {
                return true;
            }
        };
        RacingCars racingCars = RacingCars.createRacingCars(inputCarsNames, movableEngine);
        // when
        racingCars.move();
        // then
        List<Car> unmodifiableCars = racingCars.getUnmodifiableCars();
        for (Car car : unmodifiableCars) {
            assertThat(car.getPosition()).isEqualTo(MOVE_POSITIONN);
        }
    }

    @Test
    @SuppressWarnings("NonAsciiCharacters")
    void 모든_자동차_이동_X() {
        // given
        String inputCarsNames = "pobi, jason";
        Engine movableEngine = new Engine() {
            @Override
            public boolean isMovable(int power) {
                return false;
            }
        };
        RacingCars racingCars = RacingCars.createRacingCars(inputCarsNames, movableEngine);
        // when
        racingCars.move();
        // then
        List<Car> unmodifiableCars = racingCars.getUnmodifiableCars();
        for (Car car : unmodifiableCars) {
            assertThat(car.getPosition()).isEqualTo(NO_MOVE_POSITION);
        }
    }

}
