//By Gunnar Jessee
//daApr 21, 2017
package gunnar.game.objects;

import org.joml.Vector2f;

import gunnar.game.utils.GameEntity;
import tek.render.Shader;
import tek.render.TextureSheet;
import tek.runtime.physics.BoxCollider;
import tek.runtime.physics.Collider.ColliderType;

public class GameEntityGrass extends GameEntity
{

	@Override
	public void Start()
	{
		super.Start();
		texture = TextureSheet.getSheet("tiles").texture;
		subTexture = 1;
		addTag("grass");
		addTag("ground");
		transform.setSize(16, 16);
		shader = Shader.get("default");
		Vector2f boxSize = new Vector2f(transform.getSize());
		boxSize.y = 11;
		setCollider(new BoxCollider(this, boxSize));
		collider.setColliderType(ColliderType.STATIC);
		
	}

	@Override
	public void Update(long delta)
	{

		super.Update(delta);
	}
}
