package acme.looniversity;

public interface Toon {
    String name();
    void name(String value);
    String description();
    void description(String value);

    void talk(String message);
    void run();
    void scream();
}
