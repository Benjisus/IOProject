package io.Model;

import java.util.ArrayList;

/**
 * The Game superClass for the IO project.
 * @author Ben Hammond
 * 1.0 13/12/2013 Added data members, constructor and default play method.
 */
public class Game
{

	private ArrayList<String> gameRules;
	private int funRanking;
	private String gameTitle;
	/**
	 * Is setting what will be inside of the game.
	 */
	public Game()
	{
		gameRules = new ArrayList<String>();
		funRanking = 0;
		gameTitle = "";
	}
	/**
	 * Defining the actually game items.
	 * @param gameRules
	 * @param funRanking
	 * @param title
	 */
	public Game(ArrayList<String> gameRules, int funRanking, String title)
	{
		this.gameRules = gameRules;
		this.funRanking = funRanking;
		this.gameTitle = gameTitle;
	}
	/**
	 * Getter for GameRules.
	 * @return
	 */
	public ArrayList<String> getGameRules()
	{
		return gameRules;
	}
	/**
	 * Getter for FunRanking.
	 * @return
	 */
	public int getFunRanking()
	{
		return funRanking;
	}
	/**
	 * Getter for GameTitle.
	 * @return
	 */
	public String getGameTitle()
	{
		return gameTitle;
	}
	/**
	 * Setter for GameRules.
	 * @param gameRules
	 */
	public void setGameRules(ArrayList<String> gameRules)
	{
		this.gameRules = gameRules;
	}
	/**
	 * Setter for FunRanking.
	 * @param funRanking
	 */
	public void setFunRanking(int funRanking)
	{
		this.funRanking = funRanking;
	}
	/**
	 * Setter for GameTitle.
	 * @param gameTitle
	 */
	public void setGameTitle(String gameTitle)
	{
		this.gameTitle = gameTitle;
	}

	
	public void play()
	{
		
	}
}
