package study;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class UsingRecursiveComparisonStudyTest {

    @Test
    void usingRecursiveComparisonTest_1() {
        List<Member> members = List.of(
                new Member(1, "backend developer"),
                new Member(2, "DBA"),
                new Member(3, "frontend developer")
        );

        List<Member> other = List.of(
                new Member(1, "DBA"),
                new Member(2, "frontend developer"),
                new Member(3, "backend developer")
        );

        assertThat(members).usingRecursiveComparison()
                .comparingOnlyFields("job")
                .ignoringCollectionOrder()
                .isEqualTo(other);
    }

    @Test
    void usingRecursiveComparisonTest_2() {
        Member member = new Member(1, "DBA");
        Member other = new Member(2, "DBA");

        assertThat(member).usingRecursiveComparison()
                .comparingOnlyFields("job")
                .isEqualTo(other);
    }
}
