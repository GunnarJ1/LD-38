//By Gunnar Jessee
//daApr 21, 2017
package gunnar.game.utils;

import tek.runtime.GameObject;

public class GameEntity extends GameObject
{

	
	public GameEntity()
	{
		super();
	}
	
	/**
	 * 
	 * @param gameobject
	 */
	public GameEntity(GameEntity game) {
		super(game);
	}
	
	@Override
	public void Start()
	{
	}

	@Override
	public void Update(long delta)
	{
	}

}
