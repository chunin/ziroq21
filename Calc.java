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

        String[] num = input.split(operstr);
        if (num.length>2){
            System.out.println("Должно быть два значения");
            System.exit(0);
        }
        if (num.length<2){
            System.out.println("Должно быть два значения");
            System.exit(0);
        }
        int a = 0;
        int b = 0;
        int arab = 0;
        String rom = "";





            try {
                if (Character.isDigit(arab)==true || arab!=0){
                    System.out.println("Римские или арабские целые числа");
                }
                else {
                    a = roman_arab(num[0]);
                    b = roman_arab(num[1]);
                    arab = calc(a, b, oper);
                    rom = roman_arab(arab);
                    System.out.println(rom);
                    System.exit(0);
                }

                a = Integer.parseInt(num[0]);
                b = Integer.parseInt(num[1]);
                if (a>10 | b>10 | a<1 | b<1){
                    System.out.println("Числа от 1 до 10");
                    System.exit(0);
                }
                if (Character.isDigit(arab)==false){
                    arab = calc(a, b, oper);
                    System.out.println(arab);
                }
            } catch (NumberFormatException e){
                System.out.println("Только целые числа");
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
        }
        return result;
    }
    public static String roman_arab(int num) {
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