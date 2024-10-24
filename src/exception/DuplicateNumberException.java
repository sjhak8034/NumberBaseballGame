package exception;

public class DuplicateNumberException extends RuntimeException {
    public DuplicateNumberException() {
        super("조건에 맞지 않습니다 다시 입력해주세요");
    }
}
