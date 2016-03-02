/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 *
 * @author Romi
 */
public class UserList implements Serializable {
    
    private SortedSet <User> userlist;
    private Comparator       nicknamecomparator;

    
    public UserList(){
        
        this.nicknamecomparator = (Comparator) new NicknameComparator();
        this.userlist = new TreeSet(nicknamecomparator);
    }

    public boolean addUser(User user)
    {
        return this.userlist.add(user);
    }
    
    public boolean removeUser(User user)
    {
        return this.userlist.remove(user);
    }
    
    public void printUserList()
    {
        Iterator iterator;
        
 
        
        iterator = this.userlist.iterator();
        
        while (iterator.hasNext())
            System.out.println(iterator.next());
    }
    
    public int size()
    {
        return this.userlist.size();
    }
    
    public User get(int pos)
    {
        ArrayList <User> list = new ArrayList(this.userlist);
        
        return list.get(pos);
    }

    
}
