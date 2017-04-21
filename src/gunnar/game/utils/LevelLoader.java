//By Gunnar Jessee
//daApr 21, 2017
package gunnar.game.utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.joml.Vector2i;
import org.joml.Vector3i;

import gunnar.game.objects.GameEntityPlayer;
import gunnar.game.objects.GameObjectWall;
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

			for (int x = 0; x < width; x++)
			{
				for (int y = height - 1; y > 0; y--)
				{
					int red = ((colorMapData[y + x * width]) >> 16) & 0xFF;
					int green = ((colorMapData[y + x * width]) >> 8) & 0xFF;
					int blue = ((colorMapData[y + x * width])) & 0xFF;
					rgb.set(red, green, blue);
					xy.set(y, x);

					loadRules();
				}
			}

		} catch (IOException e)
		{

			e.printStackTrace();
		}
	}

	private static void loadRules() {
		if (rgb.x == 255 && rgb.y == 0 && rgb.z == 0) {
//			Scene.current.add(new GameObjectWall());
		}
		if (rgb.x == 0 && rgb.y == 255 && rgb.z == 0) {
			GameEntityPlayer player = new GameEntityPlayer();
			player.transform.setPosition(xy.x * 16, xy.y * 16);
			Scene.current.add(new GameEntityPlayer());
			System.out.println(player.transform.getPosition().x + ",\t" + player.transform.getPosition().y);
		}
	}
	
	
}
