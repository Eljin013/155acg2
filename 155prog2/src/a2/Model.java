package a2;

import com.jogamp.opengl.awt.GLCanvas;

public class Model {
	private GLCanvas myCanvas;
	private float cameraX, cameraY, cameraZ;
	private float crysLocX, crysLocY, crysLocZ;
	

	//instantiate commands

	

	
	public Model() {
		myCanvas = new GLCanvas();
	}

	
	public GLCanvas getMyCanvas() {
		return myCanvas;
	}

	public void setMyCanvas(GLCanvas myCanvas) {
		this.myCanvas = myCanvas;
	}


	public float getCameraX() {
		return cameraX;
	}


	public void setCameraX(float cameraX) {
		this.cameraX = cameraX;
	}


	public float getCameraY() {
		return cameraY;
	}


	public void setCameraY(float cameraY) {
		this.cameraY = cameraY;
	}


	public float getCameraZ() {
		return cameraZ;
	}


	public void setCameraZ(float cameraZ) {
		this.cameraZ = cameraZ;
	}


	public float getCrysLocX() {
		return crysLocX;
	}


	public void setCrysLocX(float crysLocX) {
		this.crysLocX = crysLocX;
	}


	public float getCrysLocY() {
		return crysLocY;
	}


	public void setCrysLocY(float crysLocY) {
		this.crysLocY = crysLocY;
	}


	public float getCrysLocZ() {
		return crysLocZ;
	}


	public void setCrysLocZ(float crysLocZ) {
		this.crysLocZ = crysLocZ;
	}
	
	
}
