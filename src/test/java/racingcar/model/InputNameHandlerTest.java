package racingcar.model;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.model.InputNameHandler;
import racingcar.model.vo.Name;
import static org.assertj.core.api.Assertions.*;

class InputNameHandlerTest {
    @Test
    @DisplayName("List<Name> 생성 테스트")
    void createNames() {
        // given
        String input = " hoho,rich , pobi ";

        // when
        List<Name> result = InputNameHandler.createNames(input);

        // then
        assertThat(result).containsExactly(Name.of("hoho"), Name.of("rich"), Name.of("pobi"));
    }

    @Test
    @DisplayName("이름이 중복일 경우 예외 발생 테스트")
    void carNameShouldNotDuplicateName() {
        // given
        String input = "hoho,hoho,rich,rich";

        // when & then
        assertThatIllegalArgumentException()
            .isThrownBy(() -> InputNameHandler.createNames(input))
            .withMessageMatching("이름은 중복될 수 없습니다.");
    }

}