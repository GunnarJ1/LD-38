//By Gunnar Jessee
//daApr 21, 2017
package gunnar.game.objects;

import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.FixtureDef;
import org.joml.Vector2f;

import gunnar.game.utils.GameEntity;
import tek.input.Keyboard;
import tek.render.Shader;
import tek.render.TextureSheet;
import tek.runtime.GameObject;
import tek.runtime.Physics.CollisionCallback;
import tek.runtime.physics.CircleCollider;
import tek.runtime.physics.Collider;

public class GameEntityPlayer extends GameEntity {
	private int jumpSpeed = 100 * 9000;
	private boolean isJumping = true;
	private int speed = 45;

	
	// Physics
	private Vector2f impulse;
	private GameObject inHand;

	public GameEntityPlayer() {
		super();

	}

	@Override
	public void Start() {
		inHand = new GameEntity();
		texture = TextureSheet.getSheet("tiles").texture;
		subTexture = 2;
		tags = new String[1];
		tags[0] = "player";
		transform.setSize(16f, 16f);
		shader = Shader.get("default");
		
		// Physics
		setCollider(new CircleCollider(this, 8));
		FixtureDef boxFixture = new FixtureDef();
		PolygonShape box = new PolygonShape();
		box.setAsBox(16, 8, new Vec2(8, 10), 0);
		boxFixture.shape = box;
		boxFixture.restitution = 0.0f;
		collider.body.createFixture(boxFixture);
		
	}

	@Override
	public void Update(long delta) {
		impulse = new Vector2f(0, 0);
		
		if (Keyboard.isDown('a')) {
			impulse.x = -speed;
		} else if (Keyboard.isDown('d')) {
			impulse.x = speed;
		} else {
			impulse.x = 0;
		}
		
		if (Keyboard.isClicked(Keyboard.KEY_SPACE) && isJumping) {
			impulse.y = jumpSpeed;
			isJumping = false;
		}
		collider.setCallback(new CollisionCallback() {

			@Override
			public void onCollisionExit(Collider collider) {
				if (collider.getParent().hasTag("ground")) {
					if (!isJumping) {
						isJumping = true;

					}
				}
			}
			
			@Override
			public void onCollisionEnter(Collider collider) {
				
			}
		});
		collider.setVelocity(impulse.lerp(collider.getVelocity(), .1f));
		super.Update(delta);
	}

	public void setInHand(GameEntity obj) {
		obj.transform.setParent(inHand);
	}

}