//By Gunnar Jessee
//daApr 21, 2017
package gunnar.game;

import org.joml.Vector2f;
import org.joml.Vector3f;

import gunnar.game.utils.LevelLoader;
import tek.Window;
import tek.game.Interface;
import tek.game.Level;
import tek.game.levels.TestLevel;
import tek.input.Keyboard;
import tek.render.Shader;
import tek.render.Texture;
import tek.runtime.Scene;
import tek.ui.UIFont;
import tek.ui.UIScene;
import tek.ui.UIText;

public class Game implements Interface
{
	
	
	public Level level;
	public UIFont test;
	public UIScene ui;

	
	private static Game instance;
	public static Game GetInstance() {
		return instance;
	}
	
	public Game()
	{
		instance = this;
	}
	
	
	public void loadLevel(Level level){
		if(this.level != null)
			level.end();
		
		this.level = level;
		level.start();
	}
	
	@Override
	public void start() {
		preInit();
		
		UIText testing = new UIText("LD Game");
		testing.set(new Vector2f(10, 10),  new Vector2f(100, 100));
		Scene.current.uiScene.texts.add(testing);
		Scene.current.camera.position = new Vector3f(0, 0, 1);
	}

	@Override
	public void end() {
		
	}

	@Override
	public void input(long delta) {
			
	}

	@Override
	public void update(long delta) {
//		Scene.current.camera.position.y -= .3f;
//		Scene.current.camera.position.x -= .3f;
		
		Scene.current.camera.updateView();
		
	}

	@Override
	public void render(long delta) {
	}

	
	private void preInit() {
		Keyboard.setupButton("horizontal", Keyboard.KEY_RIGHT, Keyboard.KEY_D, Keyboard.KEY_LEFT, Keyboard.KEY_A);
		Window.instance.setClearColor(0, .6f, .8f);
		Shader shader = Shader.get("default");
		// UI elements
		UIFont font = new UIFont("fonts/test.ttf", 12.0f);
		UIText.defaultFont = font;
		UIScene.defaultShader = new Shader("ui", "shaders/ui.vs", "shaders/ui.fs");
		ui = Scene.current.uiScene;
		// Game Content
		loadLevel(new TestLevel());
		Scene.current.defaultShader = shader;
		
		new Texture("textures/star0.png");
		new Texture("textures/grass.png");
		LevelLoader.Temp();
		System.out.println(Scene.current.gameObjects.size());
	}
	
}
