package org.k33g;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;


public class Main {

    public static void main(String args[]) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {


        // Here we specify the source code of the class to be compiled
        StringBuilder src = new StringBuilder();
        src.append("public class DynaClass {\n");
        src.append("    public DynaClass() {\n");
        src.append("\n");
        src.append("    }\n");
        src.append("    public DynaClass(String m) {\n");
        src.append("System.out.println(m);\n");
        src.append("    }\n");
        src.append("    public String toString() {\n");
        src.append("        return \"Hello, I am \" + ");
        src.append("this.getClass().getSimpleName();\n");
        src.append("    }\n");
        src.append("    public String msg(String message) {\n");
        src.append("        return \"Hello, I am \" + ");
        src.append("message;\n");
        src.append("    }\n");
        src.append("}\n");

        System.out.println(src);

        DynamicKlass dinok = new DynamicKlass().name("DynaClass").source(src.toString()).compile();

        Object o = dinok.loadClass().newInstance();
        Object oo = dinok.loadClass().getConstructor(String.class).newInstance("Hello world");

        System.out.println(o.getClass().getMethod("msg", String.class).invoke(o, "Salut"));


        System.out.println(o);
    }
}
