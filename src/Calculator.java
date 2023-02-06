import java.io.IOException;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Converter converter = new Converter();
        String[] operations = {" + ", " - ", " / ", " * "};
        String[] operationsForSplit = {" \\+ ", " - ", " / ", " \\* "};
        Scanner scn = new Scanner(System.in);
        System.out.print("Введите выражение: ");
        String insert = scn.nextLine();
        int operationIndex=-1;
        for (int i = 0; i < operations.length; i ++) {
            if(insert.contains(operations[i])){
                operationIndex = i;
                break;
            }
        }
        if(operationIndex == -1){
            try {
                throw new IOException();
            } catch (IOException e){
                System.out.println("Некорректное выражение");
            }
        }
        String[] data = insert.split(operationsForSplit[operationIndex]);
        if(converter.isRoman(data[0]) != converter.isRoman(data[1])){
            try {
                throw new IOException();
            } catch (IOException e){
                System.out.println("Числа должны быть в одном формате");
            }
        }
        if(converter.isRoman(data[0]) == converter.isRoman(data[1])){
            int a,b;
            boolean isRoman = converter.isRoman(data[0]);
            if(isRoman){
                a = converter.romanToInt(data[0]);
                b = converter.romanToInt(data[1]);

            }else{
                a = Integer.parseInt(data[0]);
                b = Integer.parseInt(data[1]);
            }
            int result;
            switch (operations[operationIndex]){
                case " + ":
                    result = a + b;
                    break;
                case " - ":
                    result =  a - b;
                    break;
                case " * ":
                    result = a * b;
                    break;
                default:
                    result = a / b;
                    break;
            }
            if(isRoman){
                System.out.println(converter.intToRoman(result));
            }
            else{
                System.out.println(result);
            }
        }
    }
}
