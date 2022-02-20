package racingcar;

import static org.assertj.core.api.Assertions.*;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.vo.Name;

class NameHandlerTest {

    @Test
    @DisplayName("String 형태의 이름을 List<Name>으로 변환한다")
    void createNames() {
        // given
        String input = " hoho,rich , pobi ";

        // when
        List<Name> result = NameHandler.stringToNames(input);

        // then
        assertThat(result).containsExactly(new Name("hoho"), new Name("rich"), new Name("pobi"));
    }

    @Test
    @DisplayName("이름이 중복일 경우 예외를 발생한다")
    void carNameShouldNotDuplicateName() {
        // given
        String input = "hoho,hoho,rich,rich";

        // when & then
        assertThatIllegalArgumentException()
            .isThrownBy(() -> NameHandler.stringToNames(input))
            .withMessageMatching("이름은 중복될 수 없습니다.");
    }
}
