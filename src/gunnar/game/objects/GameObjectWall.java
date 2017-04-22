//By Gunnar Jessee
//daApr 21, 2017
package gunnar.game.objects;

import gunnar.game.utils.GameEntity;
import tek.render.Texture;
import tek.render.TextureSheet;

public class GameObjectWall extends GameEntity
{

	TextureSheet sheet;

	public GameObjectWall()
	{
		super();

	}
	
	@Override
	public void Start()
	{
//		sheet = new TextureSheet(new Texture("textures/texsheet.png"), 16, 16, "test");
//		texture = sheet.texture;
//		subTexture = 128;
//		tags = new String[1];
//		tags[0] = "wall";	transform.setSize(16f, 16f);
	}

	@Override
	public void Update(long delta)
	{
	}
	
}
