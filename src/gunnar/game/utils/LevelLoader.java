//By Gunnar Jessee
//daApr 21, 2017
package gunnar.game.utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class LevelLoader
{

	public static void LoadLevel(String path) {
		
		try
		{
			BufferedImage map = ImageIO.read(new File("/levels" + path + ".png"));
			
			int width = map.getWidth();
			int height = map.getHeight();
			
			int[] colorMapData = map.getRGB(0, 0, width, height, null, 0, width);
			
			for (int y = 0; y < height; y++)
			{
				for (int x = 0; x < width; x++)
				{
					int red = (colorMapData[x + y * width] << 16) & 0xFF;
					int green = (colorMapData[x + y * width] << 4)  & 0xFF;
					int blue= (colorMapData[x + y * width]) & 0xFF;
					
					
				}	
			}
			
			
		} catch (IOException e)
		{
			
			e.printStackTrace();
		}
		
	}
	
}
