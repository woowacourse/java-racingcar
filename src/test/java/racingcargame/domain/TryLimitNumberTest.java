package racingcargame.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class TryLimitNumberTest {
    @Test
    @SuppressWarnings("NonAsciiCharacters")
    void 범위초과_마이너스_숫자입력() {
        int input = -1;
        assertThatThrownBy(() ->
                new TryLimitNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @SuppressWarnings("NonAsciiCharacters")
    void 범위초과_제로_숫자입력() {
        int input = 0;
        assertThatThrownBy(() ->
                new TryLimitNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @SuppressWarnings("NonAsciiCharacters")
    void 시도횟수가_더_큰_경우_비교() {
        TryLimitNumber tryLimitNumber = new TryLimitNumber(30);
        boolean result = tryLimitNumber.isBiggerThan(29);
        assertThat(result).isTrue();
    }

    @Test
    @SuppressWarnings("NonAsciiCharacters")
    void 시도횟수가_더_작은_경우_비교() {
        TryLimitNumber tryLimitNumber = new TryLimitNumber(30);
        boolean result = tryLimitNumber.isBiggerThan(31);
        assertThat(result).isFalse();
    }
}