package car;

public class Name {
    private String name;
    
    public Name(String name) {
        this.name = name;
    }
    
    public String getName() {
        if (!isValid()) {
            throw new IllegalArgumentException();
        }
        
        return name;
    }
    
    private boolean isValid() {
        return name.length() <= 5 && !name.isEmpty();
    }
}
