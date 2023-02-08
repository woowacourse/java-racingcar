public class Name {
    private final String name;

    public Name(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (name.isBlank() || name.length() > 5) {
            throw new IllegalArgumentException("이름은 1자 이상, 5자 이하만 가능합니다.");
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
