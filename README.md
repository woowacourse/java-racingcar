# java-racingcar

자동차 경주 미션 저장소

## 우아한테크코스 코드리뷰

- [온라인 코드 리뷰 과정](https://github.com/woowacourse/woowacourse-docs/blob/master/maincourse/README.md)

## 기능 명세서

### 입력

- 자동차 이름
  - [x] "," 구분자로 구분
  - validation 호출
    - [x] 자동차 이름은 중복 불가
- 시도 횟수
  - [x] 숫자인지 아닌지
  - [x] 음수인지 아닌지

### 출력

- [x] 우승자 여러 명일 경우 , 로 구분

### 기능

- [x] 랜덤 값 뽑기
- [x] 전진 유무

### Name

- [x] Car의 이름을 포장하여 validation 처리
  - [x] 이름은 1글자 이상 5글자 이하
  - [x] 차는 1대 이상

### Car

- [x] name 문자열을 Name 클래스로 변경
- [x] Car 객체가 제대로 생성되는지 체크
  - [x] 차 이름이 1글자 미만 5글자 초과일 경우
  - [x] 차 이름이 없을 경우
