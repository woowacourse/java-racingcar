package racingcar.domain.car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import racingcar.exception.InvalidCarNameException;

class NameTest {

    @Test
    public void 생성_및_비교() {
        Name name1 = Name.of("hihi");
        Name name2 = Name.of("hihi");

        assertThat(name1).isEqualTo(name2);
    }

    @Test
    public void 유효성_검사() {
        assertThatThrownBy(() -> Name.of("woowahan"))
            .isInstanceOf(InvalidCarNameException.class);
    }

}