package junitStudy;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class JunitStudyTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        //numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    void 첫테스트() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @Test
    void contain() {
        assertTrue(numbers.contains(1));
        assertTrue(numbers.contains(2));
        assertTrue(numbers.contains(3));
    }

    @Test
    void notContain() {
        assertFalse(numbers.contains(4));
        assertFalse(numbers.contains(5));
    }
}
