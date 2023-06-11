/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package analizador;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author manny
 */
public class main {
    public static void main(String[] args) throws Exception {
        String ruta = System.getProperty("user.dir")+"/src/analizador/lex.flex";
        String rutaSin = System.getProperty("user.dir")+"/src/analizador/LexerCup.flex";
        String[] rutaS = {"-parser","Sintax",System.getProperty("user.dir")+"/src/analizador/Sintax.cup"};
        generar(ruta,rutaSin,rutaS);
        System.out.print(ruta);
    }
    public static void generar(String ruta, String rutaSin, String[] rutaS) throws IOException, Exception{
        File file;
        file = new File(ruta);
        JFlex.Main.generate(file);
        file = new File(rutaSin);
        JFlex.Main.generate(file);
        java_cup.Main.main(rutaS);
        
        String rutaSy = System.getProperty("user.dir")+"/src/analizador/sym.java";
        Path rutaSym = Paths.get(rutaSy);
        if(Files.exists(rutaSym)){
            Files.delete(rutaSym);
        }
        Files.move(
                Paths.get(System.getProperty("user.dir")+"/sym.java"), 
                Paths.get(System.getProperty("user.dir")+"/src/analizador/sym.java")
        );
        String rutaSi = System.getProperty("user.dir")+"/src/analizador/Sintax.java";
        Path rutaSint = Paths.get(rutaSi);
        if(Files.exists(rutaSint)){
            Files.delete(rutaSint);
        }
        Files.move(
                Paths.get(System.getProperty("user.dir")+"/Sintax.java"), 
                Paths.get(System.getProperty("user.dir")+"/src/analizador/Sintax.java")
        );
    }
}
