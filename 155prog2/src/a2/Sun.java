package a2;

public class Sun {
	private float locX, locY, locZ;
	
	public Sun(float xLoc, float yLoc, float zLoc){
		locX = xLoc;
		locY = yLoc;
		locZ = zLoc;
	}

	public float getLocX() {
		return locX;
	}

	public void setLocX(float locX) {
		this.locX = locX;
	}

	public float getLocY() {
		return locY;
	}

	public void setLocY(float locY) {
		this.locY = locY;
	}

	public float getLocZ() {
		return locZ;
	}

	public void setLocZ(float locZ) {
		this.locZ = locZ;
	}
	
}
