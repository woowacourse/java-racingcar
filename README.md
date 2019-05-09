# 문자열 계산기
1. 문자열 입력받기
2. 문자열 나누기
3. 부분 계산 하기
4. 전체 계산하기
5. 계산결과 출력하기


# java-racingcar 기능 구현 목록

### View에 필요한 메소드

- InputView
   - 사용자로부터 자동차 목록 입력받아 컨트롤러에 전달
   - 사용자로부터 시도할 횟수를 입력받아 컨트롤러에 전달
- OutputView
   - 컨트롤러로 부터 받은 이름과 위치 출력
   - 컨트롤러로 부터 받은 우승자 이름 목록 출력

### Controller에 필요한 메소드

- InputView에 자동차 목록 요청하기
- 자동차 목록 콤마 기준으로 나누기
- 나뉘어진 자동차 목록(String[])으로 자동차 객체 생성 요청
- InputView에 시도할 횟수를 요청
- 레이싱 게임 진행(모든 Car 객체에 대해 아래 메소드 반복 호출)
   - 1~9사이의 난수를 생성하여 4이상인지 판단하여 Car객체에 이동 요청
   - Car객체로 부터 이름과 현재 위치 가져와서 OutputView에 출력 요청
- 우승자 판단해서 OutputView에 출력 요청

### Model에 필요한 메소드

- 컨트롤러로부터 받은 자동차 목록(String[])으로 자동차 객체 리스트(List<Car> carList) 생성하기
- Car객체의 position 1증가시키기
- Car객체의 현재 position을 컨트롤러에 넘겨주기
- Car객체의 이름을 컨트롤러에 넘겨주기

## 우아한테크코스 코드리뷰
* [온라인 코드 리뷰 과정](https://github.com/woowacourse/woowacourse-docs/blob/master/maincourse/README.md)
