package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CarNameCatalogTest {

    @Test
    @DisplayName("이름들을 통해 자동차 명단을 만든다")
    void createCarCatalog(){
        List<Name> carNameCatalog = List.of(new Name("poby"), new Name("pond"));

        CarNameCatalog catalog = new CarNameCatalog(carNameCatalog);

        assertInstanceOf(CarNameCatalog.class, catalog);

    }
    @Test
    @DisplayName("중복된 이름이 있으면 예외를 발생한다")
    void throwExceptionWhenNameIsDuplicate(){
        List<Name> duplicateCarNameCatalog = List.of(new Name("pond"),new Name("pond"));

        assertThrows(IllegalArgumentException.class, ()->{
            new CarNameCatalog(duplicateCarNameCatalog);
        });
    }


}