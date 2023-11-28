package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.groups.Tuple.tuple;

import java.util.List;
import java.util.Objects;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class AssertJWithIterableStudyTest {

    @Test
    void filteredOnTest() {
        List<Member> members = members();

        assertThat(members).filteredOn(Member::job, "woowa developer")
                .hasSize(2)
                .containsOnly(
                        new Member(2, "woowa developer"),
                        new Member(4, "woowa developer")
                );
    }

    @Test
    void containsExactlyVScontainsOnly() {
        List<Member> members = members();

        // contains: 순서 상관없이 주어진 요소가 있기만 하면 된다.
        assertThat(members).extracting("id")
                .contains(5, 3, 2, 4, 1);

        // containsOnly: 순서 상관없이 주어진 요소만 있어야 한다.
        assertThat(members).extracting("id")
                .containsOnly(5, 4, 3, 2, 1);

        // containsExactly: 순서, 주어진 요소 모두 동일해야 한다.
        assertThat(members).extracting("id")
                .containsExactly(1, 2, 3, 4, 5);
    }

    @Test
    void extractingTest1() {
        List<Member> members = members();

        assertThat(members).extracting("id")
                .containsExactly(1, 2, 3, 4, 5);
    }

    @Test
    void extractingTest2() {
        List<Member> members = members();

        assertThat(members).extracting("id", "job")
                .containsExactly(
                        tuple(1, "job seeker"),
                        tuple(2, "woowa developer"),
                        tuple(3, "student"),
                        tuple(4, "woowa developer"),
                        tuple(5, "delivery hero")
                );
    }

    /**
     * [실행 결과]
     * Multiple Failures (3 failures)
     * -- failure 1 --
     * expected: 2
     * but was: 1
     * at StringTest$IterableTestUsingAssertJ.lambda$softAssertionsTest$0(StringTest$IterableTestUsingAssertJ.java:103)
     * -- failure 2 --
     * expected: 3
     * but was: 1
     * at StringTest$IterableTestUsingAssertJ.lambda$softAssertionsTest$0(StringTest$IterableTestUsingAssertJ.java:104)
     * -- failure 3 --
     * expected: 4
     * but was: 1
     */
    @Test
    @Disabled
    void softAssertionsTest() {
        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(1).isEqualTo(1);
            softly.assertThat(1).isEqualTo(2);
            softly.assertThat(1).isEqualTo(3);
            softly.assertThat(1).isEqualTo(4);
        });
    }

    public static List<Member> members() {
        return List.of(
                new Member(1, "job seeker"),
                new Member(2, "woowa developer"),
                new Member(3, "student"),
                new Member(4, "woowa developer"),
                new Member(5, "delivery hero")
        );
    }
}

class Member {
    private final int id;
    private final String job;

    public Member(int id, String job) {
        this.id = id;
        this.job = job;
    }

    public String job() {
        return job;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return id == member.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
