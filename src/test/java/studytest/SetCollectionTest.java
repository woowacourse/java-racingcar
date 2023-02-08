package studytest;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
}
