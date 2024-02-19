package domain;

import javax.swing.plaf.PanelUI;

public class CarName {
    private static final int MAX_NAME_LENGTH = 5;
    private final String name;

    public CarName(String name) {
        isPossibleName(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void isPossibleName(String name) {
        isNull(name);
        isBlank(name);
        isPossibleLength(name);
    }

    public void isNull(String name) {
        if (name == null) {
            throw new IllegalArgumentException("이름이 입력되지 않았습니다.");
        }
    }

    public void isBlank(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("이름이 공백입니다.");
        }
    }

    public void isPossibleLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 5자 이하여야 합니다.");
        }
    }
}
