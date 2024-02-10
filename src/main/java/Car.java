import java.util.HashSet;
import java.util.Set;

public class Car {
    private static Set<String> nameSet = new HashSet<>();
    private String name;
    private int count;


    public Car(String name) {
        validateNameLength(name);
        validateNameDuplication(name);
        this.name = name;
        this.count = 1;
    }

    private void validateNameLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 길이가 혀용 길이를 초과힙니다.");
        }
    }

    private void validateNameDuplication(String name) {
        if (!nameSet.add(name)) {
            throw new IllegalArgumentException("이름이 중복됩니다.");
        }
    }

    public int incrementCount() {
        return this.count++;
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }
}
