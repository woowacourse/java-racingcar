package learningTest;

import org.assertj.core.api.Assert;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        List<String> strings1 = Arrays.asList(new String[]{"a","b"});
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
}
