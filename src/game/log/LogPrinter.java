package game.log;

public interface LogPrinter<T>{
    void append(T t);

    void printScore();

    void printLevel();

    void printTime();

    void printAnswer();

    // 게임 기록을 출력을 위한 메소드
    void printSuccessLog(int NumberOfGame);

    void printReplay(int NumberOfGame);

    void printGameHeader(int numberOfGame);
}
