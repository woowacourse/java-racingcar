## 구현 기능 목록
- 자동차 이름 입력(부여) 기능
  [예외] 공백 포함 5자 이하가 아닌 경우  
  [예외] 중복된 이름이 있는 경우  
  [예외] 이름이 공백(Blank)이거나 빈 값(null)인 경우  
  [예외] 자동차 이름 개수가 2개 미만인 경우


- 시도 횟수 입력 기능  
  [예외] 자연수가 아닌 경우
    - 예시) 0, 음수, 숫자가 아닌 문자, 공백, 소수점


- 자동차 전진 기능  
  0과 9 사이 무작위 값 구한 뒤 4 이상일 경우 전진


- 자동차 전진 or 정지를 시도 횟수만큼 실행 기능
    - 시도 횟수만큼 자동차 전진
    - 시도별 실행 결과 출력
    - 시도별 실행이 누적되는지 확인


- 우승자 판단 기능
    - 우승자 목록 생성
    - 우승자 안내 문구 출력
        - 우승자가 여러명일 경우 쉼표(,)를 이용하여 구분


## step1 피드백
- [x] 파일 맨 끝에 new line 추가 -> intelliJ 설정 완료
- [x] RacingCarController 클래스의 RacingGame(과거 Cars), Round -> 불변 or 없애기
  - 분리한 메소드들의 코드 길이가 짧아서 분리하지 않고 run 메소드에 합침
  - final을 쓰지 않고 run 메서드 안에서 RacingGame와 Round를 선언함.
  - 컨트롤러 필드에 final을 사용하면서 정적팩토리 메서드를 사용할 수 있는 방법이 없을까?
- [x] import 와일드카드 수정
- [x] Car 객체 final 처리
- [x] toString 메소드 안에 너무 많은 로직이 담겨 있음.
- [x] Car 객체 안에서 출력 규칙을 알아야 할까? 
  - Cars를 RacingGame으로 이름 바꾼뒤 단순히 Car 객체를 모아둔 것이 아닌 게임을 진행한다는 의미를 담음.
  - 그리고 showTrace의 파라미터로 이름 delimiter, traceSymbol을 받고, 그 값을 RacingGame의 showAllTrace에서 넘겨주는 방식으로 수정
- [x] getter외의 메소드에 get+메서드명을 사용하지 않기
- [x] Round 객체에 의미없는 상수(ex: ZERO = 0) 지우기
- [x] 에러메세지 상수와 변수 사이에 공백 추가
- [x] 에러메세지를 상수화 해야할까?
    - 할 필요 없다. 에러메세지는 굳이 enum으로 같이 관리할 필요 없이 바로 throw로 에러 메세지를 던지는게 나을 것 같다.
    - 에러메세지에 자주 사용되는 ex) `[ERROR]` 문자열은 상수화 해야할까?
    - 에러메세지는 여러 클래스에서 사용되는데 그러면 클래스마다 상수화하는 방식으로 `[ERROR]`를 표현할까,
    - 아니면 에러메세지 `[ERROR] 에러내용`을 그대로 작성하는게 좋을까?
    - 일단 OutputView에 public으로 `ERROR_PREFIX = "[ERROR] "`상수화 한 뒤 다른 클래스에서 가져다 쓰는 방식으로 수정.
- [x] Car 클래스 moveForward 메소드의 randomNumber 파라미터이름 수정(처음 보는 사람은 왜 randomNumber가 들어오는지 이해못한다.)


## step2 피드백
- [x] Cars 객체를 RacingGame 으로 이름을 바꾸어주셨는데, CarsTest 이름도 거기에 맞게 함께 바꾸어주면 좋을 것 같아요
- [x] Car 객체의 showTrace 메서드를 보면 파라미터를 더 이상 사용하지 않아요
  더불어 RacingGame 과 Car 에 중복되는 상수가 있는데, 명확하게 한 쪽에서만 쓰도록 하면 좋겠네요!
  - Car의 showTrace 메소드 삭제 후 RacingGame에서만 출력 형식 맞춰서 반환할 수 있게 수정
- [x] 자바 11 버전부터 String 에 repeat() 메서드가 추가되었어요.
  for 문을 사용하여 StringBuilder 에 append 할 수도 있지만, 이 repeat() 메서드로 조금 더 간결하게 반복 로직을 구현할 수도 있습니다! step 2 에서 한 번 반영해보세요 :)
- [x] Car 쪽 필드 보면 상수와 변수 사이 공백이 원래 있었는데, 다시 없애셨네요.
  다른 클래스에서는 공백을 추가하셨는데, 여기는 제거한 이유가 있을까요?
- [x] 상수, 클래스 변수, 인스턴스 변수, 생성자, 메서드 순으로 작성한다.
- [x] 생성자 파라미터, 객체 변수에 final 붙이기
  - [x] 테스트 코드에서도 변수 선언할때 final 사용
- [x] checkIsNumber() -> 명확하게 수정
- [x] Application에서 Controller 객체 만들지 말고 new로 생성만 하기
- [x] 개행 문자 System.lineSeparator()로 통일
- [x] 랜덤 생성 메서드 코드 의미 명확하게 수정
- [x] Round 객체 삭제 후 시도 횟수 변수를 RacingGame 필드로 이동
- [x] OutputView [ERROR] 상수화 취소 
- [x] 모든 출력 조건은 view로 이동
- [x] stream으로 수정


## step2 피드백(2)
- [x] BufferedReader 필드에서 삭제 후 메소드 안에서 선언
- [x] 에러 메세지 속의 매직넘버 상수화
- [x] CscSource의 테스트 예시도 순서대로 작성
- [x] shift + F6 를 누른 뒤 엔터 누르면 한꺼번에 변경 가능!
- [x] .collect(Collectors.toList()) -> toList로 변경(불변객체 반환)
- [x] 객체 리스트 반환하는 getter 메소드는 반환 리스트를 불변으로 수정
  - https://tecoble.techcourse.co.kr/post/2020-05-08-First-Class-Collection/
- [x] getter는 클래스 맨 아래로 
- [x] CarInfoDto -> CarDto로 의미 명확하게 수정
- [x] CarsTest에 우승자 테스트
- [x] 테스트코드 예외 thrownBy만 하지말고 .isInstanceOf로 에러까지 명시하기
- [x] OutputView의 stream 부분에서 forEach 찾아보기
  - ❓로직 가독성 개선 -> 다시 for문으로 바꿨는데 잘 모르겠다... 
- ❓Cars calculateMaxPosition 람다 사용해서 수정

