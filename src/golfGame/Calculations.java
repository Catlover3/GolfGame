package golfGame;

import java.util.ArrayList;
import java.util.Arrays;

import util.Planet;

class Calculations {
	

	public int numberOfStrikes = 0;
	ArrayList<Double> strokeList = new ArrayList<Double>();

	public void playerTurn(double distanceToHole, Planet PlanetChoice) {
		Planet planetChoice = PlanetChoice;
		System.out.println("The hole is " + distanceToHole + " m away");
		System.out.println("You have 7 strokes to complete the hole");
		System.out.println();

		while (distanceToHole != 0 && distanceToHole <= distanceToHole*1.5 && strokeList.size() + 1 <= 7) {
			System.out.println("Shot nr: " + (strokeList.size() + 1) + "(7)") ;
			System.out.println("Enter the angle which you want the ball to go");
			double degrees = util.General.ScanNextInt(1, 45);

			System.out.println("Enter the power of the strike between 1 and 60");
			double power = util.General.ScanNextInt(1, 60);

			double stroke = strike(degrees, power, planetChoice); //Här körs slaget
			stroke = util.General.RoundToDecimal(stroke, 1); // Avrundar till en decimal

			distanceToHole = (((distanceToHole * 10) - (stroke * 10)) / 10); // Ändrar så att det bara är en decimal och subtraherar
																				// slaget från hålet
			
			strokeList.add(stroke); // Lägger till slaget i statistiken
			
			System.out.println();
			System.out.println("You hit the ball and it travels " + stroke + " m");
			if (distanceToHole < 0) { // Ifall spelaren skjuter förbi hålet
				distanceToHole = Math.abs(distanceToHole); // Ändrar negativa värden till positiva
				System.out.println("You overshot the hole and are now " + distanceToHole + "m away from the hole");
				System.out.println("*********************************");
			}
			else {	
				System.out.println("You are now " + distanceToHole + " m from the hole");

			}
		}
		winAndLoseConditions(distanceToHole);

	}

	public void winAndLoseConditions(double distanceToHole) {
		System.out.println("\n************************************\n"); 
		if (distanceToHole == 0) {
			System.out.println("You have won!");
		} else if (distanceToHole >= 200) {
			System.out.println("Game over: You are out of bounds");
		} else if (strokeList.size() >= 7) { // Ifall man tar för många slag körs detta meddelande
			System.out.println("You have taken to many shots on this course and will have to restart");
		}
	}

	public double strike(double degrees, double power, Planet planetChoice) {

		double degreeToRadian = (Math.PI / 180) * degrees;
		double strike = (Math.pow(power, 2) / planetChoice.gravity()) * Math.sin(2 * degreeToRadian);
		
		return strike;
	}

	public void endGameStatistics() { 
		System.out.println("Length of all your shots:");
		
		
		Arrays.toString(strokeList.toArray());
		int i = 0;
		for (Double list : strokeList) {
			i++;
			System.out.println(i + ": " + list + " m");
			
		}
		System.out.println("You have taken " + strokeList.size() + " shots");
		
	}

	
	public Planet changePlanet() {
		Planet planetChoice = Planet.Earth;
		
		System.out.println("Which planet do you want to play on?");
		System.out.println("1. Earth gravity: 9.81m/s2");
		System.out.println("2. Mars gravity: 3.71m/s2");
		System.out.println("3. Saturn gravity: 10.44m/s2");
		System.out.println("4. Jupiter gravity: 24.79m/s2");
		int menuChoice = util.General.ScanNextInt(1, 4);
		switch(menuChoice) {
		case 1:
			break;
		case 2: planetChoice = Planet.Mars;
			break;
		case 3: planetChoice = Planet.Saturn;
			break;
		case 4: planetChoice = Planet.Jupiter;
			break;
		}
		return planetChoice;
	}
	
	

}// Slut på klassen
