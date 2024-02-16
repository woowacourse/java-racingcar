package domain;

import java.util.List;

public record Winners(List<Car> winners) {

}

// 일급 컬렉션화하려고 이 클래스를 만든거지
// 근데 인자로 List<Car> winners가 들어가
// 레코드를 쓰면 인자의 값에 접근을 할 수가 있잖아
// 그럴거면 왜 씀?
