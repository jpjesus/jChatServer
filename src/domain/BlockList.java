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
 * @author Jesus
 */
public class BlockList implements Serializable {
    
    private SortedSet <Block> groups;
    private Comparator namecomparator;
    
    
    public BlockList (){
        
        this.namecomparator = (Comparator) new NameComparator();
        
        this.groups = new TreeSet(namecomparator);
       
    }
    
     public boolean addGroup(Block group)
    {
        return this.groups.add(group);
    }
    
    public boolean removeGroup(Block group)
    {
        return this.groups.remove(group);
    }
    
    public void printGroupList()
    {
        Iterator iterator;
        
        System.out.println("Groups: ");
        
        iterator = this.groups.iterator();
        
        while (iterator.hasNext())
            System.out.println(iterator.next());
    }
    
    public boolean checkGroup (String groupname, BlockList groups){
        
        boolean check = false;
        int i =0;
        
        
        if (groups==null) {
            check=false;
        }
        else {
            
        
        
        
        while (i<groups.size()){
            
          if (groups.get(i).getBlockName().compareTo(groupname)==0){
              check=true;
              i ++;
          }
          else
              i++;
        }
        }
        
        return check;
           
    }
        
   
            
    
    public int size()
    {
        return this.groups.size();
    }
    
    public Block get(int pos)
    {
        ArrayList <Block> list = new ArrayList(this.groups);
        
        return list.get(pos);
    }
    
    public Block get(String groupname)
    {
        ArrayList <Block> list = new ArrayList(this.groups);
        int i =0;
        Block aux = null;
        
        while (i<list.size()){
            
          if (list.get(i).getBlockName().compareTo(groupname)==0)
              aux=list.get(i);
          else
              i++;
        }
        
        
        return aux;
    }
    public Block get(String groupname,BlockList groups)
    {
        int i = 0;
        Block aux = null;
        boolean found = false;
        while (found!=true && i<groups.size())
        { 
            if (groups.get(i).getBlockName().compareTo(groupname)== 0)
            {
                aux=groups.get(i);
                found = true;
            }
            else
                i ++;
        }
        return aux;
    }
  public SortedSet<Block> getGroups() {
        return groups;
    }

    public void setGroups(SortedSet<Block> groups) {
        this.groups = groups;
    }
    
    
}
