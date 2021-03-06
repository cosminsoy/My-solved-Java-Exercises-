/*
 *  The program prompts the user to enter a number continuously until the number matches the randomly generated 
 *  number. For each user input, the program tells the user whether the input is too low or too high, so the user 
 *  can make the next guess intelligently. 
 */

import java.util.*; 

public class HelloWorld {
  public static void main(String[] args) {
  
    	Scanner input = new Scanner(System.in);
  	int  number = (int)( Math.random() * 101 );
  
    	System.out.print("Guess a magic number between 0 and 100. \nEnter your guess: ");
    	int answer = input.nextInt();
    	
    	while( number != answer ){
    	
    		if( answer > number ) {
    			System.out.print("Your guess is too high. Try again.  \nEnter your guess: ");
    		}
    		else{
    			System.out.print("Your guess is too low. Try again.  \nEnter your guess: ");
    		}
    		
    		answer = input.nextInt();
    	}
    	
    	System.out.println("You got it!");
    	
  }
}
