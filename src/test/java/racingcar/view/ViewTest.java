package racingcar.view;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ViewTest {
    @Test
    void 이름_입력값이_올바른지_확인() {
        assertThat(View.isNamesValid("conas,van,sun,gi".split(","))).isEqualTo(true);       //올바른 입력일 때
        assertThat(View.isNamesValid("conas,vanddddd,sun,gi".split(","))).isEqualTo(false); //길이 제한을 넘었을 때
        assertThat(View.isNamesValid("conas,1231,sun,gi".split(","))).isEqualTo(false);     //영문자가 아닌 다른 문자를 입력하였을 때
        assertThat(View.isNamesValid("conas,conas,sun,gi".split(","))).isEqualTo(false);    //중복된 이름이 존재할 때
    }
}
