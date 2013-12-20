package io.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import io.Controller.IoController;
import io.Model.Game;

import javax.swing.*;

public class IoPanel extends JPanel
{
	private IoController baseController;
	private JButton saveButton;
	private JTextField titleField;
	private JTextField rankingField;
	private JTextArea rulesArea;
	private JLabel rulesLabel;
	private JLabel rankingLabel;
	private JLabel titleLabel;
	private SpringLayout baseLayout;
	private JButton loadButton;
	
	
	public IoPanel(IoController baseController)
	{
		this.baseController = baseController;
		
		saveButton = new JButton("Save game Info");
		loadButton = new JButton("Load saved game info");
		titleField = new JTextField(15);
		titleLabel = new JLabel("Game Title: ");
		rankingField = new JTextField(5);
		rankingLabel = new JLabel("Game Ranking");
		rulesArea = new JTextArea(5, 20);
		rulesLabel = new JLabel("Game Rules:");
		baseLayout = new SpringLayout();
		
		
		
		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.add(rankingField);
		this.add(rankingLabel);
		this.add(rulesArea);
		this.add(rulesLabel);
		this.add(saveButton);
		this.add(titleField);
		this.add(titleLabel);
		this.add(loadButton);
	}
	
	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.NORTH, titleLabel, 23, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.NORTH, titleField, -3, SpringLayout.NORTH, titleLabel);
		baseLayout.putConstraint(SpringLayout.WEST, titleField, 0, SpringLayout.WEST, rankingField);
		baseLayout.putConstraint(SpringLayout.NORTH, rankingLabel, 33, SpringLayout.SOUTH, titleLabel);
		baseLayout.putConstraint(SpringLayout.NORTH, rankingField, -3, SpringLayout.NORTH, rankingLabel);
		baseLayout.putConstraint(SpringLayout.WEST, rankingField, 17, SpringLayout.EAST, rankingLabel);
		baseLayout.putConstraint(SpringLayout.WEST, titleLabel, 0, SpringLayout.WEST, rankingLabel);
		baseLayout.putConstraint(SpringLayout.WEST, rankingLabel, 2, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, rulesLabel, 32, SpringLayout.SOUTH, rankingLabel);
		baseLayout.putConstraint(SpringLayout.WEST, rulesLabel, 0, SpringLayout.WEST, rankingLabel);
		baseLayout.putConstraint(SpringLayout.NORTH, saveButton, 39, SpringLayout.SOUTH, rulesArea);
		baseLayout.putConstraint(SpringLayout.NORTH, rulesArea, -5, SpringLayout.NORTH, rulesLabel);
		baseLayout.putConstraint(SpringLayout.WEST, rulesArea, 26, SpringLayout.EAST, rulesLabel);
		baseLayout.putConstraint(SpringLayout.NORTH, loadButton, 0, SpringLayout.NORTH, saveButton);
		baseLayout.putConstraint(SpringLayout.WEST, loadButton, 42, SpringLayout.EAST, saveButton);
		baseLayout.putConstraint(SpringLayout.WEST, saveButton, 10, SpringLayout.WEST, this);

	}
	
	private void setupListeners()
	{
		saveButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				Game tempGame = baseController.makeGameFromInput(titleField.getText(), rankingField.getText(), rulesArea.getText());
				if (tempGame !=null)
				{
					baseController.saveGameInformation(tempGame);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Sorry try again!");
				}
			}
		});
		
		loadButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				Game tempGame = baseController.readGameInformation();
				if(tempGame != null)
				{
					titleField.setText(tempGame.getGameTitle());
					rankingField.setText(Integer.toString(tempGame.getFunRanking()));
					String tempRules = "";
					for(String currentRule : tempGame.getGameRules() )
					{
						tempRules += currentRule + "\n";
					}
					rulesArea.setText(tempRules);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Check the save file, make sure its in order!");
				}
			}
		});
		
	}

}


