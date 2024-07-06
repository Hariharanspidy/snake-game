import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;


public class SnakeGame {
    char[][] box=new char[5][5];
    Queue<int[]> queue=new LinkedList<>() ;
    Random random=new Random();
    private int snakeLength=1;
    public SnakeGame(int n){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                box[i][j]='o';
            }
        }
    }
    public void printbox(int n){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(box[i][j]+" ");
            }
            System.out.println();
        }
    }
    public void foodAvailable(int n){
        int c=0;
        for(int r=0;r<=n;r++){
            for(int co=0;co<=n;co++){
                if(box[r][co]=='.'){
                    ++c;
                }
            }
        }
        if(snakeLength<c){
            int r1=random.nextInt(n-0+1)+0;
            int r2=random.nextInt(n-0+1)+0;
            box[r1][r2]='x';
            snakeLength=c;
        }
    }
    public void playGame(int n){
        Scanner sc=new Scanner(System.in);
        int i=0,j=0;
        box[i][j]='.';
        box[0][1]='x';
        int[] t={i,j};
        queue.add(t);
        while(true){
            foodAvailable(n-1);
            printbox(n);
            System.out.println("Enter direction:");
            char input=sc.next().charAt(0);
            switch (input){
                case 'U':
                    moveSnake(--i,j);
                    break;
                case 'D':moveSnake(++i,j);
                    break;
                case 'R':moveSnake(i,++j);
                    break;
                case 'L':moveSnake(i,--j);
                    break;
            }

        }
    }
    public void moveSnake(int row,int col){
        int[] t={row,col};
        int rows= queue.element()[0];
        int cols= queue.element()[1];
        if(row<0 || col<0){
            System.out.println("Game Over");
            System.exit(0);
        }
        else if(box[row][col]=='x'){
            box[row][col]='.';
            queue.add(t);
        }
        else if(box[row][col]=='o'){
            box[row][col]='.';
            queue.add(t);
            box[rows][cols]='o';
            queue.poll();
        }
        else if(box[row][col]=='.'){
            System.out.println("Game over");
            System.exit(0);
        }


    }
}
