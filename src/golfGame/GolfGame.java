package golfGame;


import util.Planet;

class GolfGame {
	
	
	
	public static void main(String[] args) {
		
		
		Calculations calculations = new Calculations();
		
		
		double distanceToHole = 1; //util.General.GetRandomNumber(75, 300); //H�r st�ller man in l�ngden p� sj�lva banan. Allts� l�ngden till h�let.
		
		Planet planetChoice = calculations.changePlanet(); //H�r f�r spelaren best�mma vilken planet de k�r p�
		calculations.playerTurn(distanceToHole, planetChoice); 
		calculations.endGameStatistics();
		
	
		
		
		
		
		
		}//End of Main
	
	
} // End of class GolfGame
