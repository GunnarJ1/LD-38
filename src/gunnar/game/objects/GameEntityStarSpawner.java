package gunnar.game.objects;

import org.joml.Vector2f;

import gunnar.game.MathUtils;
import gunnar.game.utils.GameEntity;
import gunnar.game.utils.Timer;
import tek.Window;
import tek.render.Shader;
import tek.runtime.GameObject;
import tek.runtime.Scene;

public class GameEntityStarSpawner extends GameEntity {

	private Timer timer;
	
	public GameEntityStarSpawner() {
		super();
		timer = new Timer(5);
		shader = Shader.get("default");
	}
	
	@Override
	public void Update(long delta) {
		timer.update(delta);
		if (timer.isFinished()) {
			GameObject star = new GameEntityStar(false);
			final float x = MathUtils.RandomRange(0, Window.defaultWidth / 4);
			final float y = Window.defaultHeight;
			star.transform.setPosition(new Vector2f(x, y));
			Scene.current.add(star);
			timer.resetTimer();
		}
		super.Update(delta);
	}
	
}
