import java.util.*;

public class MineSweeper {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        Character[][] gameboard = new Character[n+2][n+2];
        for (int i=0; i<n; i++){
            String content = input.next();
            for (int j=0; j<n; j++){
                gameboard[i+1][j+1] = content.charAt(j);
            }
        }
        int x = input.nextInt();
        int y = input.nextInt();
        if (gameboard[x+1][y+1]=='x'){
            System.out.println(-1);
        }
        else {
            int counter = 0;
            for(int i=-1; i<=1; i++){
                for(int j=-1; j<=1; j++){
                    if (gameboard[x+1+i][y+1+j]!=null && gameboard[x+1+i][y+1+j]=='x'){
                        counter++;
                    }
                }
            }
            System.out.println(counter);
        }
    }
}
