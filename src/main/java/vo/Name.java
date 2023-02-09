package vo;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Name {
    private final String name;

    private Name(String name) {
        this.name = name;
    }

    public static Name of(String name) {
        return new Name(name);
    }

    public static List<Name> of(List<String> names) {
        return names.stream().map(Name::new).collect(Collectors.toList());
    }

    public String getValue() {
        return name;
    }

    public int length() {
        return name.length();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name1 = (Name) o;
        return name.equals(name1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Name{" +
                "name='" + name + '\'' +
                '}';
    }
}
