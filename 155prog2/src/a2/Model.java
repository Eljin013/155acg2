package a2;

import static com.jogamp.opengl.GL.GL_ARRAY_BUFFER;
import static com.jogamp.opengl.GL.GL_STATIC_DRAW;

import java.nio.FloatBuffer;

import com.jogamp.common.nio.Buffers;
import com.jogamp.opengl.GL4;
import com.jogamp.opengl.GLContext;
import com.jogamp.opengl.awt.GLCanvas;

import graphicslib3D.Matrix3D;

public class Model {
	private GLCanvas myCanvas;
	private int vao[] = new int[1];
	private int vbo[] = new int[4];
	private int object_program;
	private int axes_program;
	
	private Matrix3D pMat;
	private Matrix3D mvMat;
	private Matrix3D mMat;
	private Matrix3D vMat;
	
	//camera
	private Camera camera;
	private Sun sun;
	private Planet planet1, planet2;
	private Moon moon1, moon2;
//	private float[] axes;

	//instantiate commands
	
	public Model() {
		myCanvas = new GLCanvas();
		camera = new Camera(0.0f, 0.0f, 16.0f);
		sun = new Sun(0.0f, 0.0f, 0.0f);
		planet1 = new Planet(0.0f, 0.0f, 0.0f);
		planet2 = new Planet(0.0f, 0.0f, 0.0f);
		moon1 = new Moon(0.0f, 0.0f, 0.0f);
		moon2 = new Moon(0.0f, 0.0f, 0.0f);
		
		//Set up the matrices
		vMat = new Matrix3D();
		vMat.translate(	-camera.getLocX(),
						-camera.getLocY(), 
						-camera.getLocZ());

		mMat = new Matrix3D();
		mMat.translate(	moon1.getLocX(),
						moon1.getLocY(),
						moon1.getLocZ());

		mvMat = new Matrix3D();
		mvMat.concatenate(vMat);
		mvMat.concatenate(mMat);
		
	}

	
	public GLCanvas getMyCanvas() {
		return myCanvas;
	}

	public void setMyCanvas(GLCanvas myCanvas) {
		this.myCanvas = myCanvas;
	}

	public int[] getVao() {
		return vao;
	}


	public void setVao(int[] vao) {
		this.vao = vao;
	}


	public int[] getVbo() {
		return vbo;
	}


	public void setVbo(int[] vbo) {
		this.vbo = vbo;
	}


	public int getObjectProgram() {
		return object_program;
	}

	public void setObjectProgram(int object_program) {
		this.object_program = object_program;
	}

	public int getAxesProgram() {
		return axes_program;
	}

	public void setAxesProgram(int axes_program) {
		this.axes_program = axes_program;
	}

	public void setupVertices() {
		GL4 gl = (GL4) GLContext.getCurrentGL();
		
		float[] pyramid =
			{-0.5f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 0.5f,
			 0.0f, 0.0f, 0.5f, 0.0f, -1.0f, 0.0f, 0.5f, 0.0f, 0.0f,
			 0.5f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, -0.5f,
			 0.0f, 0.0f, -0.5f, 0.0f, -1.0f, 0.0f, -0.5f, 0.0f, 0.0f,
			 -0.5f, 0.0f, 0.0f, 0.0f, 0.0f, 0.5f, 0.0f, 0.0f, -0.5f,
			 0.0f, 0.0f, 0.5f, 0.5f, 0.0f, 0.0f, 0.0f, 0.0f, -0.5f,
			};
		
		float[] axes =
			{0.0f, 0.0f, 0.0f, 5.0f, 0.0f, 0.0f,
			 0.0f, 0.0f, 0.0f, 0.0f, 5.0f, 0.0f,
			 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 5.0f,
			};
		
		
		gl.glGenVertexArrays(vao.length, vao, 0);
		gl.glBindVertexArray(vao[0]);
		gl.glGenBuffers(vbo.length, vbo, 0);
		
		gl.glBindBuffer(GL_ARRAY_BUFFER, vbo[0]);
		FloatBuffer vertBuf = Buffers.newDirectFloatBuffer(axes);
		gl.glBufferData(GL_ARRAY_BUFFER, vertBuf.limit()*4, vertBuf, GL_STATIC_DRAW);
		
		gl.glBindBuffer(GL_ARRAY_BUFFER, vbo[1]);
		FloatBuffer vertBuf1 = Buffers.newDirectFloatBuffer(pyramid);
		gl.glBufferData(GL_ARRAY_BUFFER, vertBuf1.limit()*4, vertBuf1, GL_STATIC_DRAW);
	}  //setupVertices()
	
	public Camera getCamera() {
		return camera;
	}
	
	public void setCamera(Camera cam) {
		this.camera = cam;
	}

	public Sun getSun() {
		return sun;
	}

	public void setSun(Sun sun) {
		this.sun = sun;
	}

	public Planet getPlanet1() {
		return planet1;
	}

	public void setPlanet1(Planet planet1) {
		this.planet1 = planet1;
	}

	public Planet getPlanet2() {
		return planet2;
	}

	public void setPlanet2(Planet planet2) {
		this.planet2 = planet2;
	}

	public Moon getMoon1() {
		return moon1;
	}

	public void setMoon1(Moon moon1) {
		this.moon1 = moon1;
	}

	public Moon getMoon2() {
		return moon2;
	}

	public void setMoon2(Moon moon2) {
		this.moon2 = moon2;
	}

	public Matrix3D getpMat() {
		return pMat;
	}

	public void setpMat(Matrix3D pMat) {
		this.pMat = pMat;
	}

	public Matrix3D getMvMat() {
		return mvMat;
	}

	public void setMvMat(Matrix3D mvMat) {
		this.mvMat = mvMat;
	}

	public Matrix3D getmMat() {
		return mMat;
	}

	public void setmMat(Matrix3D mMat) {
		this.mMat = mMat;
	}

	public Matrix3D getvMat() {
		return vMat;
	}

	public void setvMat(Matrix3D vMat) {
		this.vMat = vMat;
	}
}
