package racinggame;

import java.util.Objects;

public class Name {

    private final String name;

    private Name(String name) {
        this.name = name;
    }

    public static Name from(String name) {
        if (name.isEmpty()) {
            throw new RuntimeException();
        }

        if (name.length() > 5) {
            throw new RuntimeException();
        }

        return new Name(name);
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name1 = (Name) o;
        return Objects.equals(name, name1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
