//By Gunnar Jessee
//daApr 21, 2017
package gunnar.game.objects;

import gunnar.game.utils.GameEntity;
import tek.render.Camera;
import tek.render.Texture;
import tek.render.TextureSheet;
import tek.runtime.Scene;

public class GameEntityPlayer extends GameEntity
{

	private TextureSheet sheet;
	private Camera camera;
	
	public GameEntityPlayer()
	{
		super();
		
	}
	
	@Override
	public void Start()
	{
		sheet = new TextureSheet(new Texture("textures/texsheet.png"), 16, 16, "test");
		texture = sheet.texture;
		subTexture = 0;
		camera = Scene.current.camera;
		tags = new String[1];
		tags[0] = "player";
		transform.setSize(16f, 16f);
	}
	
	@Override
	public void update(long delta)
	{
	
		
		super.update(delta);
	}
	
}
