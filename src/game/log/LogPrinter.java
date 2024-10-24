package game.log;

public interface LogPrinter<T>{
    void append(T t);
    void printScore();
}
