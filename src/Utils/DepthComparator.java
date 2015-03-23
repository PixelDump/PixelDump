package Utils;

import java.util.Comparator;


import Engine.GameObject;

/**Compares the depth of two GameObjects
 * 
 * @author Barry
 *
 */
public class DepthComparator implements Comparator<GameObject>
{
	/**Compares the depth of two GameObjects
	 */
    public int compare(GameObject c1, GameObject c2)
    {
         if(c1.transform.depth>(c2.transform.depth))
         return 1;
         return 0;
    }
}
