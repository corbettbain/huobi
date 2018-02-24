import java.util.Scanner;

/**
 * @author Created by hasee on 2018/2/1.
 */
public class Test3 {


    public static void main(String[] args) {
        while (true){
            String str = readString5("请输入字符串：");
            System.out.println("readString5 方法的输入：" + str);
        }
    }

    private static String readString5(String prompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(prompt);
        return scanner.nextLine();
    }
}