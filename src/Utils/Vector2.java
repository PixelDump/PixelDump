package Utils;

/**Stores two float values
 * 
 * @author Barry
 *
 */
public class Vector2 {

	public float x;
	public float y;

	/**Stores two float values
	 */
	public Vector2(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	/**Stores two double values as floats
	 */
	public Vector2(double x, double y){
		this.x=(float) x;
		this.y=(float) y;
	}
	
	/**Initializes two floats to 0
	 * 
	 */
	public Vector2(){
		x=0;y=0;
	}
}
