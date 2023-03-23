import java.io.IOException;
import java.util.Scanner;
public class Main
{
    public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(System.in);
        String expression = in.nextLine();
        System.out.println(calc(expression));
    }
    public static String calc(String input)
    throws IOException {
        int arabicNumeralsA = -1;
        int arabicNumeralsB = -1;

        int romanNumeralsA = -1;
        int romanNumeralsB = -1;

        String[] expression = input.split(" ");
        if(expression.length < 3)
        {
            try
            {
                throw new IOException();
            }
            catch (IOException e)
            {
                System.out.println("строка не является математической операцией");
                System.exit(Integer.parseInt(e.getMessage()));
            }
        }
        String operator = expression[1];

        if(expression.length > 3)
        {
            try
            {
                throw new IOException();
            }
            catch (IOException e)
            {
                System.out.println("Возможно формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
                System.exit(Integer.parseInt(e.getMessage()));
            }
        }


        char operator_ = switch (operator) {
            case "+" -> '+';
            case "-" -> '-';
            case "*" -> '*';
            case "/" -> '/';
            default -> 's';
        };
        switch (expression[0]) {
            case "1" -> arabicNumeralsA = 1;
            case "2" -> arabicNumeralsA = 2;
            case "3" -> arabicNumeralsA = 3;
            case "4" -> arabicNumeralsA = 4;
            case "5" -> arabicNumeralsA = 5;
            case "6" -> arabicNumeralsA = 6;
            case "7" -> arabicNumeralsA = 7;
            case "8" -> arabicNumeralsA = 8;
            case "9" -> arabicNumeralsA = 9;
            case "10" -> arabicNumeralsA = 10;
            case "I" -> romanNumeralsA = 1;
            case "II" -> romanNumeralsA = 2;
            case "III" -> romanNumeralsA = 3;
            case "IV" -> romanNumeralsA = 4;
            case "V" -> romanNumeralsA = 5;
            case "VI" -> romanNumeralsA = 6;
            case "VII" -> romanNumeralsA = 7;
            case "VIII" -> romanNumeralsA = 8;
            case "IX" -> romanNumeralsA = 9;
            case "X" -> romanNumeralsA = 10;
            default -> {
                arabicNumeralsA = -99;
                romanNumeralsA = -99;
            }
        }
        switch (expression[2]) {
            case "1" -> arabicNumeralsB = 1;
            case "2" -> arabicNumeralsB = 2;
            case "3" -> arabicNumeralsB = 3;
            case "4" -> arabicNumeralsB = 4;
            case "5" -> arabicNumeralsB = 5;
            case "6" -> arabicNumeralsB = 6;
            case "7" -> arabicNumeralsB = 7;
            case "8" -> arabicNumeralsB = 8;
            case "9" -> arabicNumeralsB = 9;
            case "10" -> arabicNumeralsB = 10;
            case "I" -> romanNumeralsB = 1;
            case "II" -> romanNumeralsB = 2;
            case "III" -> romanNumeralsB = 3;
            case "IV" -> romanNumeralsB = 4;
            case "V" -> romanNumeralsB = 5;
            case "VI" -> romanNumeralsB = 6;
            case "VII" -> romanNumeralsB = 7;
            case "VIII" -> romanNumeralsB = 8;
            case "IX" -> romanNumeralsB = 9;
            case "X" -> romanNumeralsB = 10;
            default -> {
                arabicNumeralsB = -99;
                romanNumeralsB = -99;
            }
        }
        if( romanNumeralsA == -99 || arabicNumeralsA == -99 || romanNumeralsB == -99 || arabicNumeralsB == -99)
        {
            try
            {
                throw new IOException();
            }
            catch (IOException e)
            {
                System.out.println("Превышено значение");
                System.exit(Integer.parseInt(e.getMessage()));
            }
        }
        if(romanNumeralsB != -1 && romanNumeralsA == -1 || romanNumeralsB == -1 && romanNumeralsA != -1)
        {
           try
           {
             throw new IOException();
           }
           catch (IOException e)
           {
               System.out.println("используются одновременно разные системы счисления");
               System.exit(Integer.parseInt(e.getMessage()));
           }
        }
        if(arabicNumeralsA != -1 && arabicNumeralsB == -1 || arabicNumeralsA == -1 && arabicNumeralsB != -1)
        {
            try
            {
                throw new IOException();
            }
            catch (IOException e)
            {
                System.out.println("используются одновременно разные системы счисления");
                System.exit(Integer.parseInt(e.getMessage()));
            }

        }

        String result = "";
        int arabicResult = 0;
        int romanResult = -2;
        String arabicResultString = null;
        String romanResultString = null;
        if (arabicNumeralsA != -1 && arabicNumeralsB != -1) {
            if (operator_ == '+') {
                arabicResult = arabicNumeralsA + arabicNumeralsB;
            }
            if (operator_ == '*') {
                arabicResult = arabicNumeralsA * arabicNumeralsB;
            }
            if (operator_ == '/') {
                if (arabicNumeralsB != 0) {
                    arabicResult = arabicNumeralsA / arabicNumeralsB;
                } else {
                    try
                    {
                        throw new IOException();
                    }
                    catch (IOException e)
                    {
                        System.out.println("На ноль делить нельзя!");
                        System.exit(Integer.parseInt(e.getMessage()));
                    }
                }
            }
            if (operator_ == '-') {
                arabicResult = arabicNumeralsA - arabicNumeralsB;
            }
            arabicResultString = String.valueOf(arabicResult);
        }
        if(arabicResultString != null)
        {
            return arabicResultString;
        }

        String[] romanNumerals = new String[]
                {
                        "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV",
                        "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI",
                        "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII",
                        "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII","XLIX",
                        "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII","LXIII",
                        "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV",
                        "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV",
                        "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV",
                        "XCVI", "XCVII", "XCVIII", "XCIX", "C"

                };
        if(romanNumeralsA != -1 && romanNumeralsB != -1)
        {
            if(operator_ == '+'){romanResult = romanNumeralsB + romanNumeralsA;}
            if(operator_ == '-')
            {
                if(romanNumeralsA <= romanNumeralsB)
                {
                    try
                    {
                        throw new IOException();
                    }
                    catch (IOException e)
                    {
                        System.out.println("в римской системе нет отрицательных чисел");
                        System.exit(Integer.parseInt(e.getMessage()));
                    }
                }
                else
                {
                    romanResult = romanNumeralsA - romanNumeralsB;
                }
            }
            if(operator_ == '*'){romanResult = romanNumeralsA * romanNumeralsB;}
            if(operator_ == '/'){romanResult = romanNumeralsA / romanNumeralsB;}
        }
        String Result  = null;
        if(romanResult != -2)
        {
            Result = romanNumerals[romanResult-1];
        }
        if(Result != null)
        {
            return Result;
        }
        return result;
    }

}

