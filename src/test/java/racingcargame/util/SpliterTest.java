package racingcargame.util;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SpliterTest {

    @Test
    void 자동차이름_추출() {
        String input = "jason,pobi,crong";
        String[] result = Spliter.split(input);
        assertThat(result).isEqualTo(new String[]{"jason", "pobi", "crong"});
    }

}