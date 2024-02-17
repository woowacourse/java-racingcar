package domain;

import domain.name.Name;
import domain.name.Names;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NamesTest {

    @Test
    @DisplayName("이름들을 통해 이름 명단을 만든다")
    void createCarCatalog() {
        List<Name> carNameCatalog = List.of(new Name("poby"), new Name("pond"));

        Names catalog = new Names(carNameCatalog);

        assertInstanceOf(Names.class, catalog);

    }

    @Test
    @DisplayName("중복된 이름이 있으면 예외를 발생한다")
    void throwExceptionWhenNameIsDuplicate() {
        List<Name> duplicateCarNameCatalog = List.of(new Name("pond"), new Name("pond"));

        assertThrows(IllegalArgumentException.class, () -> {
            new Names(duplicateCarNameCatalog);
        });
    }


}
