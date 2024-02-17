package domain.name;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Names {
    private List<Name> names;

    public Names(List<Name> carNames) {
        validate(carNames);
        this.names = carNames;
    }

    private void validate(List<Name> names) {
        int size = names.size();

        Set<Name> nonDuplicate = new HashSet<>(names);
        if (size != nonDuplicate.size()) {
            throw new IllegalArgumentException("중복된 이름이 있습니다.");
        }
    }

    public List<Name> getNames() {
        return names;
    }
}
