import java.util.Scanner;


public class FIFA {

	public static void main(String[] args) {
		String[] teams16 = {"Uruguay", "Portugal", "France", "Argentina", "Brazil", "Mexico", "Belgium", "Japan", "Spain",
							"Russia", "Croatia", "Denmark", "Sweden", "Switzerland", "Colombia", "England"}; //given information
		
		String[] teams8 = new String[8]; //The winners of the first round will be in this array
		String[] teams4 = new String[4]; //The winners of the second round will be in this array
		String[] teams2 = new String[2]; //The winners of the third round will be in this array
		String favourite; 				 //Will contain the name of the user's favourite team
		String winner = "";				 //Will contain the name of the team who won FIFA
		//Those variables will be used to assign scores to the competing teams
		int scoreTeam1 =0;
		int scoreTeam2 =0;
		int balanceBreaker =0; //will determine which team will win if they have the same scores
		double averageTournament = 0;		//represents the average goal count of the matches in a single tournament
		double averageAllTournaments = 0;	//represents the total average
		
		int[][] allTournamentGoals = new int[20][15]; //will store all goals scored during the matches
		int allGoalsCounter = 0;					  //Counts all goals scored during all matches
		int matchesOverAverage=0;					  //Number of matches above averageAllTournaments
		
		//Variable declaration
		Scanner keyboard = new Scanner(System.in);		//used to get input from user
		boolean donePlaying = false;					//Tells the program when to display the statistics
		boolean matchFound = false;						//to verify if the user has entered valid input
		
		
		
		//Prompt the user for input
		System.out.print("Please enter the name of your favorite team: ");
		//Collecting data
		favourite = keyboard.nextLine();
		System.out.println();
		//Closing the scanner
		keyboard.close();
		//Formating input data
		favourite = favourite.replaceAll(" ",""); //replaces all whitespace by empty strings, thus removing all the whitespace
		
		
		//Checking if the user entered a valid name
		for (int i = 0; i < teams16.length; i++) {
			if (favourite.equalsIgnoreCase(teams16[i])) {
				matchFound = true;
				//Further formating favourite at the same time
				favourite = teams16[i];
			}
		}
		
		//if no matchFound is found, the program terminates with an error message
		if (!matchFound) {
			System.err.println("Your team is not in the Round of 16");
			System.exit(0);
		}
		
		
		for(int counter =0; counter<allTournamentGoals.length; counter++ ) {
			
			allGoalsCounter=0; //setting it back to zero, so next row of allTournamentGoals can be filled
		
			System.out.println("~~~~~~~ROUND OF 16~~~~~~~");
			
			int j =0;
			//matches: take two teams, generates scores, push the winning team to teams 8
			for (int i = 0; i < teams8.length; i++,j+=2) {			
				scoreTeam1 = (int)(Math.random()*5);
				scoreTeam2 = (int)(Math.random()*5);
				//sudden death
				if (scoreTeam1==scoreTeam2) {
					balanceBreaker = (int)(Math.random()*2);
					if (balanceBreaker<=1) {
						scoreTeam1++;
					}else {
						scoreTeam2++;
					}
				}
				
				//Goals are recorded, and the counter is increased
				allTournamentGoals[counter][allGoalsCounter] = scoreTeam1 + scoreTeam2;
				allGoalsCounter++;
				
				//winner gets assigned to teams8
				teams8[i] = (scoreTeam1>scoreTeam2)?(teams16[j]):(teams16[j+1]);
				
				//Displaying the results of the match to the user, and skipping a line so the console doesn't get cluttered
				System.out.println("[" + teams16[j] + " " + scoreTeam1 + ":" + scoreTeam2 + " " + teams16[j+1] + "]");
			}
			
			
			
			
			System.out.println("~~~~~~~QUARTER-FINALS~~~~~~~");
			
			j =0;
			//matches: take two teams, generates scores, push the winning team to teams4
			for (int i = 0; i < teams4.length; i++,j+=2) {			
				scoreTeam1 = (int)(Math.random()*5);
				scoreTeam2 = (int)(Math.random()*5);
				//sudden death
				if (scoreTeam1==scoreTeam2) {
					balanceBreaker = (int)(Math.random()*2);
					if (balanceBreaker<=1) {
						scoreTeam1++;
					}else {
						scoreTeam2++;
					}
				}
				
				//winner gets assigned to teams4
				teams4[i] = (scoreTeam1>scoreTeam2)?(teams8[j]):(teams8[j+1]);
				
				//Goals are recorded, and the counter is increased
				allTournamentGoals[counter][allGoalsCounter] = scoreTeam1 + scoreTeam2;
				allGoalsCounter++;
				
				//Displaying the results of the match to the user
				System.out.println("[" + teams8[j] + " " + scoreTeam1 + ":" + scoreTeam2 + " " + teams8[j+1] + "]");
					
			}
			
			
			
			System.out.println("~~~~~~~SEMI-FINALS~~~~~~~");
			
			j =0;
			//matches: take two teams, generates scores, push the winning team to teams2
			for (int i = 0; i < teams2.length; i++,j+=2) {			
				scoreTeam1 = (int)(Math.random()*5);
				scoreTeam2 = (int)(Math.random()*5);
				//sudden death
				if (scoreTeam1==scoreTeam2) {
					balanceBreaker = (int)(Math.random()*2);
					if (balanceBreaker<=1) {
						scoreTeam1++;
					}else {
						scoreTeam2++;
					}
				}
				
				//winner gets assigned to teams2
				teams2[i] = (scoreTeam1>scoreTeam2)?(teams4[j]):(teams4[j+1]);
				
				//Goals are recorded, and the counter is increased
				allTournamentGoals[counter][allGoalsCounter] = scoreTeam1 + scoreTeam2;
				allGoalsCounter++;
				
				//Displaying the results of the match to the user
				System.out.println("[" + teams4[j] + " " + scoreTeam1 + ":" + scoreTeam2 + " " + teams4[j+1] + "]");
					
			}
			
			
			
			System.out.println("~~~~~~~FINAL~~~~~~~");
			
			scoreTeam1 = (int)(Math.random()*5);
			scoreTeam2 = (int)(Math.random()*5);
			//sudden death
			if (scoreTeam1==scoreTeam2) {
				balanceBreaker = (int)(Math.random()*2);
				if (balanceBreaker<=1) {
					scoreTeam1++;
				}else {
					scoreTeam2++;
				}
			}
			
			//Goals are recorded, and the counter is increased
			allTournamentGoals[counter][allGoalsCounter] = scoreTeam1 + scoreTeam2;
			allGoalsCounter++;
			
			//Displaying the results of the match to the user
			System.out.println("[" + teams2[0] + " " + scoreTeam1 + ":" + scoreTeam2 + " " + teams2[1] + "]");
			
			//Displaying the FIFA winner
			winner = (scoreTeam1>scoreTeam2)?(teams2[0]):(teams2[1]);
			System.out.println("Tournament: " + counter + " The WINNER is: " + winner);
			
			//If the user's favourite team wins, Tournament statistics are displayed and the program terminates
			if (winner.equals(favourite) && !donePlaying) {
				System.out.println("It took " + (counter+1) + " tournament(s) for " + favourite + " to win!!!");
				donePlaying = true;
			//If the user's favourite team doesn't win, a scathing message is displayed along with the same statistics
			} else if (counter==allTournamentGoals.length-1&& !donePlaying) {
				System.out.println("Sorry, " + favourite + " didn't win in " + allTournamentGoals.length + " tournaments!");
				donePlaying = true;
			//No more matches will be generated, the program displays match statistics and dies peacefully
			} else if (donePlaying) {
				System.out.println("\nGOAL STATS\n");
				for (int j2 = 0; j2 <= counter; j2++) {
					averageTournament =0;
					System.out.print("[Tournament " + j2 + "] Total goals: [");
					for (int i = 0; i < allTournamentGoals[j2].length; i++) {
						//updating the average goal count of the tournament, which will be divided later
						averageTournament+=allTournamentGoals[j2][i]; 
						//Printing all entries of allTournamentGoals
						if (allTournamentGoals[j2].length-1==i) {	//so it doesn't print an unnecessary comma at the end
							System.out.print(allTournamentGoals[j2][i] + " ");
						}else {
							System.out.print(allTournamentGoals[j2][i] + ", ");
						}
					}
					//The sum of all entries is divided by the length of the array, producing an average
					averageTournament/=allTournamentGoals[counter].length;
					//The value of the last average is updated, it will be divided later
					averageAllTournaments+=averageTournament;
					
					System.out.printf("] [Average: %.1f]\n",averageTournament );
				}
				//The last average is divided by the number of filled rows of the array, producing the required average
				averageAllTournaments/=counter+1;
				//Displaying the formated result
				System.out.printf("Average goals for "+ (counter+1) +" tournament(s): %.1f\n", averageAllTournaments);
				
				//Find all matches that have more goals than the average
				System.out.print("Total matches in all tournaments over the average goal value: ");
				for (int j2 = 0; j2 <= counter; j2++) {
					for (int i = 0; i < allTournamentGoals[j2].length; i++) {
						if (allTournamentGoals[j2][i]>averageAllTournaments) {
							matchesOverAverage++;
						}
					}
				}
				System.out.println(matchesOverAverage);
				System.exit(0); //The program has fulfilled its task, it doesn't to loop anymore, it can terminate now
			}
		}
	}
}
