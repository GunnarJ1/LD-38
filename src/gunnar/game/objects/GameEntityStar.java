//By Gunnar Jessee
//daApr 22, 2017
package gunnar.game.objects;

import gunnar.game.MathUtils;
import gunnar.game.utils.GameEntity;
import tek.render.Shader;
import tek.render.TextureSheet;
import tek.runtime.physics.BoxCollider;
import tek.runtime.physics.Collider.ColliderType;

public class GameEntityStar extends GameEntity
{
//	private Vector2f wiggle;

	int fallingSpeed = 80;

	@Override
	public void Start()
	{
		super.Start();
		texture = TextureSheet.getSheet("tiles").texture;
		subTexture = 0;
		float size = MathUtils.RandomRange(4f, 8f);
		transform.setSize(size, size);
		shader = Shader.get("default");
		addTag("star");
//		setCollider(new BoxCollider(this, transform.getSize()));;
//		collider.setColliderType(ColliderType.KINEMATIC);

	}

}
