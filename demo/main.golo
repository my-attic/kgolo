module main

import java.lang.String
import org.k33g.DynamicKlass
import acme.looniversity.TinyToon


function main = |args| {

    let Elmira = DynamicKlass(): name("Elmira"): source("""

        public class Elmira extends acme.looniversity.TinyToon {
            public Elmira() {}
            public Elmira(String name) {
                this.name(name);
            }
            public void blabla(String bla) {
                System.out.println("blabla : " + bla);
            }
        }

    """): compile()

    let elmira = Elmira: loadClass(): newInstance()

    elmira: name("Elmira Duff")
    elmira: description("a kid, redheaded, female human")
    elmira: talk("hello")
    elmira: blabla("hello world")

    let anOtherElmira = Elmira: loadClass(): getConstructor(String.class): newInstance("Elmira Duff Clone")

    anOtherElmira: talk("hello again")

    # anOtherElmira:getClass(): getMethod("blabla",String.class): invoke(anOtherElmira,"bla bla bla ....")

    anOtherElmira: blabla("bla bla bla ....")

}
