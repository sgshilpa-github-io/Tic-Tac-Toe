package tictactoeApplications;

import java.util.ArrayList;
import java.util.Random;

public class Ai {
	
	public int pickSpot(TicTactoe game){
		
		ArrayList<Integer> options=new ArrayList();
		for (int i=0;i<9;i++){
			if (game.board[i]=='-'){
				options.add(i+1);
			}
		}
		Random rn=new Random();
		int choice=options.get(Math.abs(rn.nextInt() % options.size()));
		System.out.println("choice"+choice);
		return choice;
		
		
	}
	

}
