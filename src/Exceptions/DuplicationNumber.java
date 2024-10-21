package Exceptions;

public class DuplicationNumber extends RuntimeException {
    public DuplicationNumber() {
        super("조건에 맞지 않습니다 다시 입력해주세요");
    }
}
