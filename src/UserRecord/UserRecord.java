package UserRecord;

public interface UserRecord <T> {
    void record(T record);

    void printRecord();

    void clearRecord();
}
