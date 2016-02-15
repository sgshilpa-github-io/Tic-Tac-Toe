package tictactoeApplications;

public class TicTactoe {
	protected char[] board;
	protected char usermarker;
	protected char aimarker;
	protected char winner;
	protected char currentmarker;
	
	
public TicTactoe(char usertoken,char opponentmarker){
	this.usermarker=usertoken;
	this.aimarker=opponentmarker;
	this.winner='-';
	this.board=setBoard();	
		
	}

public static char[] setBoard(){
	char[] board=new char[9];
	
	for (int i=0;i<9;i++){
		
		board[i]='-';
	}
	return board;
}

public boolean playTurn(int spot){
	boolean available=isEmpty(spot) && isValid(spot);
	if(available){
		this.board[spot-1]=currentmarker;
		currentmarker=(currentmarker==usermarker)?aimarker:usermarker;
		
	}
	
	return available;
	
}

public boolean isEmpty(int spot) {
	return board[spot-1]=='-';
}



public boolean isValid(int spot) {
	if ((spot>0) && (spot<board.length+1)){
		return true;
		
	}
	return false;
}

public void printBoard(){
	for(int i=0;i<9;i++){
		if(i%3==0){
			System.out.println();
			System.out.println("-----------");
		}
	System.out.print(" | "+board[i]);
		
	}
	System.out.println();
}

public void printBoardIndex(){
	for(int i=0;i<9;i++){
		if(i%3==0){
			System.out.println();
			System.out.println(" ----------- ");
		}
	System.out.print(" | "+(i+1));
		
	}
}

public boolean IsthereAWinner(){
	
	boolean diagnolsAndMiddles=board[4] != '-' &&( right() || left() || seconcol() || middlerow() );
	
	boolean topAndFirst=board[0] !='-' && (topRow() || firstcol()) ;
	boolean downAndlast=board[8] !='-' && (downRow() || lastcol()) ;
	System.out.println(topAndFirst);
	
	
	 if (diagnolsAndMiddles){
		 this.winner=board[4];
	 }
	 else if (topAndFirst){
		 this.winner=board[0];
	 }
	 else if(downAndlast){
		 this.winner=board[8];
	 }
	
		 return diagnolsAndMiddles || topAndFirst || downAndlast ;
		 
}

private boolean firstcol() {
	return board[0]==board[3] && board[3]==board[6];
}

private boolean topRow() {
	return board[0]==board[1] && board[1]==board[2];

}

private boolean lastcol() {
	return board[2]==board[5] &&board[5]==board[8];
}

private boolean downRow() {
	return board[6]==board[7] &&board[7]==board[8];
}

private boolean middlerow() {
	return board[3]==board[4] &&board[4]==board[5];
}

private boolean seconcol() {
	return board[1]==board[4] &&board[4]==board[7];
}

private boolean left() {
	return board[0]==board[4] && board[4]==board[8];
}

private boolean right() {
	return board[2]==board[4] && board[4]==board[6];
}

public boolean IsBoardFilled(){
	
	for (int i=0;i<9;i++){
		if (board[i]=='-'){
			return false;
		}	
	}
	return true;
}
public String IsgameOver(){
	
	boolean didsomeoneWin=IsthereAWinner();
	if (didsomeoneWin){
		return "Yes we have a winner and winner is "+ this.winner;
	}
	else if(IsBoardFilled()){
		return "Its a tie, game over";
	}
	else{
		
		return "Not over";
	}
	
	
	
}



}
