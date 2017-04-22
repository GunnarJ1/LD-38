//By Gunnar Jessee
//daApr 22, 2017
package gunnar.game;

import java.util.Random;

public class MathUtils
{

	public static float lerp(float a, float b, float interpolation) {
		return a + interpolation * (b - a);
	}
	
	private static Random random = new Random();
	
	public static float RandomRange(float min, float max) {
		float randomNum = (random.nextFloat() * (max - min) + 1) + min;
		return randomNum;
	}
	
}
