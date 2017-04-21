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
import tek.Util;
import tek.Util.TextureBuffer;
import tek.render.Texture;
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

		TextureBuffer map = Util.getTextureBuffer("/levels/" + path + ".png");

		int width = map.width;
		int height = map.height;
		byte[] colorMapData = map.pixels;
		
		for (int x = 0; x < width; x++)
		{
			for (int y = 0; y < height; y++)
			{
				int alpha = (((colorMapData[y + x * width]) >> 24) & 0xFF);
				int red = ((colorMapData[y + x * width]) >> 16) & 0xFF;
				int green = ((colorMapData[y + x * width]) >> 8) & 0xFF;
				int blue = ((colorMapData[y + x * width])) & 0xFF;
				rgb.set(red, green, blue);
				xy.set(width - x, y);
				
//				if (!(red == 0 && green == 0 && blue == 0) && alpha != 0)
//				{
//					System.out.println(red);
//					System.out.println(green);
//					System.out.println(blue);
//					System.out.println("------------");
//				
//				}
				loadRules();
			}
		}

	}

	private static void loadRules()
	{
		if (rgb.x == 255 && rgb.y == 0 && rgb.z == 0)
		{
			GameObjectWall wall = new GameObjectWall();
			wall.transform.setPosition(xy.x * 16, xy.y * 16);
			Scene.current.gameObjects.add(wall);
			System.out.println(wall.transform.getPosition().x + ", \t" + wall.transform.getPosition().y);
		}

		if (rgb.x == 0 && rgb.y == 255 && rgb.z == 0)
		{
			GameEntityPlayer player = new GameEntityPlayer();
			player.transform.setPosition(xy.x * 16, xy.y * 16);
			Scene.current.gameObjects.add(player);
			System.out.println(player.transform.getPosition().x + ", \t" + player.transform.getPosition().y);
		}
	}

}
