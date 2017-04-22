//By Gunnar Jessee
//daApr 21, 2017
package gunnar.game.objects;

import gunnar.game.utils.GameEntity;
import tek.render.Texture;

public class GameEntityGrass extends GameEntity
{
	
	@Override
	public void Start()
	{

		texture = Texture.get("textures/grass.png");
		tags = new String[1];
		tags[0] = "grass";	
		transform.setSize(10000f, 10000f);
	}
	
	
}
