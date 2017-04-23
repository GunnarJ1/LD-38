//By Gunnar Jessee
//daApr 22, 2017
package gunnar.game.objects;

import javax.xml.ws.Holder;

import org.joml.Vector2f;

import gunnar.game.utils.GameEntity;
import tek.render.Shader;
import tek.render.TextureSheet;
import tek.runtime.GameObject;
import tek.runtime.Physics.CollisionCallback;
import tek.runtime.physics.BoxCollider;
import tek.runtime.physics.Collider;
import tek.runtime.physics.Collider.ColliderType;

public class GameEntityStar extends GameEntity {
	// private Vector2f wiggle;

	int fallingSpeed = 80;
	private GameObject instance;
	private boolean isHoldlable;

	public GameEntityStar(boolean holdable) {
		super();
		isHoldlable = holdable;
		texture = TextureSheet.getSheet("tiles").texture;
		subTexture = 0;
		float size = 8;
		transform.setSize(size, size);
		shader = Shader.get("default");
		addTag("entity");
		if (!holdable)
			addTag("star");
		setCollider(new BoxCollider(this, new Vector2f(size, size)));
		collider.body.m_fixtureList.m_isSensor = true;
		collider.setColliderType(ColliderType.DYNAMIC);

		instance = this;
	}

	@Override
	public void Update(long delta) {
		if (collider.type == ColliderType.DYNAMIC)
			collider.setCallback(new CollisionCallback() {

				@Override
				public void onCollisionExit(Collider collider) {

				}

				@Override
				public void onCollisionEnter(Collider col) {
					if (col.getParent().hasTag("ground")) {
						instance.collider.setColliderType(ColliderType.KINEMATIC);
						instance.collider.setVelocity(new Vector2f(0, 0));
						isHoldlable = true;
					}
				}
			});
		if (isHoldlable) {
			instance.collider.setVelocity(new Vector2f(0, 0));
			instance.collider.setGravityScale(0);
		}
	}

	public boolean isHoldlable() {
		return isHoldlable;
	}

}
