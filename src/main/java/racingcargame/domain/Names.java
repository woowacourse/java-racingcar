package racingcargame.domain;

import java.util.Iterator;
import java.util.List;

public class Names {
    private List<Name> names;

    public Names(List<Name> names) {
        this.names = names;
    }

    public Iterator<Name> iterator() {
        return names.iterator();
    }

    public List<Name> getNames() {
        return names;
    }
}
