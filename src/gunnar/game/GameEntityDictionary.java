//By Gunnar Jessee
//daApr 21, 2017
package gunnar.game;

import java.util.HashMap;

import gunnar.game.objects.GameObjectFloor;
import gunnar.game.utils.GameEntity;

public class GameEntityDictionary
{

	private static HashMap<String, GameEntity> map;

	// Initializes the map
	public static void init()
	{
		map = new HashMap<>();

		map.put("wall", new GameObjectFloor());
	}

	// Finds object with in map
	public static GameEntity find(String key)
	{
		GameEntity obj;
		if ((obj = map.get(key)) == null) {
			System.err.println("No object find under: " + key);
		}
		return obj;
	}
	
	// Puts object in dictionary
	public static void put(String key, GameEntity object)
	{
		map.put(key, object);
	}

}
