package studytest;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class SetCollectionTest {
    @Test
    @DisplayName("Set의 사이즈를 반환한다")
    void Set의_사이즈를_반환한다(){
        HashSet<Integer> input = new HashSet<>();
        input.add(1);
        input.add(2);
        input.add(3);

        assertThat(input).hasSize(3);
    }

    @ParameterizedTest
    @DisplayName("Set에 값이 존재하는지 알 수 있다")
    @ValueSource(ints = {1,2,3})
    void Set에_값이_존재하는지_알_수_있다(int provided){
        Set<Integer> set = Set.of(1, 2, 3);

        assertThat(set).contains(provided);
    }
}
