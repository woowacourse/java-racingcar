package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.car.Name;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NameTest {

    @DisplayName("입력받은 이름이 5글자가 넘으면 Exception 발생")
    @Test
    void test1() {
        String name = "abcdef";

        assertThatThrownBy(() -> new Name(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("%s 는 5글자를 초과한 이름입니다.", name);
    }

    @DisplayName("이름 정상 생성 테스트")
    @Test
    void test2() {
        //given
        String input = "abc";
        //when
        Name name = new Name(input);
        //then
        assertThat(name).isEqualTo(new Name("abc"));
    }

    @DisplayName("이름 반환 기능")
    @Test
    void test3() {
        //given
        String input = "abc";
        //when
        Name name = new Name(input);
        //then
        assertThat(name.getName()).isEqualTo("abc");
    }
}