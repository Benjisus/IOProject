package io.View;

import io.Controller.IoController;

import javax.swing.JFrame;
/**
 * Frame for the IO Project.
 * @author Ben Hammond
 *@version 1.0 13/12/2013
 */
public class IoFrame extends JFrame
{
	private IoController baseController;
	private IoPanel basePanel;
	/**
	 * Contructor for IoFrame
	 * @param baseController baseController IoController passed in for MVC relationship
	 */
	public IoFrame(IoController baseController)
	{
		this.baseController = baseController;
		basePanel = new IoPanel(baseController);
		
		setupFrame();
	}
	
	/**
	 * Sets up the frame size and loads the content panel.
	 */
	
	private void setupFrame()
	{
		this.setContentPane(basePanel);
		this.setSize(500,500);
		this.setVisible(true);
		
	}
}
