package edu.ithaca.dragon.games.tictactoe.player;

import org.javatuples.Pair;

import edu.ithaca.dragon.games.tictactoe.board.TicTacToeBoard;

public class RuleBaseAgent implements TicTacToePlayer {

	@Override
	public Pair<Integer, Integer> chooseSquare(TicTacToeBoard curBoard, char yourSymbol) {
        if(boardEmpty(curBoard)) return new Pair<>(0,0);
        if(curBoard.isSquareOpen(new Pair<>(1,1))) return new Pair<>(1,1);
        String[] board = curBoard.buildSquaresString().split("");
        Pair<Integer, Integer> win = winLocation(board, ""+yourSymbol);
        if(win != null) return win;
        Pair<Integer, Integer> block = blockLocation(board);
        if(block != null) return block;
        if(countSymbol(board, ""+yourSymbol) == 1 && countSymbol(board, "=") == 3){
            if(board[4].equals(""+yourSymbol)){
                return new Pair<>(1,0);
            }
        }
        if(curBoard.isSquareOpen(new Pair<>(2,2))) return new Pair<>(2,2);
        if(curBoard.isSquareOpen(new Pair<>(0,2))) return new Pair<>(0,2);
        if(curBoard.isSquareOpen(new Pair<>(2,0))) return new Pair<>(2,0);
        if(curBoard.isSquareOpen(new Pair<>(1,2))) return new Pair<>(1,2);
        if(curBoard.isSquareOpen(new Pair<>(1,0))) return new Pair<>(1,0);
        if(curBoard.isSquareOpen(new Pair<>(0,1))) return new Pair<>(0,1);
        if(curBoard.isSquareOpen(new Pair<>(2,1))) return new Pair<>(2,1);
        return null;

    }
    
    public int countSymbol(String[] board, String symbol){
        int count = 0;
        if(symbol.equals("=")){
            for(int x = 0; x < 9; x ++){
                if(!board[x].equals(" ")) count++;
            }
        }
        else{
            for( int x = 0; x < 9; x ++){
                if(board[x].equals(symbol)) count++;
            }
        }
        return count;
    }

    public Pair<Integer, Integer> winLocation(String[] board, String y){
        for(int x = 0; x < 3; x ++){
            int offset = x * 3;
            if(board[offset].equals(board[offset + 1]) && board[offset + 2].equals(" ") && board[offset].equals(y)) return new Pair<>(2, x);
            else if(board[offset].equals(board[offset + 2]) && board[offset + 1].equals(" ") && board[offset].equals(y)) return new Pair<>(1, x);
            else if(board[offset + 2].equals(board[offset + 1]) && board[offset].equals(" ") && board[offset + 2].equals(y)) return new Pair<>(0, x);
            else if(board[x].equals(board[x + 3]) && board[x + 6].equals(" ") && board[x].equals(y))return new Pair<>(x, 2);
            else if(board[x].equals(board[x + 6]) && board[x + 3].equals(" ") && board[x].equals(y))return new Pair<>(x, 1);
            else if(board[x + 6].equals(board[x + 3]) && board[x].equals(" ") && board[x + 6].equals(y))return new Pair<>(x, 0);
        }
        if(board[0].equals(board[4]) && board[8].equals(" ") && board[4].equals(y))return new Pair<>(2,2);
        else if(board[8].equals(board[4]) && board[0].equals(" ") && board[4].equals(y))return new Pair<>(0,0);
        else if(board[2].equals(board[4]) && board[6].equals(" ") && board[4].equals(y))return new Pair<>(0,2);
        else if(board[6].equals(board[4]) && board[2].equals(" ") && board[4].equals(y))return new Pair<>(2,0);
        return null;
    }

    public Pair<Integer, Integer> blockLocation(String[] board){
        for(int x = 0; x < 3; x ++){
            int offset = x * 3;
            if(board[offset].equals(board[offset + 1]) && board[offset + 2].equals(" ") && !board[offset].equals(" ")) return new Pair<>(2, x);
            else if(board[offset].equals(board[offset + 2]) && board[offset + 1].equals(" ") && !board[offset].equals(" ")) return new Pair<>(1, x);
            else if(board[offset + 2].equals(board[offset + 1]) && board[offset].equals(" ") && !board[offset + 2].equals(" ")) return new Pair<>(0, x);
            else if(board[x].equals(board[x + 3]) && board[x + 6].equals(" ") && !board[x].equals(" "))return new Pair<>(x, 2);
            else if(board[x].equals(board[x + 6]) && board[x + 3].equals(" ") && !board[x].equals(" "))return new Pair<>(x, 1);
            else if(board[x + 6].equals(board[x + 3]) && board[x].equals(" ") && !board[x + 6].equals(" "))return new Pair<>(x, 0);
        }
        if(board[0].equals(board[4]) && board[8].equals(" ") && !board[4].equals(" "))return new Pair<>(2,2);
        else if(board[8].equals(board[4]) && board[0].equals(" ") && !board[4].equals(" "))return new Pair<>(0,0);
        else if(board[2].equals(board[4]) && board[6].equals(" ") && !board[4].equals(" "))return new Pair<>(0,2);
        else if(board[6].equals(board[4]) && board[2].equals(" ") && !board[4].equals(" "))return new Pair<>(2,0);
        return null;
    }

    public boolean boardEmpty(TicTacToeBoard board){
        for(int x = 0; x < 9; x ++){
            if(!board.isSquareOpen(new Pair<>(x % 3, (int)(x/3)))){
                return false;
            }
        }
        return true;
    }
}