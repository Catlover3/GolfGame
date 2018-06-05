package util;

public enum Planet {

	Earth(9.81),
	Mars(3.71),
	Saturn(10.44),
	Jupiter(24.79);
	
	private final double gravity;
	
	
	public double gravity() {
		return gravity;
		
	}
	
	private Planet(double Grav) {
		this.gravity = Grav;
	}

	double getGravity() {
		return gravity;
	}
	
}
