package racingcargame.utils;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RandomNumberGeneratorTest {
    private List<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
    }

    @ParameterizedTest
    @CsvSource(value = {"0:9", "0:3", "0:8", "0:4"}, delimiter = ':')
    @DisplayName("난수 생성을 위한 인덱스 swap 확인")
    void swapForMakeRandomNumber(int input, int expected) {
        int randomNumber = RandomNumberGenerator.getRandomNumber(RandomNumberGenerator.swap(numbers, input, expected));

        assertEquals(expected, randomNumber);
    }

    @Test
    @DisplayName("생성한 난수가 0-9의 범위인지 확인")
    void createRandomNumberRightRange() {
        int actual = RandomNumberGenerator.makeRandomNumber();

        assertThat(numbers.contains(actual)).isTrue();
    }

    @Test
    @DisplayName("swap을 위해 필요한 서로 다른 인덱스를 추출하는지 확인")
    void createDifferentIndexForSwap() {
        Random random = new Random();
        List<Integer> indexList = RandomNumberGenerator
                .makeDifferentIndexForShuffle(random, 0, 0);

        assertThat(indexList.get(0)).isNotEqualTo(indexList.get(1));
    }

}