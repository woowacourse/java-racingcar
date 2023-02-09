package studytest;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class SetCollectionTest {
    @Test
    @DisplayName("Set의 사이즈를 반환한다")
    void Set의_사이즈를_반환한다() {
        HashSet<Integer> input = new HashSet<>();
        input.add(1);
        input.add(2);
        input.add(3);

        assertThat(input).hasSize(3);
    }

    @ParameterizedTest
    @DisplayName("Set에 값이 존재하는지 알 수 있다")
    @ValueSource(ints = {1, 2, 3})
    void Set에_값이_존재하는지_알_수_있다(int provided) {
        Set<Integer> set = Set.of(1, 2, 3);

        assertThat(set).contains(provided);
    }

    @ParameterizedTest
    @DisplayName("Set에 값의 유무를 알 수 있다")
    @CsvSource(value = {"1,2,3=true", "4,5=false"}, delimiter = '=')
    void Set에_값의_유무를_알_수_있다(String provided, boolean expected) {
        Set<Integer> set = Set.of(1, 2, 3);
        List<Integer> integers = parseIntegers(provided);
        assertThat(set.containsAll(integers)).isEqualTo(expected);
    }

    private List<Integer> parseIntegers(String provided) {
        String[] split = provided.split(",");
        return Arrays.stream(split)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
