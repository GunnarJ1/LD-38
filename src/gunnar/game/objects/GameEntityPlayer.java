//By Gunnar Jessee
//daApr 21, 2017
package gunnar.game.objects;

import java.util.ArrayList;
import java.util.List;

import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.FixtureDef;
import org.joml.Vector2f;

import gunnar.game.MathUtils;
import gunnar.game.utils.GameEntity;
import tek.input.Keyboard;
import tek.render.Animation;
import tek.render.Shader;
import tek.render.TextureSheet;
import tek.runtime.Physics.CollisionCallback;
import tek.runtime.Scene;
import tek.runtime.physics.CircleCollider;
import tek.runtime.physics.Collider;

public class GameEntityPlayer extends GameEntity {
	private boolean emptyHanded = true;
	private boolean isJumping = true;
	private int speed = 45;


	public GameEntityPlayer() {
		super();

	}

	@Override
	public void Start() {
		texture = TextureSheet.getSheet("tiles").texture;
		subTexture = 2;
		tags = new String[1];
		tags[0] = "player";
		transform.setSize(16f, 16f);
		shader = Shader.get("default");

		Animation walking = new Animation(TextureSheet.getSheet("tiles"), "walk0", 2, new int[]{1,1,2});
		addAnimation(walking);
		setAnimation("walk0");
		
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
		float x = 0, y = 0;
		checkCollisionCallbacks();

		if (Keyboard.isDown('a')) {
			x = -speed;
			x = MathUtils.lerp(x, speed, .1f);
		} else if (Keyboard.isDown('d')) {
			x = speed;
			x = MathUtils.lerp(x, speed, .1f);
		} else {
			x = 0;
		}
		collider.setVelocity(new Vector2f(x, y * 100));

		if (Keyboard.isClicked(Keyboard.KEY_SPACE) && !emptyHanded) {
			GameEntity star = new GameEntityStar(true);
			star.collider.setVelocity(new Vector2f(0, 10));
			System.out.println(star.transform.getPosition().x +
					", \t" + star.transform.getPosition().y);
			emptyHanded = true;
		}
		
		super.Update(delta);

	}

	// To Set GameEntityStar in "hand" of player
	public void setInHand() {
		emptyHanded = false;
	}

	// Collision Checking
	private void checkCollisionCallbacks() {
		collider.setCallback(new CollisionCallback() {

			@Override
			public void onCollisionExit(Collider col) {

			}

			@Override
			public void onCollisionEnter(Collider col) {
				if (col.getParent().hasTag("ground")) {
					if (!isJumping) {
						isJumping = true;

					}
				}
				if (col.getParent().hasTag("star")) {
					GameEntityStar star = (GameEntityStar) col.getParent();
					if (star.isHoldlable()) {
						System.out.println("Hit the star");
						List<String> strings = new ArrayList<String>();
						strings.toArray(col.getParent().tags);
						for (String string : strings) {
							if (string == "star") {
								strings.remove(string);
								break;
							}
						}
						col.getParent().tags = strings.toArray(new String[strings.size()]);
						Scene.current.remove(col.getParent());
						setInHand();

					}
				}
			}
		});
	}

}