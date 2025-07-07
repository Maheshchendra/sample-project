import java.util.*;
class tictactoe{
public static void main(String args[]){
//create a char type 3*3 matrixs and each filled with empty space
char[][] board=new char[3][3];
for(int r=0;r<board.length;r++){
    for(int c=0;c<board[r].length;c++){
        board[r][c]=' ';
    }
}
//assign player like 'X' and '0'
char player='x';
boolean gameover=false;
//read the user input r and c
Scanner sc=new Scanner(System.in);
while(!gameover){
    printBoard(board);
    System.out.print("player "+ player +" enter:");
    int r=sc.nextInt();
    int c=sc.nextInt();
    System.out.println();
    //enter the player to there signatures like "x" and "0"
    if(board[r][c]==' '){
        board[r][c]=player;
        gameover=havewon(board, player);
        if(gameover){
         System.out.println("player "+ player +" has won");
         }else{
           player=(player=='x')? '0':'x';
         }
        } 
     else{
     System.out.println("Invalid move.try again");
     }
    }
    printBoard(board);
}

public static boolean havewon(char[][] board, char player){
    //row staticfied condition 00 01 02 and 10 11 12 and 20 21 22
 for(int r=0;r<board.length;r++){
    if(board[r][0]==player && board[r][1]==player && board[r][2]==player){
        return true;
    }
   }
   //like the colomn also
   for(int c=0;c<board.length;c++){
    if(board[0][c]==player && board[1][c]==player && board[2][c]==player){
        return true;
    }
   }
   //diagonal
   if(board[0][0]==player && board[1][1]==player && board[2][2]==player){
    return true;
   }
   //and opposite diagonal
   if(board[0][2]==player && board[1][1]==player && board[2][0]==player){
    return true;
   }
  //if above all conditions are fail it return false
   return false;

}
  public static void printBoard(char[][]board){
    //*first it display the complete board structure in with seperation of "|" 
   for(int r=0;r<board.length;r++){
    for(int c=0;c<board[r].length;c++){
        System.out.print(board[r][c]+"|");
    }
    System.out.println();
   }
  }
}