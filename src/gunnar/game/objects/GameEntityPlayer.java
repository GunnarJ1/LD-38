//By Gunnar Jessee
//daApr 21, 2017
package gunnar.game.objects;

import gunnar.game.utils.GameEntity;
import tek.render.Camera;
import tek.render.Shader;
import tek.render.Texture;
import tek.render.TextureSheet;
import tek.runtime.Scene;
import tek.runtime.physics.BoxCollider;

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

		texture = TextureSheet.getSheet("tiles").texture;
		subTexture = 2;
		camera = Scene.current.camera;
		tags = new String[1];
		tags[0] = "player";
		transform.setSize(16f, 16f);
		shader = Shader.get("default");
		collider = new BoxCollider(this, transform.getSize());
	}
	
	@Override
	public void Update(long delta)
	{
		super.Update(delta);
	}
}
