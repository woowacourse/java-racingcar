package learningTest;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class LearningTest {
    @Test
    void CompareStringArray() {
        String[] a = {"a", "ab", "abc"};
        String[] b = {new String("a"), new String("ab"), new String("abc")};

        Assertions.assertThat(Arrays.equals(a, b))
                .isEqualTo(true)
                .isNotEqualTo(false);
    }

    @Test
    void contains() {
        String a = "\\n";
        System.out.println(a.contains("\\n"));
    }

    @Test
    void 리스트_한번더() {
        List<String> strings1 = Arrays.asList(new String[]{"a", "b"});
//        List<String> strings2 = Arrays.asList(strings1);
        System.out.println();
    }

    @Test
    void 테스트() {
        String string = "a1c";
        string.chars().forEach((t) -> {
            if (!Character.isDigit(t)) {
                System.out.println("no num");
            }
        });
    }

    @Test
    @DisplayName("random함수를 여러번 실행했을 때 다른 값이 나오는지 확인")
    void mathRandom() {
        IntStream.range(0, 10)
                .forEach((t) -> {
                    System.out.println(Math.random());
                });
    }
}
