package racingcar.domain;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.vo.Name;
import racingcar.vo.Winners;
import static org.assertj.core.api.Assertions.*;

public class CarsTest {
    @Test
    @DisplayName("자동차의 이름으로 자동차 리스트를 생성한다")
    void newCarsByNames() {
        // given
        List<Name> names = List.of(Name.create("hoho"), Name.create("rich"), Name.create("pobi"));

        // when & then
        assertThatCode(() -> new Cars(names)).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("자동차 경주가 끝나면 우승자는 반드시 한명 이상 존재한다")
    void existsWinner() {
        Cars cars = new Cars(List.of(Name.create("hoho"), Name.create("rich"), Name.create("pobi")));
        cars.move();
        Winners winners = cars.getWinners();

        assertThat(winners.getWinners().size()).isGreaterThan(1);
    }
}
