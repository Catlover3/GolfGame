package golfGame;


import util.Planet;

class GolfGame {
	
	
	
	public static void main(String[] args) {
		
		
		Calculations calculations = new Calculations();
		
		
		double distanceToHole = 1; //util.General.GetRandomNumber(75, 300); //Här ställer man in längden på själva banan. Alltså längden till hålet.
		
		Planet planetChoice = calculations.changePlanet(); //Här får spelaren bestämma vilken planet de kör på
		calculations.playerTurn(distanceToHole, planetChoice); 
		calculations.endGameStatistics();
		
	
		
		
		
		
		
		}//End of Main
	
	
} // End of class GolfGame
