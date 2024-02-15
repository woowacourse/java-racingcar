import java.util.Arrays;

public class CarName {
    private final String name;

    public CarName(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (isInvalidNameLength(name)) {
            throw new IllegalArgumentException("[ERROR] 이름 길이는 1~5글자");
        }
    }

    private static boolean isInvalidNameLength(String name) {
        return name == null || name.isBlank() || name.length() > 5;
    }

    public String getName() {
        return name;
    }
}
