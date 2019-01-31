import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Stream;
import java.util.regex.*;

public class main {

    public static boolean isValid(String[] charachters) {
        if (charachters[0].matches("[1-9]")) {
            for (String oneLetter : charachters)
                if (oneLetter.matches("[1-9]") || oneLetter.matches("[+/*-]")) {

                } else {
                    return false;
                }
            return true;
        }
        return false;
    }

    public static boolean isNumber(String charachter){
        if (charachter.matches("[1-9]")){
            return true;
        }
        else if (charachter.matches("[+/*-]")){
            return false;
        }
        return false;
    }

    public static String[] extractText(String fileName){
        StringBuilder contentBuilder = new StringBuilder();
        try{
            Stream<String> lines = Files.lines(
                    Paths.get("test.txt"),
                    StandardCharsets.UTF_8);
            lines.forEach(s ->contentBuilder.append(s));
        }catch (IOException exception){
            System.out.println("Error");
        }
        String calculation = contentBuilder.toString();
        String[] onlySymbols = calculation.split(" ");
        System.out.println(onlySymbols);
        return onlySymbols;
    }

    public static void main (String[] args){
        Stack<String> myStack = new myList();

        Scanner input = new Scanner(System.in);
        System.out.println("Ingrese el nombre del archivo de texto que contiene el mapa");
        //String mapPath = input.nextLine();
        String[] text = extractText("test.txt");

        if (isValid(text)){
            System.out.println("Yay");
            for (String oneCharacter: text){
                myStack.push(oneCharacter);
            }
            for (String oneCharacter: text){
                System.out.println(myStack.pop());
            }
        }
        else{
            System.out.println("Se ingreso un archivo no válido");
        }
    }
}
