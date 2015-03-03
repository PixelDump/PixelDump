package Utils;

public class Transform extends Component {

	public Vector2 position;
	public float depth = 0f;
	
	public Transform (Vector2 pos){
		super("Transform");
		position =pos;	
	}
	
}
