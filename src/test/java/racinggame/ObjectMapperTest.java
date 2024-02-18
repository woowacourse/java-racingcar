package racinggame;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racinggame.domain.Car;
import racinggame.domain.Round;

class ObjectMapperTest {

    final ObjectMapper objectMapper = new ObjectMapper();

    @DisplayName("생성 테스트")
    @Test
    void create() {
        assertThatCode(ObjectMapper::new)
            .doesNotThrowAnyException();
    }

    @DisplayName("자동차의 이름들을 입력받아 자동차를 생성할 수 있다.")
    @Test
    void mapToCars() {
        List<Car> cars = objectMapper.mapToCars("아톰,이상");

        assertThat(cars)
            .containsExactly(new Car("아톰"), new Car("이상"));
    }

    @DisplayName("자동차 경주 라운드를 생성할 수 있다.")
    @Test
    void mapToRound() {
        Round round = objectMapper.mapToRound("1");
        round.decrease();

        assertThat(round.isPlayable()).isFalse();
    }

    @DisplayName("숫자가 아닌 문자열로 라운드를 생성할 수 없다.")
    @Test
    void mapToRoundWith() {
        assertThatThrownBy(() -> objectMapper.mapToRound("abc"))
            .isInstanceOf(NumberFormatException.class)
            .hasMessage("숫자만 입력해주세요.");
    }
}
