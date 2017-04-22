//By Gunnar Jessee
//daApr 21, 2017
package gunnar.game.objects;

import org.joml.Vector2f;

import gunnar.game.MathUtils;
import gunnar.game.utils.GameEntity;
import tek.input.Keyboard;
import tek.render.Shader;
import tek.render.TextureSheet;
import tek.runtime.Physics.CollisionCallback;
import tek.runtime.physics.BoxCollider;
import tek.runtime.physics.Collider;

public class GameEntityPlayer extends GameEntity
{

	public GameEntity hand;
	private int speed = 70;
	private float mx, my;

	public GameEntityPlayer()
	{
		super();

	}

	@Override
	public void Start()
	{

		texture = TextureSheet.getSheet("tiles").texture;
		subTexture = 2;
		addTag("player");
		transform.setSize(16f, 16f);
		shader = Shader.get("default");
		setCollider(new BoxCollider(this, transform.getSize()));
		
	}

	@Override
	public void Update(long delta)
	{

		double adjustedDelta = delta / 1000d; // 1s / delta time

		if (Keyboard.isDown('a'))
		{
			mx = MathUtils.lerp(mx, -1, .08f);
			;
		} else if (Keyboard.isDown('d'))
		{
			mx = MathUtils.lerp(mx, 1, .08f);
			;
		} else
		{
			mx = MathUtils.lerp(mx, 0, .3f);
		}

		collider.applyForce(new Vector2f(mx));
		super.Update(delta);

		collider.setCallback(new CollisionCallback() {

			@Override
			public void onCollisionExit(Collider collider)
			{
				if (collider.getParent().hasTag("star"))
				{
					setInHand((GameEntity) collider.getParent());
					System.out.println("Star");
				}
			}

			@Override
			public void onCollisionEnter(Collider collider)
			{
			}
		});

		if (Keyboard.isReleased(Keyboard.KEY_SPACE))
		{
			collider.applyForce(new Vector2f(0, 10));
		}

	}

	public void setInHand(GameEntity obj)
	{
		hand = obj;
		hand.transform.setParent(this);
		hand.transform.setPosition(0, 0);
		hand.collider = null;
	}

}
