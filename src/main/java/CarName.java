public class CarName {
    private static final int MAX_NAME_LENGTH = 5;
    private final String name;

    public CarName(String name) {
        if (name == null || name.isBlank() || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("잘못된 이름입니다.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }
}