# 🚀 미션 - 자동차 경주 구현

# 📈 기능 목록

## 입력

- [X]  경주 할 자동차의 이름을 입력받는다.
- [X]  이름을 쉼표 기준으로 분리한다.
- [X]  사용자가 잘못된 값을 입력할 경우 Exception를 발생시키고 프로그램을 종료한다.
   - [X]  빈 문자열(null)이 입력된 경우
   - [X]  이름이 5자 보다 클 경우
   - [X]  이름이 중복된 경우
   - [X]  입력된 이름이 하나일 경우
   - [X]  공백(들) 혹은 ','로만 이루어진 문자열이 입력된 경우
   - [X]  이름에 특수문자가 들어간 경우 (다만, '_' 제외)
- [X]  시도할 횟수를 입력받는다.
- [X]  사용자가 잘못된 값을 입력할 경우 Exception를 발생시키고 프로그램을 종료한다.
   - [X]  빈 문자열(null)이 입력된 경우
   - [X]  숫자가 아닐 경우
   - [X]  0 이하의 값이 입력된 경우

## 경기진행

- [X]  입력 받은 횟수만큼 라운드을 반복한다.
- [X]  각 자동차마다
   - [X]  0~9 사이의 랜덤 값을 구한다.
   - [X]  4 이상인 경우 전진한다.
- [X]  각 라운드마다 결과를 출력한다.

## 경기종료

- [X]  게임이 끝난 후 가장 많이 전진한 위치를 구한다.
- [X]  최대 위치 값에 해당하는 우승한 자동차 목록을 구한다.
- [X]  우승자(들)를 출력한다.

---

# TODO

- [x]  퍼블릭 메소드 별로 테스트 코드 작성
- [x]  리뷰어 피드백 적용(밑에 줄줄 쓰며 투두 해결)
- 2단계 2차 피드백
   - [x]  inputView에서도 Dto를 이용해 데이터 리턴
   - [x]  carDto를 List 형태로 전달하는 것이 아닌 List를 가진 Dto를 반환
   - [ ]  Comparable을 이용해 getMaxPosition() 생성
   - [ ]  정적 팩토리 메소드를 이용해 dto에서 car를 받아서 직접 자기 자신을 생성하도록 하기
- 2단계 1차 피드백
   - [x]  equals() 메소드에 원시값 비교 제거
   - [x]  getter 내부적으로 필요한 값을 바로 return해 체이닝을 줄임
   - [x]  OutputView에 List<carDTO> 전달하도록 수정
   - [x]  service 패키지 제거(지금은 MVC 기본 모델에 집중)
   - [x]  exception, utils 패키지 위치 이동
   - [x]  Dto 인스턴스변수 접근제어자 private로 변경
   - [x]  InputValidator를 Utils 패키지로 이동
   - [x]  domain 패키지 내에 dto 패키지를 만들어 carDto를 분리
   - [x]  test 속 system.out.println 제거
   - [x]  테스트 속 조건문/while문을 제거

- 1단계 피드백
   - [x]  주요 로직 메서드는 getter보다 위에 있는게 좋은거 같아요
   - [x]  HashSet으로 size비교를 했는데 의도한대로 동작을 할까요??
   - [x]  (vo) equals, hashCode 사용
   - [x]  Random을 항상 새로 호출해야할까요?? -> x
   - [x]  변수 접근제어자 private로 변경
   - [x]  DTO 적용
   - [x]  model이 view로 넘어와도 될까요?? -> Dto 클래스를 통해 값 변경 제한
   - [x]  테스트 메서드 의미 알려주는게 명확 -> 한글 변수명으로 이동, warning~ 태그 추가
   - [x]  가장 중요한 go에 대한 테스트가 없는거 같아요.
   - [x]  RacingCars 테스트 작성
   - [x]  컨트롤러 속 service를 domain 패키지 안으로 이동
   - [x]  extracting 적용, 일급컬렉션 equals() 문자/숫자 비교 편하게 수정
   - [x]  메서드 시그니처 분리 : https://tecoble.techcourse.co.kr/post/2020-05-07-appropriate_method_for_test_by_parameter/
   - [x]  인터페이스 분리 : https://tecoble.techcourse.co.kr/post/2020-05-17-appropriate_method_for_test_by_interface/
   - [x]  view와 domain 사이 연결 끊기
      - [x]  view 메소드들의 인수를 string/int 리스트/맵 형태로 가져오기

---

# 🚀 미션 - TDD 문자열 덧셈 계산기

# 📈 기능 목록

- [X]  구분자를 기준으로 구분한다

- 쉼표(,), 콜론(:)
  - 커스텀 구분자("//","\n") -> 사이에 문자 하나 옴

- [X]  파라미터가 숫자 이외의 값, 음수이면 예외처리

- [예외] 숫자아님
- [예외] 구분자 앞뒤에 아무것도 없을 때
- [예외] 숫자가 음수
- RuntimeException

- [X]  파라미터들을 더한 값을 리턴한다
- [X]  [요구사항] 빈 문자열 또는 null이 입력된 경우 0을 출력

---

# TODO

- [X]  예외처리 테스트코드 작성
