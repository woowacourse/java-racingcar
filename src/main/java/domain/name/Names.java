package domain.name;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Names {
    private final List<Name> value;

    public Names(List<Name> carNames) {
        validate(carNames);
        this.value = carNames;
    }

    private void validate(List<Name> names) {
        int size = names.size();

        Set<Name> nonDuplicate = new HashSet<>(names);
        if (size != nonDuplicate.size()) {
            throw new IllegalArgumentException("중복된 이름이 있습니다.");
        }
    }

    public List<Name> getNames() {
        return Collections.unmodifiableList(value);
    }
}
