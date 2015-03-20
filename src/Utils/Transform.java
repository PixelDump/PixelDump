package Utils;

/**Default GameObject characteristics
 * 
 * @author Barry
 *
 */
public class Transform extends Component {

	public Vector2 position;
	public float depth = 0f;
	
	/**Initializes a transform with passed position
	 */
	public Transform (Vector2 pos){
		super("Transform");
		position =pos;	
	}
	
}
