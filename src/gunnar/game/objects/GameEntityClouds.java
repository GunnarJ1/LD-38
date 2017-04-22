//By Gunnar Jessee
//daApr 22, 2017
package gunnar.game.objects;

import gunnar.game.utils.GameEntity;
import tek.render.Shader;
import tek.render.TextureSheet;

public class GameEntityClouds extends GameEntity
{

	@Override
	public void Start()
	{
		super.Start();
		transform.setSize(32, 16);
		texture = TextureSheet.getSheet("tiles").texture;
		subTexture = 3;
		shader = Shader.get("default");
	}
	
}
