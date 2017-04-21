//By Gunnar Jessee
//daApr 21, 2017
package gunnar.game;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class LevelFlipTest
{

	public static void main(String[] args)
	{
		
		BufferedImage image = new BufferedImage(128, 128, BufferedImage.TYPE_INT_RGB);
		
		try
		{
			BufferedImage map = ImageIO.read(new File("res/levels/" + "level0" + ".png"));

			int width = map.getWidth();
			int height = map.getHeight();

			int[] colorMapData = map.getRGB(0, 0, width, height, null, 0, width);

			for (int x = 0; x < width; x++)
			{
				for (int y = height - 1; y > 0; y--)
				{
					int red = ((colorMapData[y + x]) >> 16) & 0xFF;
					int green = ((colorMapData[y + x * width]) >> 8) & 0xFF;
					int blue = ((colorMapData[y + x * width])) & 0xFF;
//					image.setRGB(x, y, map.getRGB(0, 0, width, height, null, 0, width)[colorMapData y ]);
					
				}
			}

		} catch (IOException e)
		{

			e.printStackTrace();
		}
	}

	
	
}
