import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter size of matrix:");
        int size= sc.nextInt();
        SnakeGame sG=new SnakeGame(size);
        sG.playGame(size);
    }
}