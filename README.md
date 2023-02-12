# java-racingcar

자동차 경주 미션 저장소

## 기능요구사항

- [✅] 각 자동차 이름 입력받기
  - 쉽표를 기준으로 분리
  - 5자 이하
  - 빈문자열 금지

- [✅] 시도할 횟수 입력받기
  - digit 형식 확인
  - 양의 정수 확인 

- [✅] 자동차 전진하기
  - 0에서 9 사이의 random 값 구하기
  - 4이상일 경우에만 전진

- [✅] 우승자 판단
  - 최대 이동 거리 구하기 (1 loop)
  - 최대 이동거리과 동일한 거리를 갖는 차의 이름을 우승자 배열에 넣기 (1 loop)

- 요구사항 확인
  - [✅] 한 메서드에 오직 한 단계의 들여쓰기(indent)만
  - [✅] else 예약어를 쓰지 않는다.
  - [✅] 함수(또는 메소드)의 길이가 15라인을 넘어가지 않도록 구현
  - [✅] 모든 로직에 단위 테스트
  - [✅] 자바 코드 컨벤션
  - [🤷‍️] 함수(또는 메소드)가 한 가지 일만 잘 하도록 구현

## 피드백 요구사항

- [ ] 예외사항 구체화하기
- [x] 객체 관리 제거하기
  - 객체는 변경될 가능성이 높기 때문
- [x] 접근 제어자 사용하기
- [ ] toString의 역할에 대해 고민해보기
- [x] move 메서드의 random 사용시 테스트에 대해 고민해보기
- [x] 자바 컨벤션 지키기
- [ ] Validation에 대해 고민해보기
- [ ] `@DisplayName`에 대해 고민해보기
- [x] 테스트 깨짐 수정하기

## 우아한테크코스 코드리뷰

- [온라인 코드 리뷰 과정](https://github.com/woowacourse/woowacourse-docs/blob/master/maincourse/README.md)
