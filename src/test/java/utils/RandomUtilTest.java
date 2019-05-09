package utils;

import org.junit.jupiter.api.Test;
import utils.RandomUtil;

import static org.assertj.core.api.Assertions.assertThat;

//필요는 없지만 테스트코드 연습해보기 위해서
public class RandomUtilTest {
    @Test
    void 랜덤값() {
        Integer randNum = RandomUtil.randomNumber();
        assertThat(randNum).isBetween(0, 9);
        assertThat(randNum instanceof Integer).isEqualTo(true);
    }
}
