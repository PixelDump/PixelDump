package Utils;
public class Vector2 {

	public float x;
	public float y;

	public Vector2(float x, float y) {
		this.x = x;
		this.y = y;
	}
	public Vector2(double x, double y){
		this.x=(float) x;
		this.y=(float) y;
	}
	
	public Vector2(){
		x=0;y=0;
	}
}
