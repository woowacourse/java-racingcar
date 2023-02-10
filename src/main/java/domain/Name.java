package domain;

public class Name {

    private final String name;
    private final int order;

    public String getName() {
        return name;
    }

    public int getOrder() {
        return order;
    }

    public Name(String name, int order) {
        this.name = name;
        this.order = order;
    }
}
