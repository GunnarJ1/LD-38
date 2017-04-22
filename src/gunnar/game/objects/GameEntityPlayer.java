//By Gunnar Jessee
//daApr 21, 2017
package gunnar.game.objects;

import java.util.Vector;

import org.joml.Vector2f;
import org.lwjgl.system.MathUtil;

import com.sun.xml.internal.ws.protocol.soap.VersionMismatchException;

import gunnar.game.utils.GameEntity;
import tek.game.MathUtils;
import tek.input.Keyboard;
import tek.render.Shader;
import tek.render.TextureSheet;
import tek.runtime.physics.BoxCollider;

public class GameEntityPlayer extends GameEntity
{
	
	private int speed = 45;
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

		
		if (Keyboard.isDown('a'))
		{
			mx = MathUtils.lerp(mx, -1, .08f);;
		} else if (Keyboard.isDown('d'))
		{
			mx = MathUtils.lerp(mx, 1, .08f);;
		} else {
			mx = MathUtils.lerp(mx, 0, .3f);
		}

		transform.move((float) (mx * speed * adjustedDelta), (float) (my * speed * adjustedDelta));
		super.Update(delta);
	}
}
