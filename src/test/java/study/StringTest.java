package study;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

	@DisplayName("문자열 자르기 테스트")
	@Test
	public void split_테스트() {
		String splitValue = "1,2";
		assertThat(splitValue.split(",")).containsExactly("1", "2");
	}

	@DisplayName("문자열 반환 테스트")
	@Test
	void subString_테스트() {
		String subStringValue = "(1,2)";
		assertThat(subStringValue.substring(1, subStringValue.length() - 1)).isEqualTo("1,2");
	}

	@DisplayName("인덱스 이내에 문자열 값이 정상 반환되는 테스트")
	@Test
	void index_테스트_성공() {
		String indexValue = "abc";
		assertThat(indexValue.charAt(0)).isEqualTo('a');
	}

	@DisplayName("인덱스 초과 에러를 확인함")
	@Test
	void index_테스트_실패() {
		String indexValue = "abc";
		assertThatThrownBy(() -> {
			indexValue.charAt(4);
		}).isInstanceOf(IndexOutOfBoundsException.class);
	}

	@DisplayName("공백 split")
	@Test
	void split_empty() {
		String target = " ";
		String[] actual = target.split(",");
		assertThat(actual.length).isEqualTo(1);
	}

	@DisplayName("null split")
	@Test
	void split_null() {
		String target = null;
		assertThatThrownBy(() -> {
			String[] actual = target.split(",");
		}).isInstanceOf(NullPointerException.class);
	}
}
