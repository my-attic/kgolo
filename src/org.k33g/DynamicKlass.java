package org.k33g;

/*
    Inspiration :
    http://www.javablogging.com/dynamic-in-memory-compilation/
 */

import javax.tools.JavaCompiler;
import javax.tools.JavaFileManager;
import javax.tools.JavaFileObject;
import javax.tools.ToolProvider;
import java.util.ArrayList;
import java.util.List;

public class DynamicKlass {
    private String sourceCode = null;

    // Full name of the class that will be compiled.
    // If class should be in some package,
    // fullName should contain it too
    // (ex. "testpackage.DynaClass")
    private String fullName = null;
    private JavaFileManager fileManager = null;

    public DynamicKlass source(String src) {
        this.sourceCode = src;
        return this;
    }

    public DynamicKlass name(String name) {
        this.fullName = name;
        return this;
    }

    public DynamicKlass compile() {
        // We get an instance of JavaCompiler. Then
        // we create a file manager
        // (our custom implementation of it)
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        this.fileManager = new ClassFileManager(compiler.getStandardFileManager(null, null, null));

        // Dynamic compiling requires specifying
        // a list of "files" to compile. In our case
        // this is a list containing one "file" which is in our case
        // our own implementation (see details below)
        List<JavaFileObject> jfiles = new ArrayList<JavaFileObject>();
        jfiles.add(new CharSequenceJavaFileObject(fullName, this.sourceCode));

        // We specify a task to the compiler. Compiler should use our file
        // manager and our list of "files".
        // Then we run the compilation with call()
        compiler.getTask(null, this.fileManager, null, null, null, jfiles).call();

        return this;
    }

    public Class<?> loadClass() throws ClassNotFoundException {
        return this.fileManager.getClassLoader(null).loadClass(this.fullName);
    }

    public DynamicKlass(String fullName) {
        this.fullName = fullName;
    }

    public DynamicKlass() {
    }
}
