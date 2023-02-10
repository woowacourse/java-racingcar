package domain;

public class Name {

    private final String name;
    private final int identifier;

    public String getName() {
        return name;
    }

    public int getIdentifier() {
        return identifier;
    }

    public Name(String name, int order) {
        this.name = name;
        this.identifier = order;
    }
}
