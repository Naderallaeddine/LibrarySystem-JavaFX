package utils;

public interface subject {
    void attach(observer observer);
    void detach(observer observer);
    void notifyObservers(String message);
}