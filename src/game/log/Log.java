package game.log;

public interface Log <T>{
    public void append(T t);
    public void printScore();
}