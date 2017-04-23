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
	private Scene scene;
	public GameEntityStarSpawner() {
		super();
		timer = new Timer(5);
		shader = Shader.get("default");
		scene = Scene.current;
	}
	
	@Override
	public void Update(long delta) {
		timer.update(delta);
		if (timer.isFinished()) {
			GameObject star = new GameEntityStar(false);
			float x = MathUtils.RandomRange(0, Window.defaultWidth / 4);
			float y = MathUtils.RandomRange(100, (Window.defaultHeight / 4) -32);
			star.transform.setPosition(new Vector2f(x, y));
			Scene.current.add(star);
			timer.resetTimer();
		}
	}
	
}
