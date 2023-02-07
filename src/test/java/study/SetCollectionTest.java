package study;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;
import org.assertj.core.internal.IterableElementComparisonStrategy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class SetCollectionTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    @DisplayName("Set의 Size 메서드 사용 테스트")
    void sizeTest(){
        //when
        int size = numbers.size();

        //then
        assertEquals(size, 3);
        assertThat(numbers).hasSize(3);
    }

    @ParameterizedTest
    @DisplayName("Parameterized 활용 테스트")
    @ValueSource(ints = {1, 2, 3})
    void containsCorrectValues(int value) {
        assertThat(numbers.contains(value)).isTrue();
    }
}
