package Utils;

public class Transform extends Component {

	public Vector2 position;
	public Vector2 rotation;
	public float depth;
	public Transform (Vector2 pos){
		super("Transform");
		position =pos;	
	}
	
}
