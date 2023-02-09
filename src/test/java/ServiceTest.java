import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


import static org.assertj.core.api.Assertions.assertThat;

class ServiceTest {
    Service service;

    @BeforeEach
    void setUp() {
        service = new Service();
    }

    @ParameterizedTest
    @CsvSource(value = {"5:true", "2:false" }, delimiter = ':')
    void judgement(int randomNumber, boolean result) {
        assertThat(service.judgement(randomNumber)).isEqualTo(result);
    }
}