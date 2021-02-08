package car.domain;

import java.util.Objects;

final class Name {
    
    private static final int NAME_RANGE = 5;
    
    private final String name;
    
    private Name(String name) {
        this.name = name;
    }
    
    public static Name from(String name) {
        if (!isValidName(name)) {
            throw new IllegalArgumentException();
        }
        
        return new Name(name);
    }
    
    private static boolean isValidName(String name) {
        return !Objects.isNull(name) && isValidNameLength(name);
    }
    
    private static boolean isValidNameLength(String name) {
        return name.length() <= NAME_RANGE && !name.isEmpty();
    }
    
    public String getName() {
        return name;
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
