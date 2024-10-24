package data;

public interface Data<T> {
    void save(T record);

    void printData();

    void printReplay();

}
