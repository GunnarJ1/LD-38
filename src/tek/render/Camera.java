package tek.render;

import org.joml.Matrix4f;
import org.joml.Vector2f;
import org.joml.Vector3f;

import tek.Window;

public class Camera {
	public static final Vector2f DEFAULT_SIZE = new Vector2f(160, 90);
	
	//the camera worldspace variables
	public Vector3f position;
	public Vector2f size;
	
	//the camera's attributes in matrix form
	private Matrix4f view, projection;
	private Matrix4f ui;
	
	public Camera(){
		position = new Vector3f();
		size = new Vector2f(DEFAULT_SIZE);
		initialize();
	}
	
	public Camera(Vector2f size){
		this.position = new Vector3f();
		this.size = new Vector2f(size);
		initialize();
	}
	
	public Camera(Vector2f size, Vector3f position){
		this.position = new Vector3f(position);
		this.size = new Vector2f(size);
		initialize();
	}
	
	/**
	 * Setup the matrices 
	 */
	private void initialize(){
		updateProjection();
		updateView();
		updateUI();
	}
	
	public void updateUI(){
		if(ui == null)
			ui = new Matrix4f();
		ui.identity();
		ui.ortho(0, Window.instance.getWidth(), 0, Window.instance.getHeight(), 1, -1);
	}
	
	/**
	 * Update the camera's view
	 * Note: Pretty much just updates the camera position, no real rotating
	 * 			or scaling in the 2D implementation
	 */
	public void updateView(){
		if(view == null)
			view = new Matrix4f();
		//zero out the matrix
		view.identity();
		//translate the view
		view.translate(-position.x, -position.y, position.z);
	}
	
	/**
	 * Update the camera's projection
	 * Note: This updates the render size of the screen
	 */
	public void updateProjection(){
		if(projection == null)
			projection = new Matrix4f();
		//zero out the matrix 
		projection.identity();
		//setup the orthographic matrix
		projection.ortho(0, size.x, 0, size.y, 1, -1);
	}
	
	/** Get the view matrix
	 * 
	 * @return the view matrix
	 */
	public Matrix4f getView(){
		return view;
	}
	
	/** Get the projection matrix
	 * 
	 * @return the projection matrix 
	 */
	public Matrix4f getProjection(){
		return projection;
	}
	
	public Matrix4f getUI(){
		return ui;
	}
	
	/** Set the size of the camera's view
	 * 
	 * @param size size of the camera's view
	 */
	public void setSize(Vector2f size){
		this.size.set(size);
		updateProjection();
	}
	
	/** Set the position of the camera in space
	 * 
	 * @param position position of the camera in space
	 */
	public void setPosition(Vector3f position){
		this.position.set(position);
		updateView();
	}
	
	public void setPosition(float x, float y, float z){
		this.position.set(x, y, z);
		updateView();
	}
	
	/** Get the camera's center position
	 *
	 * @return the camera's position
	 */
	public Vector3f getPosition(){
		return position;
	}
	
	/** Get the size of the camera
	 * 
	 * @return the size of the camera
	 */
	public Vector2f getSize(){
		return size;
	}
}