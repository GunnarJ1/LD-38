//By Gunnar Jessee
//daApr 21, 2017
package gunnar.game.utils;

import org.joml.Vector2f;
import org.joml.Vector2i;
import org.joml.Vector3i;

import gunnar.game.MathUtils;
import gunnar.game.objects.GameEntityClouds;
import gunnar.game.objects.GameEntityGrass;
import gunnar.game.objects.GameEntityPlayer;
import gunnar.game.objects.GameEntityStar;
import tek.Util;
import tek.Util.TextureBuffer;
import tek.Window;
import tek.runtime.GameObject;
import tek.runtime.Scene;

public class LevelLoader
{

	private static Vector3i rgb;
	private static Vector2i xy;
	
	// Loads objects to scene
	public static void Temp()
	{
		GameObject player = new GameEntityPlayer();
		player.transform.setPosition(new Vector2f(16, 14));
		Scene.current.add(player);
		for (int i = 0; i < 13; i++)
		{
			GameObject temp = new GameEntityGrass();
			temp.transform.setPosition(i * 16, 0);
			Scene.current.add(temp);
		}

		for (int i = 0; i < 10; i++)
		{
			GameObject temp = new GameEntityClouds();
			temp.transform.setPosition(MathUtils.RandomRange(0, Window.defaultHeight - 32), MathUtils.RandomRange(64, Window.defaultHeight - 128));
			Scene.current.add(temp);
		}
//

		
		GameObject temp = new GameEntityStar(false);
		temp.transform.setPosition(32, 100);;
		Scene.current.add(temp);

	}

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

		TextureBuffer map = Util.getTextureBuffer("/levels/" + path + ".png");

		int width = map.width;
		int height = map.height;

		for (int x = 0; x < width; x++)
		{
			for (int y = 0; y < height; y++)
			{
				int alpha = map.getA(x, y);
				;
				int red = map.getR(x, y);
				;
				int green = map.getG(x, y);
				;
				int blue = map.getB(x, y);

				rgb.set(red, green, blue);
				xy.set(x, y);

				if (!(red == 0 && green == 0 && blue == 0) && alpha != 0)
				{
					// System.out.println(red);
					// System.out.println(green);
					// System.out.println(blue);
					// System.out.println("------------");

				}
				loadRules();
			}
		}

	}

	private static void loadRules()
	{
		if (rgb.x == 255 && rgb.y == 0)
		{
			GameEntityGrass wall = new GameEntityGrass();
			wall.transform.setPosition(xy.x * 16, xy.y * 16);
			Scene.current.gameObjects.add(wall);
			System.out.println(wall.transform.getPosition().x + ", \t" + wall.transform.getPosition().y);
		}
		//
		// if (rgb.x == 0 && rgb.y == 255 && rgb.z == 0)
		// {
		// GameEntityPlayer player = new GameEntityPlayer();
		// player.transform.setPosition(xy.x * 16, xy.y * 16);
		// Scene.current.gameObjects.add(player);
		// System.out.println(player.transform.getPosition().x + ", \t" +
		// player.transform.getPosition().y);
		// }
	}

}
