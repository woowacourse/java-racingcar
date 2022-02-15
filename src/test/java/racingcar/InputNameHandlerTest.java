package racingcar;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.vo.Name;
import static org.assertj.core.api.Assertions.*;

class InputNameHandlerTest {
    @Test
    @DisplayName("List<Name> 생성 테스트")
    void createNames() {
        // given
        String input = " hoho,rich , pobi ";

        // when
        List<Name> result = InputNameHandler.inputToNames(input);

        // then
        assertThat(result).containsExactly(Name.create("hoho"), Name.create("rich"), Name.create("pobi"));
    }

    @Test
    @DisplayName("이름이 중복일 경우 예외 발생 테스트")
    void carNameShouldNotDuplicateName() {
        // given
        String input = "hoho,hoho,rich,rich";

        // when & then
        assertThatIllegalArgumentException()
            .isThrownBy(() -> InputNameHandler.inputToNames(input))
            .withMessageMatching("이름은 중복될 수 없습니다.");
    }

}