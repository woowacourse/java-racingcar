package racingcar.domain.car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.exception.InvalidCarNameException;

class NameTest {

    @Test
    public void 생성_및_비교() {
        Name name1 = Name.of("hihi");
        Name name2 = Name.of("hihi");

        assertThat(name1).isEqualTo(name2);
    }

    @DisplayName("이름 길이가 5자 이상 예외처리 테스트")
    @Test
    public void 유효성_검사() {
        assertThatThrownBy(() -> Name.of("woowahan"))
            .isInstanceOf(InvalidCarNameException.class);
    }

}