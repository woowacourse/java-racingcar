package racingcar.domain;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.vo.Name;
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
}
