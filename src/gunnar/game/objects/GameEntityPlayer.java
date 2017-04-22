//By Gunnar Jessee
//daApr 21, 2017
package gunnar.game.objects;

import org.joml.Vector2f;

import gunnar.game.utils.GameEntity;
import tek.input.Keyboard;
import tek.render.Shader;
import tek.render.TextureSheet;
import tek.runtime.physics.BoxCollider;

public class GameEntityPlayer extends GameEntity
{

	private int speed = 40;

	public GameEntityPlayer()
	{
		super();

	}

	@Override
	public void Start()
	{

		texture = TextureSheet.getSheet("tiles").texture;
		subTexture = 2;
		tags = new String[1];
		tags[0] = "player";
		transform.setSize(16f, 16f);
		shader = Shader.get("default");
		collider = new BoxCollider(this, transform.getSize());
	}

	@Override
	public void Update(long delta)
	{

		double adjustedDelta = delta / 1000d; // 1s / delta time

		float mx = 0, my = 0;
		if (Keyboard.isDown('a'))
		{
			mx = -1;
		} else if (Keyboard.isDown('d'))
		{
			mx = 1;
		}


		transform.move((float) (mx * speed * adjustedDelta), (float) (my * speed * adjustedDelta));
		super.Update(delta);
	}
}
