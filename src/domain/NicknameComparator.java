/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.util.Comparator;

/**
 *
 * @author Romi
 */
public class NicknameComparator implements Comparator, Serializable
{
    @Override
    public int compare(Object firstObject, Object secondObject)
    {
        int result = ((User)firstObject).getNickname().compareTo(((User)secondObject).getNickname());

        if (result == 0)
            return 0;
        
        if (result < 0)
            return -1;
        
        return 1;
    }
    
}
