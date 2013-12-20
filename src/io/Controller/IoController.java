package io.Controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

import io.Model.Game;
import io.View.IoFrame;
/**
 * Controller class for IO projects.
 * @author Ben Hammond
 *@version 1.0 13/12/2013 Added start method.
 */

public class IoController
{
	private IoFrame appFrame;
	
	public IoController()
	{
		
	}

	public void start()
	{
		appFrame = new IoFrame(this);
	}
	
	public Game readGameInformation()
	{
		String fileName = "save file.txt"; //Without a path it will look to the directory of the project!
		File currentSaveFile = new File(fileName);
		Game currentGame = null;
		Scanner fileReader;
		int gameRanking = 0;
		String gameTitle = "";
		ArrayList<String> gameRules = new ArrayList<String>();
		
		try 
		{
			fileReader = new Scanner(currentSaveFile);
			gameTitle = fileReader.nextLine();
			gameRanking = fileReader.nextInt();
			while(fileReader.hasNext())
			{
				gameRules.add(fileReader.nextLine());
			}
			
			currentGame = new Game(gameRules, gameRanking, gameTitle);
			/**
			 * Major Scanner methods!!!!
			 * .next() - the next string separated by the whitespace so if the file had " twas brillia and the slithey... " .next() would return twas.
			 * .nextLine() returns an entire line of text.
			 * .nextInt() returns the integer value.
			 * .nextBoolean() returns the next boolean value. 
			 * .nextDouble() the next double value.
			 * 
			 */
			fileReader.close();
		}
		catch(FileNotFoundException currentFileDoesNotExist)
		{
			JOptionPane.showMessageDialog(appFrame, currentFileDoesNotExist.getMessage());
		}
		return currentGame;
	}
	
	public Game makeGameFromInput(String gameTitle, String gameRanking, String gameRules)
	{
		Game currentGame = new Game();
		currentGame.setGameTitle(gameTitle);
		
		if(checkNumberFormat(gameRanking))
		{
			currentGame.setFunRanking(Integer.parseInt(gameRanking));
		}
		else
		{
			return null;
		}
		
		String[] temp = gameRules.split("\n");
		ArrayList<String> tempRules = new ArrayList<String>();
		
		for(String tempWord : temp)
		{
			tempRules.add(tempWord);
		}
		currentGame.setGameRules(tempRules);
		
		return currentGame;
	}
	public void saveGameInformation(Game currentGame)
	{
		PrintWriter gameWriter;
		String saveFile = "save file.txt";
		try
		{
			gameWriter = new PrintWriter(saveFile); //Creates the save file.
			
			gameWriter.println(currentGame.getGameTitle());
			gameWriter.println(currentGame.getFunRanking());
			for(int count = 0; count < currentGame.getGameRules().size(); count++)
			{
				gameWriter.println(currentGame.getGameRules().get(count));
			}
			
			
			gameWriter.close(); //Required to prevent corruption of data and maintain security of the file.
		}
		catch(FileNotFoundException noFileExists)
		{
			JOptionPane.showMessageDialog(appFrame, "Could not create the save file. :(");
			JOptionPane.showMessageDialog(appFrame, noFileExists.getMessage());
		}
	}
	private boolean checkNumberFormat(String toBeParsed)
	{
		boolean isNumber = false;
		try
		{
			int valid = Integer.parseInt(toBeParsed);
			isNumber = true;
		}
		catch (NumberFormatException error)
		
		{
			JOptionPane.showMessageDialog(appFrame, "Please try again with an actual number.");
		}
		return isNumber;
	}
	
	

}
