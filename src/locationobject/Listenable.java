package locationobject;

public interface Listenable {
    void addListener(Listener listener);
    void removeListener(Listener listener);
    void notifyListeners(Character character) throws InterruptedException;
}
