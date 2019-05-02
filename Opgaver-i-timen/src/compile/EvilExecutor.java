package compile;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.charset.StandardCharsets.UTF_8;

public class EvilExecutor {


    private Path saveSource(String source) throws IOException {
        String tmpProperty = System.getProperty("user.dir");
        Path sourcePath = Paths.get(tmpProperty, "Sim.java");
        Files.write(sourcePath, source.getBytes(UTF_8));
        return sourcePath;
    }

    private Path compileSource(Path javaFile) {
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        compiler.run(null, null, null, javaFile.toFile().getAbsolutePath());
        return javaFile.getParent().resolve("Sim.class");
    }

    private void runClass(Path javaClass)
            throws MalformedURLException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        URL classUrl = javaClass.getParent().toFile().toURI().toURL();
        URLClassLoader classLoader = URLClassLoader.newInstance(new URL[]{classUrl});
        Class<?> clazz = Class.forName("Sim", true, classLoader);
        try {
            Object object = clazz.getDeclaredConstructor().newInstance();
            Object paramsObj[] = {};
            Method doit = clazz.getDeclaredMethod("doit", null);
            doit.invoke(object, null);

        }catch (NoSuchMethodException| InvocationTargetException e){

        }

    }

    public void doEvil(String source) throws Exception {
        Path javaFile = saveSource(source);
        Path classFile = compileSource(javaFile);
        System.out.println("compiled classfile " +classFile.getFileName());
        runClass(classFile);
    }

    public static void main(String... args) throws Exception {
        new EvilExecutor().doEvil( "public class Sim {\n" +
                "    public Sim() {\n" +
                "        System.out.println(\"Hello from compiler\");\n" +
                "    }\n" +
                "public void doit(){ System.out.println(\"doin it...\");}"+
                "}");
    }
}










//
//private String readCode(String sourcePath) throws FileNotFoundException {
//    InputStream stream = new FileInputStream(sourcePath);
//    String separator = System.getProperty("line.separator");
//    BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
//    return reader.lines().collect(Collectors.joining(separator));
//}
