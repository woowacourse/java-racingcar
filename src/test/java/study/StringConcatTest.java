package study;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class StringConcatTest {
    @Test
    void 루프_내에서_문자열_연결시_StringBuilder가_더_빠르다() {
        // given
        String example = "example";

        // when: String
        String resultString = "";
        long startTimeForString = System.nanoTime();
        for (int i = 0; i < 3; i++) {
            resultString += example; // 매 반복마다 새로운 String 객체 생성
        }
        long endTimeForString = System.nanoTime();

        // when: StringBuilder
        StringBuilder resultBuilder = new StringBuilder();
        long startTimeForBuilder = System.nanoTime();
        for (int i = 0; i < 3; i++) {
            resultBuilder.append(example); // 동일 객체 내에서 문자열 추가
        }
        long endTimeForBuilder = System.nanoTime();

        // then
        long durationForString = endTimeForString - startTimeForString;
        long durationForBuilder = endTimeForBuilder - startTimeForBuilder;

        System.out.println("durationForString = " + durationForString);
        System.out.println("durationForBuilder = " + durationForBuilder);

        assertTrue(durationForString > durationForBuilder);
    }

    @Test
    void 단일_표현식에서_문자열_연결시_StringBuilder가_더_빠르다() {
        // given
        String example = "example";

        // when: String
        long startTimeForString = System.nanoTime();
        String resultString = example + example + example;
        long endTimeForString = System.nanoTime();

        // when: StringBuilder
        long startTimeForBuilder = System.nanoTime();
        StringBuilder resultBuilder = new StringBuilder();
        resultBuilder.append(example).append(example).append(example);
        String finalResult = resultBuilder.toString();
        long endTimeForBuilder = System.nanoTime();

        // then
        long durationForString = endTimeForString - startTimeForString;
        long durationForBuilder = endTimeForBuilder - startTimeForBuilder;

        System.out.println("durationForString = " + durationForString);
        System.out.println("durationForBuilder = " + durationForBuilder);

        assertTrue(durationForString > durationForBuilder);
    }

    @Test
    void final_사용하여_루프_내에서_문자열_연결시_StringBuilder가_더_빠르다() {
        // given
        String example = "example";

        // when: String
        String resultString = "";
        long startTimeForString = System.nanoTime();
        for (int i = 0; i < 3; i++) {
            resultString += example; // 매 반복마다 새로운 String 객체 생성
        }
        long endTimeForString = System.nanoTime();

        // when: StringBuilder
        StringBuilder resultBuilder = new StringBuilder();
        long startTimeForBuilder = System.nanoTime();
        for (int i = 0; i < 3; i++) {
            resultBuilder.append(example); // 동일 객체 내에서 문자열 추가
        }
        long endTimeForBuilder = System.nanoTime();

        // then
        long durationForString = endTimeForString - startTimeForString;
        long durationForBuilder = endTimeForBuilder - startTimeForBuilder;

        System.out.println("durationForString = " + durationForString);
        System.out.println("durationForBuilder = " + durationForBuilder);

        assertTrue(durationForString > durationForBuilder);
    }

    @Test
    void 리터럴_사용하여_루프_내에서_문자열_연결시_StringBuilder_더_빠르다() {
        // when: String
        String resultString = "";
        long startTimeForString = System.nanoTime();
        for (int i = 0; i < 3; i++) {
            resultString += "example"; // 매 반복마다 새로운 String 객체 생성
        }
        long endTimeForString = System.nanoTime();

        // when: StringBuilder
        StringBuilder resultBuilder = new StringBuilder();
        long startTimeForBuilder = System.nanoTime();
        for (int i = 0; i < 3; i++) {
            resultBuilder.append("example"); // 동일 객체 내에서 문자열 추가
        }
        long endTimeForBuilder = System.nanoTime();

        // then
        long durationForString = endTimeForString - startTimeForString;
        long durationForBuilder = endTimeForBuilder - startTimeForBuilder;

        System.out.println("durationForString = " + durationForString);
        System.out.println("durationForBuilder = " + durationForBuilder);

        assertTrue(durationForString > durationForBuilder);
    }

    @Test
    void final_사용하여_단일_표현식에서_문자열_연결시_String이_더_빠르다() {
        // given
        final String example = "example";

        // when: String
        long startTimeForString = System.nanoTime();
        String resultString = example + example + example;
        long endTimeForString = System.nanoTime();

        // when: StringBuilder
        long startTimeForBuilder = System.nanoTime();
        StringBuilder resultBuilder = new StringBuilder();
        resultBuilder.append(example).append(example).append(example);
        String finalResult = resultBuilder.toString();
        long endTimeForBuilder = System.nanoTime();

        // then
        long durationForString = endTimeForString - startTimeForString;
        long durationForBuilder = endTimeForBuilder - startTimeForBuilder;

        System.out.println("durationForString = " + durationForString);
        System.out.println("durationForBuilder = " + durationForBuilder);

        assertTrue(durationForString < durationForBuilder);
    }

    @Test
    void 리터럴_사용하여_단일_표현식에서_문자열_연결시_String이_더_빠르다() {
        // when: String
        long startTimeForString = System.nanoTime();
        String resultString = "example" + "example" + "example"; // 컴파일 시에 문자열들 결합하여 하나의 문자의 리터럴 만듦
        long endTimeForString = System.nanoTime();

        // when: StringBuilder
        long startTimeForBuilder = System.nanoTime();
        StringBuilder resultBuilder = new StringBuilder();
        resultBuilder.append("example").append("example").append("example");
        String finalResult = resultBuilder.toString();
        long endTimeForBuilder = System.nanoTime();

        // then
        long durationForString = endTimeForString - startTimeForString;
        long durationForBuilder = endTimeForBuilder - startTimeForBuilder;

        System.out.println("durationForString = " + durationForString);
        System.out.println("durationForBuilder = " + durationForBuilder);

        assertTrue(durationForString < durationForBuilder);
    }
}
