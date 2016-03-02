/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;

/**
 *
 * @author Romi
 */
public class Block implements Serializable{
    
    private String blockname;
    private UserList userlist;
    
    public Block () {
        
        this.blockname       = "";
        this.userlist    = new UserList();
        
    }
    
    public Block (boolean def){
        this.blockname       = "Other Friends";
        this.userlist    = new UserList();
    }
    
    public Block (String name) {
        
        this.blockname       = name;
        this.userlist    = new UserList ();
    }

    public UserList getUserList() {
        return userlist;
    }

    public void setUserList(UserList friends) {
        this.userlist = friends;
    }

    public String getBlockName() {
        return blockname;
    }

    public void setBlockName(String name) {
        this.blockname = name;
    }

    @Override
    public String toString() {
        
        System.out.println(blockname);
        System.out.println("Members: ");
        userlist.printUserList();
        return " ";
    }
    
     
    
            
    
}
