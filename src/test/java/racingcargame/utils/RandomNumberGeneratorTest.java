package racingcargame.utils;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RandomNumberGeneratorTest {
    private static final List<Integer> numbers = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);

    @ParameterizedTest
    @CsvSource(value = {"0:9", "0:3", "0:8", "0:4"}, delimiter = ':')
    void 난수_생성을_위한_인덱스_swap_테스트(int input, int expected) {
        int randomNumber = RandomNumberGenerator.getRandomNumber(RandomNumberGenerator.swap(numbers, input, expected));

        assertEquals(expected, randomNumber);
    }

    @Test
    void 난수_생성_범위_테스트() {
        int actual = RandomNumberGenerator.makeRandomNumber();

        assertThat(numbers.contains(actual)).isTrue();
    }

    @Test
    void swap을_위한_서로_다른_인덱스_추출() {
        Random random = new Random();
        List<Integer> indexList = RandomNumberGenerator
                .makeDifferentIndexForShuffle(random, 0, 0, 10);

        assertThat(indexList.get(0)).isNotEqualTo(indexList.get(1));
    }

}