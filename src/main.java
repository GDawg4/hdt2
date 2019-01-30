import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Stream;
import java.util.regex.*;

public class main {
    public static void main (String[] args){
        String calculation = "";

        Scanner input = new Scanner(System.in);
        System.out.println("Ingrese el nombre del archivo de texto que contiene el mapa");
        String mapPath = input.nextLine();
        StringBuilder contentBuilder = new StringBuilder();
        try{
            Stream<String> lines = Files.lines(
                    Paths.get(mapPath),
                    StandardCharsets.UTF_8);
            lines.forEach(s ->contentBuilder.append(s));
        }catch (IOException exception){
            System.out.println("Error");
        }
        calculation = contentBuilder.toString();
        String[] onlySymbols = calculation.split(" ");

        for (String symbol: onlySymbols){
            System.out.println(symbol.getClass());
            System.out.println(symbol);
            if (symbol.matches("[1-9]")){
                System.out.println("lol");
            }
            else if (symbol.matches("[+/*-]")){
                System.out.println("yay");
            }
        }
    }
}
