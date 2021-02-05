package car;

import java.util.Objects;

public class Name {
    
    private static final int NAME_RANGE = 5;
    
    private final String name;
    
    public static Name from(String name) {
        if (!isOutOfBounds(name)) {
            throw new IllegalArgumentException();
        }
        
        return new Name(name);
    }
    
    private static boolean isOutOfBounds(String name) {
        return name.length() <= NAME_RANGE && !name.isEmpty();
    }
    
    private Name(String name) {
        this.name = name;
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
