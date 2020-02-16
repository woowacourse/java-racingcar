package racingcargame.domain;

import org.junit.jupiter.api.Test;
import racingcargame.view.OutputView;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingCarsTest {

    @Test
    void 최종우승자_추출() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("pobi",3));
        cars.add(new Car("jason",1));
        cars.add(new Car("brown",4));
        cars.add(new Car("coil",4));
        RacingCars racingCars = new RacingCars(cars);
        Winners winners = new Winners(racingCars.extractWinners());
        boolean result = winners.contain("brown");
        assertThat(result).isTrue();
        result = winners.contain("coil");
        assertThat(result).isTrue();
        result = winners.contain("pobi");
        assertThat(result).isFalse();
    }

    @Test
    void 중복이름_RacingCars_생성() {
        assertThatThrownBy(() -> {
            String duplicatedInput = "pobi, pobi, jason";
            RacingCars.createRacingCars(duplicatedInput);
        }).isInstanceOf(IllegalStateException.class);
    }

    @Test
    void 이름_입력이_한개_들어왔을_때() {
        assertThatThrownBy(() -> {
            String oneSizeInput = "pobi";
            RacingCars.createRacingCars(oneSizeInput);
        }).isInstanceOf(IllegalStateException.class);
    }

    @Test
    void 이름입력이_안들어왔을때() {
        assertThatThrownBy(() -> {
            String zeroInput = "";
            RacingCars.createRacingCars(zeroInput);
        }).isInstanceOf(IllegalStateException.class);
    }

    @Test
    void 공백으로_이름_입력이_들어왔을_때() {
        assertThatThrownBy(() -> {
            String duplicatedInput = "    ";
            RacingCars.createRacingCars(duplicatedInput);
        }).isInstanceOf(IllegalStateException.class);
    }
}
