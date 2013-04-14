package acme.looniversity;

public class BusterBunny extends TinyToon {

    private static BusterBunny theOnlyOne;

    private BusterBunny() {
        this.name("Buster Bunny");
        this.description("a blue male rabbit");
    }

    public static BusterBunny getInstance() {
        if(BusterBunny.theOnlyOne == null) {
            BusterBunny.theOnlyOne = new BusterBunny();
        }
        return BusterBunny.theOnlyOne;
    }
}
