import org.junit.jupiter.api.Test;
import racingCar.domain.RacingCar;
import racingCar.domain.RacingCarWinnersSortOuter;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarWinnersSortOuterTest {

    @Test
    void 우승자를_가려낸다_우승자가_한명일_때() {
        RacingCar pobi = new RacingCar("pobi");
        pobi.setPosition(3);

        RacingCar crong = new RacingCar("crong");
        crong.setPosition(3);

        RacingCar honux = new RacingCar("honux");
        honux.setPosition(4);

        RacingCar[] competitors = {pobi, crong, honux};
        List<RacingCar> winners = RacingCarWinnersSortOuter.sortOut(competitors);
        assertThat(winners.size()).isEqualTo(1);
        assertThat(winners.get(0)).isEqualTo(honux);
    }
}
