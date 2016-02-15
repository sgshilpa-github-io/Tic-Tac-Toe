package tictactoeApplications;
import java.util.Scanner;
 


public class TicTacToeApplication {
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		boolean doyouwanaPlay=true;
		while(doyouwanaPlay){
			System.out.println("Welcome to tic tac toe.\nLets play the game.\n"
					+ "Enter the character you wanna choose for yourself");
			char userToken=sc.nextLine().charAt(0);
			System.out.println("\nEnter the character you wanna choose for your opponent\n");
			char aitoken=sc.nextLine().charAt(0);
			TicTactoe game=new TicTactoe(userToken, aitoken);
			
			Ai ai=new Ai();
			
			System.out.println();
			System.out.println("Lets start a game");
			game.printBoardIndex();
			System.out.println();
			game.printBoard();
			game.currentmarker=game.usermarker;
			while(game.IsgameOver().equals("Not over")){
				if(game.currentmarker==game.usermarker){
					
					System.out.println("Enter location you want to fill");
					int spot=sc.nextInt();
					while (!game.playTurn(spot)){
						System.out.println("Try again , soot already taken");
						spot=sc.nextInt();
					}
					
					System.out.println("You picked"+spot+ "place");
						
			
				
				
			}
				else{
					
					System.out.println("Its my turn");
					int aispot=ai.pickSpot(game);
					game.playTurn(aispot);
					System.out.println("I picked"+ aispot+"place");
				}
				System.out.println();
				game.printBoard();
			
			}
			System.out.println("Game is over");
			System.out.println(game.IsgameOver());
			
			System.out.println("Do you wanna play again?\n Type y if yes else type anything if you bored");
			char wannaplay=sc.next().charAt(0);
			doyouwanaPlay=(wannaplay=='y');
			
			
			
		
			
		}
		
	}

}
