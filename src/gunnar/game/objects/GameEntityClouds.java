//By Gunnar Jessee
//daApr 22, 2017
package gunnar.game.objects;

import org.joml.Vector2f;

import gunnar.game.utils.GameEntity;
import tek.render.Shader;
import tek.render.TextureSheet;
import tek.runtime.physics.BoxCollider;
import tek.runtime.physics.Collider.ColliderType;

public class GameEntityClouds extends GameEntity {

	private String animationState;
	private int currentAniTime = 0;

	private Vector2f upVel;
	private Vector2f downVel;

	@Override
	public void Start() {
		super.Start();
		animationState = "up";
		texture = TextureSheet.getSheet("tiles").texture;
		subTexture = 5;
		shader = Shader.get("default");
		transform.setSize(32, 16);
		setCollider(new BoxCollider(this, new Vector2f(32, 16)));
		
		collider.setGravityScale(0);
		collider.setColliderType(ColliderType.DYNAMIC);
		collider.fixture.m_isSensor = true;
		upVel = new Vector2f(0, 2);
		downVel = new Vector2f(0, -2);
	}

	@Override
	public void Update(long delta) {
		switch (animationState) {
		case "up":
			collider.setVelocity(upVel);
			if (currentAniTime <= 5) {
				animationState = "down";
				currentAniTime = 0;
			}
			currentAniTime++;
			break;
		case "down":
			collider.setVelocity(downVel);
			if (currentAniTime <= 5) {
				animationState = "up";
				currentAniTime = 0;
			}
			currentAniTime++;
			break;
		default:
			break;
		}
	}

}
