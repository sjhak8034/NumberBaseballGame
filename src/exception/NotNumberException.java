package exception;

public class NotNumberException extends RuntimeException {
    public NotNumberException(String message, int a, int b) {
        super( message+ "는 잘못된 입력입니다."+ a + "~"+ b +"사이의 숫자를 다시 입력해주세요");
    }
}
