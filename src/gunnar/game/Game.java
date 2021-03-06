//By Gunnar Jessee
//daApr 21, 2017
package gunnar.game;

import org.joml.Vector2f;

import gunnar.game.levels.MainLevel;
import gunnar.game.utils.LevelLoader;
import tek.Window;
import tek.game.Interface;
import tek.game.Level;
import tek.input.Keyboard;
import tek.render.Shader;
import tek.render.Texture;
import tek.render.TextureSheet;
import tek.runtime.Physics;
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
		
		UIText testing = new UIText("Reaching for the stars");
		testing.set(new Vector2f(10, (Window.defaultHeight - 10) - 16),  new Vector2f(10, 10));
		Scene.current.uiScene.texts.add(testing);
		Scene.current.camera.position.y = -3;
		Scene.current.camera.size = new Vector2f(Window.defaultWidth / 4, Window.defaultHeight / 4);
		Scene.current.camera.updateView();
		Scene.current.camera.updateProjection();
		
	}

	@Override
	public void end() {
		
	}

	@Override
	public void input(long delta) {
			
	}

	@Override
	public void update(long delta) {

		
	}

	@Override
	public void render(long delta) {

	}

	
	private void preInit() {
		Physics.instance.setGravity(0, -100);
		Keyboard.setupButton("horizontal", Keyboard.KEY_RIGHT, Keyboard.KEY_D, Keyboard.KEY_LEFT, Keyboard.KEY_A);
		Window.instance.setClearColor(0, .5f, .6f);
		Shader shader = Shader.get("default");
		Window.instance.setIcon("textures/icon16.png", "textures/icon32.png");
		Physics.instance.setGravity(0, -1000);
		// UI elements
		UIFont font = new UIFont("fonts/test.ttf", 8.0f);
		UIText.defaultFont = font;
		UIScene.defaultShader = new Shader("ui", "shaders/ui.vs", "shaders/ui.fs");
		ui = Scene.current.uiScene;
		// Game Content
		loadLevel(new MainLevel());
		Scene.current.defaultShader = shader;
		new TextureSheet(new Texture("textures/texturesheet.png"), 16, 16, "tiles");
		LevelLoader.Temp();
//		Animation.get
	}
	
}
