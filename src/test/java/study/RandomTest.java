package study;

import java.util.Random;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class RandomTest {
    @Nested
    class SameSeedObject {
        Random random = new Random();

        @Test
        public void first() {
            random.setSeed(0);
            for (int i = 0; i < 5; i++) {
                System.out.print(random.nextInt(10));
            }
            System.out.println();
        }

        @Test
        public void second() {
            random.setSeed(0);
            for (int i = 0; i < 5; i++) {
                System.out.print(random.nextInt(10));
            }
            System.out.println();
        }
    }

    @Nested
    class SameObjectWithoutSettingSeed {
        Random random = new Random();
        @Test
        public void first() {
            for (int i = 0; i < 5; i++) {
                System.out.print(random.nextInt(10));
            }
            System.out.println();
        }

        @Test
        public void second() {
            for (int i = 0; i < 5; i++) {
                System.out.print(random.nextInt(10));
            }
            System.out.println();
        }
    }

    @Nested
    class DifferentObject {
        @Test
        public void first() {
            Random random = new Random();
            for (int i = 0; i < 5; i++) {
                System.out.print(random.nextInt(10));
            }
            System.out.println();
        }

        @Test
        public void second() {
            Random random = new Random();
            for (int i = 0; i < 5; i++) {
                System.out.print(random.nextInt(10));
            }
            System.out.println();
        }
    }
}
