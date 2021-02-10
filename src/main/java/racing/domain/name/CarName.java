package racing.domain.name;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CarName implements Name{
    private static final Pattern PATTERN = Pattern.compile("[a-zA-Z]{1,5}");

    private final String name;

    public CarName(final String name) {
        String copy = new String(name);
        validateName(copy);
        this.name = copy;
    }

    private void validateName(final String name) {
        if (Objects.isNull(name)) {
            throw new IllegalArgumentException("자동차 이름을 입력해주세요");
        }
        Matcher matcher = PATTERN.matcher(name);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(String.format("%s는 유효하지 않은 이름입니다. 영어 대소문자만 입력해주세요.", name));
        }
    }

    @Override
    public String getName() {
        return name;
    }
}
