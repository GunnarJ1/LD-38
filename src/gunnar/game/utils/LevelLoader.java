//By Gunnar Jessee
//daApr 21, 2017
package gunnar.game.utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.joml.Vector2i;
import org.joml.Vector3i;

import gunnar.game.GameEntityDictionary;
import tek.runtime.GameObject;
import tek.runtime.Scene;

public class LevelLoader
{

	private static Vector3i rgb;
	private static Vector2i xy;

	public static void LoadLevel(String path)
	{
		if (rgb == null)
		{
			rgb = new Vector3i();
		}

		if (xy == null)
		{
			xy = new Vector2i();
		}

		try
		{
			BufferedImage map = ImageIO.read(new File("res/levels/" + path + ".png"));

			int width = map.getWidth();
			int height = map.getHeight();

			int[] colorMapData = map.getRGB(0, 0, width, height, null, 0, width);

			for (int y = 0; y < height; y++)
			{
				for (int x = 0; x < width; x++)
				{
					int red = ((colorMapData[x + y * width]) >> 16) & 0xFF;
					int green = ((colorMapData[x + y * width]) >> 8) & 0xFF;
					int blue = ((colorMapData[x + y * width])) & 0xFF;
					rgb.set(red, green, blue);
					xy.set(x, y);

					LoadGameObject(255, 0, 0, "wall");
				}
			}

		} catch (IOException e)
		{

			e.printStackTrace();
		}

	}

	// Adds a rule type of loading a game object
	private static void LoadGameObject(int r, int g, int b, String objectName)
	{
		GameObject object = null;

		if (rgb.x == r && rgb.y == g && rgb.z == b)
		{
			object = new GameEntity(GameEntityDictionary.find("wall"));
			object.transform.setPosition(xy.x * 16, xy.y * 16);
			System.out.println(object.transform.getPosition().x + ", " + object.transform.getPosition().y);
		}

		// Finds the object
		if (object != null)
			Scene.current.gameObjects.add(object);

	}

}
