//By Gunnar Jessee
//daApr 22, 2017
package tek.game;

public class MathUtils
{

	public static float lerp(float a, float b, float interpolation) {
		return a + interpolation * (b - a);
	}
	
}
