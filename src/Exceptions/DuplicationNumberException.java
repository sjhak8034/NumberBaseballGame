package Exceptions;

public class DuplicationNumberException extends RuntimeException {
    public DuplicationNumberException() {
        super("조건에 맞지 않습니다 다시 입력해주세요");
    }
}
