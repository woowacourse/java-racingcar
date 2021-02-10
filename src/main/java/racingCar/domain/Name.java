package racingCar.domain;

import java.util.Objects;
import racingCar.exception.InvalidCarNameException;
import racingCar.utils.ValidateUtils;

public class Name {

    private final String name;

    public Name(final String name){
        if(!ValidateUtils.validateCarName(name)){
            throw new InvalidCarNameException("자동차 이름은 1자 이상 5자 이하이어야 합니다.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Name name1 = (Name) o;
        return Objects.equals(name, name1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
