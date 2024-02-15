package racinggame.domain;

import java.util.Objects;

class Name {

    private final String name;

    private Name(String name) {
        this.name = name;
    }

    public static Name from(String name) {
        checkNameIsEmpty(name);
        checkNameLength(name);

        return new Name(name);
    }

    private static void checkNameIsEmpty(String name) {
        if (name.isEmpty()) {
            throw new RuntimeException();
        }
    }

    private static void checkNameLength(String name) {
        if (name.length() > 5) {
            throw new RuntimeException();
        }
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
