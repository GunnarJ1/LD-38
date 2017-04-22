//By Gunnar Jessee
//daApr 21, 2017
package gunnar.game.objects;

import org.jbox2d.collision.shapes.CircleShape;
import org.jbox2d.dynamics.FixtureDef;
import org.joml.Vector2f;

import gunnar.game.utils.GameEntity;
import tek.input.Keyboard;
import tek.render.Shader;
import tek.render.TextureSheet;
import tek.runtime.GameObject;
import tek.runtime.Physics.CollisionCallback;
import tek.runtime.physics.BoxCollider;
import tek.runtime.physics.Collider;

public class GameEntityPlayer extends GameEntity {
	private int jumpSpeed = 10000;
	private boolean isJumping = true;
	private int speed = 45;

	
	// Physics
	private Vector2f point = new Vector2f(8, 0);
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
		setCollider(new BoxCollider(this, transform.getSize()));
		collider.setGravityScale(2);
		// Circle Collider
		CircleShape shape = new CircleShape();
		shape.m_p.set(0, 0);
		shape.setRadius(8);
		
		FixtureDef fixtureDef = new FixtureDef();
		fixtureDef.shape = shape;

		collider.body.createFixture(fixtureDef);
		
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
		System.out.println("Impulse: " + impulse.x + ", \t" + impulse.y);
		collider.applyLinearImpulse(impulse, point);

		super.Update(delta);
	}

	public void setInHand(GameEntity obj) {
		obj.transform.setParent(inHand);
	}

}