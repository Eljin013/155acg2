package a2;

public class Moon {
	private float locX, locY, locZ;
	private float[] vertex_positions;
	
	public Moon(float xLoc, float yLoc, float zLoc){
		locX = xLoc;
		locY = yLoc;
		locZ = zLoc;
		vertex_positions = new float[]
		{	-0.5f, 0.0f, 0.0f, 0.0f, 0.0f, 0.5f, 0.0f, 1.0f, 0.0f,
			0.0f, 0.0f, 0.5f, 0.5f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f,
			0.5f, 0.0f, 0.0f, 0.0f, 0.0f, -0.5f, 0.0f, 1.0f, 0.0f,
			0.0f, 0.0f, -0.5f, -0.5f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f,
			-0.5f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 0.5f,
			0.0f, 0.0f, 0.5f, 0.0f, -1.0f, 0.0f, 0.5f, 0.0f, 0.0f,
			0.5f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, -0.5f,
			0.0f, 0.0f, -0.5f, 0.0f, -1.0f, 0.0f, -0.5f, 0.0f, 0.0f,
		};
	}

	public float[] getVertex_positions() {
		return vertex_positions;
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
