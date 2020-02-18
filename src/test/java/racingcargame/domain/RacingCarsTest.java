package racingcargame.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingCarsTest {

    @Test
    @SuppressWarnings("NonAsciiCharacters")
    void 중복이름_RacingCars_생성() {
        assertThatThrownBy(() -> {
            String duplicatedInput = "pobi, pobi, jason";
            RacingCars.createRacingCars(duplicatedInput);
        }).isInstanceOf(IllegalStateException.class);
    }

    @Test
    @SuppressWarnings("NonAsciiCharacters")
    void 이름_입력이_한개_들어왔을_때() {
        assertThatThrownBy(() -> {
            String oneSizeInput = "pobi";
            RacingCars.createRacingCars(oneSizeInput);
        }).isInstanceOf(IllegalStateException.class);
    }

    @Test
    @SuppressWarnings("NonAsciiCharacters")
    void 이름입력이_안들어왔을때() {
        assertThatThrownBy(() -> {
            String zeroInput = "";
            RacingCars.createRacingCars(zeroInput);
        }).isInstanceOf(IllegalStateException.class);
    }

    @Test
    @SuppressWarnings("NonAsciiCharacters")
    void 공백으로_이름_입력이_들어왔을_때() {
        assertThatThrownBy(() -> {
            String duplicatedInput = "    ";
            RacingCars.createRacingCars(duplicatedInput);
        }).isInstanceOf(IllegalStateException.class);
    }
}
