package Engine;

public class Transform extends Component {

	public Vector2 position;
	public Vector2 rotation;
	
	public Transform (Vector2 pos){
		super("Transform");
		position =pos;	
	}
	
}
