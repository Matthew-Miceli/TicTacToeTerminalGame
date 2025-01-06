import java.util.Scanner;
import java.util.Arrays;
public class TicTacToeDriver{
  public static void main(String[] args){
    Scanner input = new Scanner(System.in);

    TicTacToeBoard ticTacToeBoard = new TicTacToeBoard();
    displayMenu();
    int turn = 0;
    int currPlayer = 1;
    int win = 0;
    do{
      ticTacToeBoard.printBoard();     

      if(turn % 2 == 0) currPlayer = 1;
      else currPlayer = 2;
    

      System.out.printf("Player %d please select a location(x,y). 0 indexed.", currPlayer);
       
      int[] pos = receivePos(input);
      while(!ticTacToeBoard.isEmpty(pos)){
          System.out.printf("Player %d please enter a valid location(x,y). Cannot already be taken.", currPlayer);
          pos = receivePos(input);
      }
      ticTacToeBoard.setChoice(currPlayer, pos);
      turn++;
      win = ticTacToeBoard.win();
    }while(win == 0); 
    
    ticTacToeBoard.printBoard();
    System.out.printf("Player %d has won the game", win);
  }
  public static void displayMenu(){
    System.out.println("This is a basic game of tic tac toe");
    System.out.println("Player 1: X");
    System.out.println("Player 2: O");
  }
  public static int[] receivePos(Scanner input){
    int[] pos = new int[2];
    String[] posString = (input.nextLine()).split(",");
    for(int i = 0; i < posString.length; i++){
      pos[i] = Integer.parseInt(posString[i].trim());
    }
    //if(pos[1] == 2 && pos[0] == 0) pos[1] = 0;
    //if(pos[1] == 0 && pos[0] == 0) pos[1] = 2;
    
    //if(pos[1] == 2 && pos[0] == 2) pos[1] = 0;
    //if(pos[1] == 0 && pos[0] == 2) pos[1] = 2;

    int temp = 0;
    temp = pos[0];
    pos[0] = pos[1];
    pos[1] = temp;

   return pos;
  }

}
