//By Gunnar Jessee
//daApr 21, 2017
package gunnar.game.objects;

import tek.render.Texture;
import tek.render.TextureSheet;
import tek.runtime.GameObject;

public class GameObjectFloor extends GameObject
{

	TextureSheet sheet;
	
	@Override
	public void Start()
	{
		sheet = new TextureSheet(new Texture("textures/texsheet.png"), 16, 16, "test");
		texture = sheet.texture;
		subTexture = 120;
	}

	@Override
	public void Update(long delta)
	{
	}
	
}
