package javaracingcar.domain;

import utils.StringUtils;

import java.util.Objects;

public class Name {
    private final int MAX_NAME_LENGTH = 5;
    private final String name;

    public Name(String name) {
        validateNonBlank(name);
        validateNameLength(name);
        this.name = name.trim();
    }

    private void validateNonBlank(String name) {
        if (StringUtils.isBlank(name)) {
            throw new IllegalArgumentException("빈 문자열이 입력되었습니다.");
        }
    }

    private void validateNameLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("이름이 최대길이를 초과했습니다.");
        }
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name1 = (Name) o;
        return Objects.equals(name, name1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(MAX_NAME_LENGTH, name);
    }
}
