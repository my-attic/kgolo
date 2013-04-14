module main

import java.lang.String
import java.lang.StringBuilder
import org.k33g.DynamicKlass
import acme.looniversity.TinyToon


function main = |args| {

        let source = StringBuilder():
            append("public class Elmira extends acme.looniversity.TinyToon {"):
            append("    public Elmira() {}"):
            append("    public Elmira(String name) {"):
            append("        this.name(name);"):
            append("    }"):
            append("    public void blabla(String bla) {"):
            append("        System.out.println(bla);"):
            append("    }"):
            append("}")


        let Elmira = DynamicKlass():name("Elmira"):source(source:toString()):compile()

        let elmira = Elmira:loadClass():newInstance()

        elmira:name("Elmira Duff")
        elmira:description("a kid, redheaded, female human")
        elmira:talk("hello")


        let anOtherElmira = Elmira:loadClass():
                                getConstructor(String.class):
                                newInstance("Elmira Duff Clone")

        anOtherElmira:talk("hello again")

        anOtherElmira:getClass():
            getMethod("blabla",String.class):
            invoke(anOtherElmira,"bla bla bla ....")

}