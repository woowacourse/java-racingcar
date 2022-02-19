package study;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Objects;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ObjectTest {
	class Actual {
		private String name;

		Actual(String name) {
			this.name = name;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o)
				return true;
			if (o == null || getClass() != o.getClass())
				return false;
			Actual actual = (Actual)o;
			return Objects.equals(name, actual.name);
		}

		@Override
		public int hashCode() {
			return Objects.hash(name);
		}

		@Override
		public String toString() {
			return "Actual{" +
				"name='" + name + '\'' +
				'}';
		}
	}

	@DisplayName("equals 내부값 비교")
	@Test
	void isEquals() {
		Actual actual = new Actual("sudal");
		Actual other = new Actual("sudal");

		assertThat(actual.equals(other)).isTrue();
	}

	@DisplayName("equals 같은 객체인지?")
	@Test
	void isParity() {
		Actual actual = new Actual("sudal");
		Actual other = new Actual("sudal");

		assertThat(actual == other).isFalse();
	}

	@DisplayName("최댓값을 가진 자동차 찾기")
	@Test
	void toStringTest() {
		//given
		Actual actual = new Actual("sudal");
		//when
		assertThat(actual.toString()).isEqualTo("Actual{name='sudal'}");
	}
}
