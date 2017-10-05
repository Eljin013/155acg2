package a2;

import java.nio.FloatBuffer;
import com.jogamp.common.nio.Buffers;

import static com.jogamp.opengl.GL.GL_NO_ERROR;
import static com.jogamp.opengl.GL.GL_TRIANGLES;
import static com.jogamp.opengl.GL.GL_VERSION;
import static com.jogamp.opengl.GL2ES2.GL_COMPILE_STATUS;
import static com.jogamp.opengl.GL2ES2.GL_FRAGMENT_SHADER;
import static com.jogamp.opengl.GL2ES2.GL_INFO_LOG_LENGTH;
import static com.jogamp.opengl.GL2ES2.GL_LINK_STATUS;
import static com.jogamp.opengl.GL2ES2.GL_VERTEX_SHADER;
import static com.jogamp.opengl.GL2ES3.GL_COLOR;

import com.jogamp.opengl.GL4;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLContext;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.glu.GLU;
import graphicslib3D.*;

@SuppressWarnings("serial")
public class View extends GLCanvas implements GLEventListener {
	private Model myModel;
	private int rendering_program;
	private int vao[] = new int[1];

	//private GLSLUtils util = new GLSLUtils();
	
	
	public View(Model model) {
		this.myModel = model;

	}
	
	@Override
	public void display(GLAutoDrawable arg0) {
		GL4 gl = (GL4) GLContext.getCurrentGL();
		gl.glUseProgram(rendering_program);
		
		float bkg[] = { 0.0f, 0.0f, 0.0f, 1.0f };
		FloatBuffer bkgBuffer = Buffers.newDirectFloatBuffer(bkg);
		gl.glClearBufferfv(GL_COLOR, 0, bkgBuffer);
		

		gl.glDrawArrays(GL_TRIANGLES,0,3);
	}

	@Override
	public void init(GLAutoDrawable arg0) {
		GL4 gl = (GL4) GLContext.getCurrentGL();
		
		//Print out the versions
		System.out.println("OpenGL Version\t: " + gl.glGetString(GL_VERSION));
		System.out.println("JOGL Version\t: " + 
				Package.getPackage("com.jogamp.opengl").getImplementationVersion());
		System.out.println("Java Version\t: " + System.getProperty("java.version"));
		
		//creates the rendering program
		rendering_program = createShaderProgram();
		
		//
		gl.glGenVertexArrays(vao.length, vao, 0);
		gl.glBindVertexArray(vao[0]);
	}

	@Override
	public void reshape(GLAutoDrawable arg0, int arg1, int arg2, int arg3, int arg4) {
				
	}
	
	@Override
	public void dispose(GLAutoDrawable arg0) {
		
	}

	private int createShaderProgram()
	{	GL4 gl = (GL4) GLContext.getCurrentGL();
		int[] vertCompiled = new int[1];
		int[] fragCompiled = new int[1];
		int[] linked = new int[1];
	

		String vshaderSource[] = GLSLUtils.readShaderSource("a1/shaderfiles/vert.shader");
		String fshaderSource[] = GLSLUtils.readShaderSource("a1/shaderfiles/frag.shader");
		int lengths[];

		int vShader = gl.glCreateShader(GL_VERTEX_SHADER);
		gl.glShaderSource(vShader, vshaderSource.length, vshaderSource, null, 0);
		gl.glCompileShader(vShader);		
		
		checkOpenGLError();  // can use returned boolean if desired
		gl.glGetShaderiv(vShader, GL_COMPILE_STATUS, vertCompiled, 0);
		if (vertCompiled[0] == 1)
		{	System.out.println("Vertex compilation success.");
		} else
		{	System.out.println("Vertex compilation failed.");
			printShaderLog(vShader);
		}
		
		int fShader = gl.glCreateShader(GL_FRAGMENT_SHADER);
		gl.glShaderSource(fShader, fshaderSource.length, fshaderSource, null, 0);
		gl.glCompileShader(fShader);		
		
		checkOpenGLError();  // can use returned boolean if desired
		gl.glGetShaderiv(fShader, GL_COMPILE_STATUS, fragCompiled, 0);
		if (fragCompiled[0] == 1)
		{	System.out.println("Fragment compilation success.");
		} else
		{	System.out.println("Fragment compilation failed.");
			printShaderLog(fShader);
		}
		
		int vfprogram = gl.glCreateProgram();
		gl.glAttachShader(vfprogram, vShader);
		gl.glAttachShader(vfprogram, fShader);
		gl.glLinkProgram(vfprogram);
		
		gl.glLinkProgram(vfprogram);
		checkOpenGLError();
		gl.glGetProgramiv(vfprogram, GL_LINK_STATUS, linked, 0);
		if (linked[0] == 1)
		{	System.out.println("Linking succeeded.");
		} else
		{	System.out.println("Linking failed.");
			printProgramLog(vfprogram);
		}
		
		gl.glDeleteShader(vShader);
		gl.glDeleteShader(fShader);
		return vfprogram;
	}
	
	private void printShaderLog(int shader)
	{	GL4 gl = (GL4) GLContext.getCurrentGL();
		int[] len = new int[1];
		int[] chWrittn = new int[1];
		byte[] log = null;

		// determine the length of the shader compilation log
		gl.glGetShaderiv(shader, GL_INFO_LOG_LENGTH, len, 0);
		if (len[0] > 0)
		{	log = new byte[len[0]];
			gl.glGetShaderInfoLog(shader, len[0], chWrittn, 0, log, 0);
			System.out.println("Shader Info Log: ");
			for (int i = 0; i < log.length; i++)
			{	System.out.print((char) log[i]);
			}
		}
	}

	void printProgramLog(int prog)
	{	GL4 gl = (GL4) GLContext.getCurrentGL();
		int[] len = new int[1];
		int[] chWrittn = new int[1];
		byte[] log = null;

		// determine length of the program compilation log
		gl.glGetProgramiv(prog, GL_INFO_LOG_LENGTH, len, 0);
		if (len[0] > 0)
		{	log = new byte[len[0]];
			gl.glGetProgramInfoLog(prog, len[0], chWrittn, 0, log, 0);
			System.out.println("Program Info Log: ");
			for (int i = 0; i < log.length; i++)
			{	System.out.print((char) log[i]);
			}
		}
	}

	boolean checkOpenGLError()
	{	GL4 gl = (GL4) GLContext.getCurrentGL();
		boolean foundError = false;
		GLU glu = new GLU();
		int glErr = gl.glGetError();
		while (glErr != GL_NO_ERROR)
		{	System.err.println("glError: " + glu.gluErrorString(glErr));
			foundError = true;
			glErr = gl.glGetError();
		}
		return foundError;
	}
}