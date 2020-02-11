package learningTest;

import org.assertj.core.api.Assert;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

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

}
