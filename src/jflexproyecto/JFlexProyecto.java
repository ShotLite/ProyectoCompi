package jflexproyecto;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
public class JFlexProyecto {
     public static void main(String[] args) throws Exception {
       System.out.println("Generando Archivos Lexers");
        try{
           generar();
        }catch(Exception e){
           throw new Exception("Error al generar Archivo Lexer");
       }
     }
    public static void generar() throws IOException, Exception{
        String rutaProy = "C:\\Users\\52981\\Documents\\NetBeansProjects\\jFlexProyecto";
        String[] ruta1 = {rutaProy+"\\src\\jflexproyecto\\lex.flex"};
        String[] ruta2 = {rutaProy+"\\src\\jflexproyecto\\LexerCup.flex"};
        String[] rutaS = {"-parser", "Sintax", rutaProy+"\\src\\jflexproyecto\\Sintax.cup"};
        jflex.Main.generate(ruta1);       
        jflex.Main.generate(ruta2);
        java_cup.Main.main(rutaS);
        Path rutaSym = Paths.get(rutaProy+"/src/jflexproyecto/sym.java");
        if (Files.exists(rutaSym)) {
            Files.delete(rutaSym);
        }
        Files.move(
                Paths.get(rutaProy+"/sym.java"), 
                Paths.get(rutaProy+"/src/jflexproyecto/sym.java")
        );
        Path rutaSin = Paths.get(rutaProy+"/src/jflexproyecto/Sintax.java");
        if (Files.exists(rutaSin)) {
            Files.delete(rutaSin);
        }
        Files.move(
                Paths.get(rutaProy+"/Sintax.java"), 
                Paths.get(rutaProy+"/src/jflexproyecto/Sintax.java")
        );
    }
}
