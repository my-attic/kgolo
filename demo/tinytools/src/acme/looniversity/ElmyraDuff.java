package acme.looniversity;


public class ElmyraDuff extends TinyToon {
    private static ElmyraDuff theOnlyOne;

    private ElmyraDuff() {
        this.name("Elmyra Duff");
        this.description("a kid, redheaded, female human");
    }

    public static ElmyraDuff getInstance() {
        if(ElmyraDuff.theOnlyOne == null) {
            ElmyraDuff.theOnlyOne = new ElmyraDuff();
        }
        return ElmyraDuff.theOnlyOne;
    }

    public void isChasing(Toon toon){
        String myString = String.format("Help ! I'm %s : %s, i'm chased by Elmira :(",toon.name(),toon.description());
        System.out.println(myString);
    }
}
