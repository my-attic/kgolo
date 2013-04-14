package acme.looniversity;

public class TinyToon implements Toon{
    private String name="John Doe";
    private String description="Somebody";

    private int age=0;

    public int age() { return age; }

    public void age(int age) { this.age = age; }

    public String name() { return this.name; }

    public void name(String value) { this.name = value; }

    public String description() { return this.description; }

    public void description(String value) { this.description = value; }

    public void talk(String message) {
        System.out.println(this.name + " is talking : "+ message);
    }
    public void run() {
        System.out.println(this.name + " is running");
    }
    public void scream() {
        System.out.println(this.name + " is screaming");
    }
}
