import java.util.Scanner;


public class Calc {
    public static void main(String[] args){

        Scanner str = new Scanner(System.in);
        String input = str.nextLine();
        char[] operand = new char[20];
        char oper='+';
        String operstr="";


        for (int i=0; i<input.length(); i++){
            operand[i] = input.charAt(i);
            if (operand[i]== '+'){
                oper='+';
                operstr="\\+";
            }
            if (operand[i]=='-'){
                oper='-';
                operstr="-";
            }
            if (operand[i]=='/'){
                oper='/';
                operstr="/";
            }
            if (operand[i]=='*'){
                oper='*';
                operstr="\\*";
            }

        }
        if (operstr==""){
            System.out.println("Нету знака");
            System.exit(0);
        }



        String[] num = input.split(operstr);
        if (num.length!=2){
            System.out.println("Должно быть два значения");
            System.exit(0);
        }
        int a = 0;
        int b = 0;
        int arab = 0;
        String rom = "";
        int result = 0;
        int resultArab = 0;

        a = roman_arab(num[0]);
        b = roman_arab(num[1]);


        if (a==0 && b!=0){
            System.out.println("Только римские или арабские цифры");
            System.exit(0);
        }
        else if (a!=0 && b==0){
            System.out.println("Только римские или арабские цифры");
            System.exit(0);
        }
        else if (a == 0 && b == 0) {
            boolean isOnlyDigits = true;
            for(int i = 0; i < num[0].length() && isOnlyDigits; i++) {
                if(!Character.isDigit(num[0].charAt(i))) {
                    isOnlyDigits = false;
                }
            }
            boolean isOnlyDigits1 = true;
            for(int i = 0; i < num[1].length() && isOnlyDigits1; i++) {
                if(!Character.isDigit(num[1].charAt(i))) {
                    isOnlyDigits1 = false;
                }
            }

            if (isOnlyDigits==true & isOnlyDigits1==true){
                a = Integer.parseInt(num[0]);
                b = Integer.parseInt(num[1]);
                if (a > 10 | b > 10 | a < 1 | b <1) {
                    System.out.println("Цифры от 1 до 10");
                    System.exit(0);
                }
                resultArab = calc(a, b, oper);
                System.out.println(resultArab);
            }
            else{
                System.out.println("Только римские или арабские цифры от 1 до 10");
                System.exit(0);
            }
            }
        else {
                result = calc(a, b, oper);
                if (result <= 0) {
                    System.out.println("Римские цифры только положительные");
                    System.exit(0);
                }
                String resultRom = arab_roman(result);
                System.out.println(resultRom);
        }
    }
    public static int calc(int a, int b, char oper){
        int result = 0;
        switch (oper){
            case '+':
                result = a+b;
                break;
            case '-':
                result = a-b;
                break;
            case '*':
                result = a*b;
                break;
            case '/':
                result = a/b;
                break;
        }
        return result;
    }
    public static int roman_arab(String rome ){
        int result = 0;
        switch (rome){
            case "I":
                result = 1;
                break;
            case "II":
                result = 2;
                break;
            case "III":
                result = 3;
                break;
            case "IV":
                result = 4;
                break;
            case "V":
                result = 5;
                break;
            case "VI":
                result = 6;
                break;
            case "VII":
                result = 7;
                break;
            case "VIII":
                result = 8;
                break;
            case "IX":
                result = 9;
                break;
            case "X":
                result = 10;
                break;
            default:
                result = 0;

        }
        return result;
    }
    public static String arab_roman(int num) {
        int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] romanLiterals = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        StringBuilder roman = new StringBuilder();
        for(int i=0;i<values.length;i++) {
            while(num >= values[i]) {
                num -= values[i];
                roman.append(romanLiterals[i]);
            }
        }
        return roman.toString();
    }
}
