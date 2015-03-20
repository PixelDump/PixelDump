package Utils;

import java.util.Comparator;

import Engine.GameObject;

/**
 * 		Compares the Z position of two objects.
 * @author barry
 *
 */
public class DepthComparator implements Comparator<GameObject>
{
    public int compare(GameObject c1, GameObject c2)
    {
         if(c1.transform.depth>(c2.transform.depth))
         return 1;
         return 0;
    }
}
