//By Gunnar Jessee
//daApr 21, 2017
package gunnar.game.objects;

import org.joml.Vector2f;

import gunnar.game.utils.GameEntity;
import tek.render.Shader;
import tek.render.Texture;
import tek.render.TextureSheet;
import tek.runtime.physics.BoxCollider;

public class GameEntityGrass extends GameEntity
{
	
	@Override
	public void Start()
	{
		super.Start();
		texture = TextureSheet.getSheet("tiles").texture;
		subTexture = 1;
		tags = new String[1];
		tags[0] = "grass";	
		transform.setSize(16, 16);
		shader = Shader.get("default");
		collider = new BoxCollider(this, new Vector2f(16, 12));
	}
	
	@Override
	public void Update(long delta)
	{
		
		super.Update(delta);
	}
}
