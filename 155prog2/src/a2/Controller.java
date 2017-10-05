package a2;

import java.awt.BorderLayout;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import com.jogamp.opengl.util.FPSAnimator;

@SuppressWarnings("serial")
public class Controller extends JFrame {
	private Model myModel;
	private View view;

	
	
	public Controller() {
		myModel = new Model();
		view = new View(myModel);

		
		//belongs to the JFrame
		setTitle("Assignment 2");
		setSize(800, 800);
		
		myModel.getMyCanvas().addGLEventListener(view);
		this.add(myModel.getMyCanvas());
		
		
		//create the interfaces
		JPanel cPanel = new JPanel();
		this.add(cPanel, BorderLayout.CENTER);
		int mapName = JComponent.WHEN_IN_FOCUSED_WINDOW;
		InputMap imap = cPanel.getInputMap(mapName);
		KeyStroke cKey = KeyStroke.getKeyStroke('c');
		imap.put(cKey, "color");
		ActionMap amap = cPanel.getActionMap();
//		amap.put("color", myModel.getColorCom());
		this.requestFocus();
		
		
		//responsible for the animation
		FPSAnimator animator = new FPSAnimator(myModel.getMyCanvas(), 30);
		animator.start();
		setVisible(true);
	}
}