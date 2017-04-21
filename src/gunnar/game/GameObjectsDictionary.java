//By Gunnar Jessee
//daApr 21, 2017
package gunnar.game;

import java.util.HashMap;

import gunnar.game.objects.GameObjectFloor;
import tek.runtime.GameObject;

public class GameObjectsDictionary
{

	private static HashMap<String, GameObject> map;

	// Initializes the map
	public static void init()
	{
		map = new HashMap<>();

		map.put("wall", new GameObjectFloor());
	}

	// Finds object with in map
	public static GameObject find(String key)
	{
		GameObject obj;
		if ((obj = map.get(key)) == null) {
			System.err.println("No object find under: " + key);
		}
		return obj;
	}
	
	// Puts object in dictionary
	public static void put(String key, GameObject object)
	{
		map.put(key, object);
	}

}
