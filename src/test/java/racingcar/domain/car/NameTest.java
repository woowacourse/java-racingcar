package racingcar.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class NameTest {
    @Test
    @DisplayName("이름 입력받는 기능")
    void carName_생성_테스트(){
        Name name1 = new Name("샐리");
        Name name2 = new Name("현구막");
        assertThat(name1.toString()).isEqualTo("샐리");
        assertThat(name2.toString()).isEqualTo("현구막");
    }

    @Test
    @DisplayName("이름이 5자 초과인 경우")
    void carName_5자초과_예외처리() {
        assertThatThrownBy(() -> new Name("샐리와현구막")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("이름에 공백이 존재하는 경우")
    void carName_duplicate_예외처리() {
        assertThatThrownBy(() -> new Name("샐리 와")).isInstanceOf(IllegalArgumentException.class);
    }
}