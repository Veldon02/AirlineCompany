package AirplaneManagement.Program;

import java.util.List;
import java.util.Scanner;

public class SafeScanner {
    private static final Scanner scanner = new Scanner(System.in);

    public static int scanInt(int num){
        int res;
        while(true){
            try{
                res = Integer.parseInt(scanner.nextLine());
                if (res >= num) break;
                System.out.println("invalid input!");
            }catch(Exception e){
                System.out.println("invalid input!");
            }
        }
        return res;
    }

    public static int scanInt(int num1,int num2){
        int res;
        while(true){
            try{
                res = Integer.parseInt(scanner.nextLine());
                if (num1<=res && res<=num2) break;
                System.out.println("invalid input!");
            }catch(Exception e){
                System.out.println("invalid input!");
            }
        }
        return res;
    }

    public static int scanInt(List<Integer> list){
        int res;
        while(true){
            try{
                res = Integer.parseInt(scanner.nextLine());
                if (list.contains(res)) break;
                System.out.println("invalid input!");
            }catch(Exception e){
                System.out.println("invalid input!");
            }
        }
        return res;
    }

    public static String scanString() {
        return scanner.nextLine();
    }

    public static String scanString(int maxLength) {
        String res;
        while(true){
            res = scanner.nextLine();
            if (res.length()<=maxLength) break;
            System.out.println("string is too long!");
        }
        return res;
    }
}
