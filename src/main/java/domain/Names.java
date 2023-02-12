package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Names {

    private static final int MIN_PARTICIPANT = 2;
    private final List<Name> names = new ArrayList<>();

    public Names(final List<String> input) {
        validateMinParticipantNumber(input);
        input.stream()
                .map(Name::new)
                .forEach(this.names::add);
    }

    private void validateMinParticipantNumber(final List<String> names) {
        if (names.size() < MIN_PARTICIPANT) {
            throw new IllegalArgumentException("[ERROR] 최소" + MIN_PARTICIPANT + "이상의 참여자가 필요합니다.");
        }
    }

    public List<Name> getNames() {
        return Collections.unmodifiableList(names);
    }
}
