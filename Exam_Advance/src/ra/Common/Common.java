package ra.Common;

import java.util.Scanner;

public class Common {
    public static int getInputInt(int number,String string){
        Scanner scanner = new Scanner(System.in);
        while (true){
            try {
                System.out.println(string);
               number = Integer.parseInt(scanner.nextLine().trim());
               if(number >= 0){
                   break;
               }else {
                   System.err.println("Enter number > 0 !");
               }
            }catch (Exception e){
                System.err.println("Number invalid !");
            }
        }
        return number ;
    }


}
