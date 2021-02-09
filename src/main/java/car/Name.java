package car;

import java.util.Objects;

public class Name {

    private String name;
    final static int CAR_NAME_LIMIT = 5;

    public Name(String name) {
        this.name = name;
    }

    public String getName() {
        isValidName(name);
        return name;
    }

    private void isValidName(String name) {

        if (name.length() <= CAR_NAME_LIMIT && !name.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Name name1 = (Name) o;
        return Objects.equals(name, name1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
