package domain;

public class Name {

    private final String name;
    private final int index;

    public Name(String name, int index) {
        this.name = name;
        this.index = index;
    }

    @Override
    public String toString() {
        if (index > 0) {
            return name + index;
        }
        return name;
    }
}
