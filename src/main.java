import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Stream;
import java.util.regex.*;

public class main {

    /**
     * Método
     * @param charachters
     * @return
     */
    public static boolean isValid(String[] charachters) {
        int amountOfInt = 0;
        int amountOfSymbols = 0;
        if (charachters[0].matches("[0-9]") && charachters[1].matches("[0-9]")) {
            for (String oneLetter : charachters)
                if (oneLetter.matches("[0-9]")) {
                    amountOfInt ++;
                } else if(oneLetter.matches("[+/*-]")) {
                amountOfSymbols ++;
                }
                else {
                    return false;
                }
            if (amountOfInt - 1 == amountOfSymbols){
                return true;
            }
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
        return onlySymbols;
    }

    public static void main (String[] args){
        Stack<String> myStack = new myList();
        iCalculadora myCalculator = new calculadora();

        Scanner input = new Scanner(System.in);
        System.out.println("Ingrese el nombre del archivo de texto que contiene el mapa");
        System.out.println("Por favor incluya .txt al final de su archivo");
        String mapPath = input.nextLine();
        String[] text = extractText(mapPath);

        if (isValid(text)){
            for (String oneCharacter: text){
                if (isNumber(oneCharacter)) {
                    myStack.push(oneCharacter);
                }else {
                    if (myStack.size() > 1 ) {
                        switch (oneCharacter) {
                            case "+":
                                double resultSum = myCalculator.sumar(Double.parseDouble(myStack.pop()), Double.parseDouble(myStack.pop()));
                                myStack.push(String.valueOf(resultSum));
                                break;

                            case "-":
                                double resultMinus = myCalculator.restar(Double.parseDouble(myStack.pop()), Double.parseDouble(myStack.pop()));
                                myStack.push(String.valueOf(resultMinus));
                                break;

                            case "*":
                                double resultMultiplication = myCalculator.multiplicar(Double.parseDouble(myStack.pop()), Double.parseDouble(myStack.pop()));
                                myStack.push(String.valueOf(resultMultiplication));
                                break;

                            case "/":
                                double resultDivision = myCalculator.dividir(Double.parseDouble(myStack.pop()), Double.parseDouble(myStack.pop()));
                                myStack.push(String.valueOf(resultDivision));
                                break;
                        }
                    }else {
                        System.out.println("El archivo que subió no se puede procesar completamente");
                        System.out.println("No hay suficientes números para seguir calculando");
                        System.out.println("Este es el último resultado");
                        System.out.println(myStack.pop());
                    }
                    }
                }
            System.out.println("Resultado final");
            System.out.println(myStack.pop());
            }
        else {
            System.out.println("Se ingresó un archivo no válido");
        }
    }
}
