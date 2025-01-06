import java.util.Map;
import java.util.HashMap;

public class TicTacToeBoard{
 String[][] board = {{"   ", "|", "   ", "|", "   "},
                        {" - ", "-", " - ", "-", " - "},
                        {"   ", "|", "   ", "|", "   "},
                        {" - ", "-", " - ", "-", " - "},
                        {"   ", "|", "   ", "|", "   "}};
    

  public TicTacToeBoard(){
  }

  public String getVal(int x, int y){
    int valXPos = x * 2;
    int valYPos = y * 2;

    return board[valXPos][valYPos];
  }

  public void printBoard(){

    int i = 2;
     for(int row = board.length - 1; row >= 0; row--){
      if(row % 2 == 0){
        System.out.print(i-- + " ");
      }else{
        System.out.print("  ");
      }
       for(String val: board[row]){
         System.out.print(val);
        }
       System.out.println();

    }
    System.out.println("   0   1   2 ");
  

  }

  public String getPos(int[] pos){
     return board[pos[0] * 2][pos[1] * 2];   
  }

  public void setChoice(int player, int[] pos){
    board[pos[0] * 2][pos[1] * 2] = getPiece(player);
  }

  public int win(){

    for(String[] row: board){
      Map<String, Integer> rowMap = new HashMap<>();
      for(String val: row){
        rowMap.put(val, rowMap.getOrDefault(val, 0) + 1);
      }
      if(rowMap.containsKey(" X ") && rowMap.get(" X ") == 3) return 1;
      if(rowMap.containsKey(" O ") && rowMap.get(" O ") == 3) return 2;
    }
    
    for(int col = 0; col < board[0].length;col++){
      Map<String, Integer> colMap = new HashMap<>();
      for(int row = 0; row < board.length; row++){
        colMap.put(board[row][col], colMap.getOrDefault(board[row][col], 0) + 1);
        
      }
      if(colMap.containsKey(" X ") && colMap.get(" X ") == 3) return 1;
      if(colMap.containsKey(" O ") && colMap.get(" O ") == 3) return 2;
         
    }

    if(board[0][0].equals(" X ") && board[2][2].equals(" X ") && board[4][4].equals(" X ")) return 1;
    if(board[0][4].equals(" X ") && board[2][2].equals(" X ") && board[4][0].equals(" X ")) return 1;

    if(board[0][0].equals(" O ") && board[2][2].equals(" O ") && board[4][4].equals(" O ")) return 2;
    if(board[0][4].equals(" O ") && board[2][2].equals(" O ") && board[4][0].equals(" O ")) return 2;



    return 0;
  }
  public String getPiece(int player){
    String piece = "";
    if(player == 1) piece = " X ";
    if(player == 2) piece = " O ";
    return piece;
  }

  public boolean isEmpty(int[] pos){
    if (getPos(pos).equals("   ")) return true;
    return false;
  }


}
