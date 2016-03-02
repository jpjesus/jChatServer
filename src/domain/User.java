

package domain;
import java.io.Serializable;
import java.util.Date;
import javax.swing.ImageIcon;


/* The class user is responsible for the creation of a user
 * 
 */

public class User implements Serializable {
    
    private String          name;
    private String          lastname;
    private String          secondlastname;
    private Date            birthdate;
    private String          nickname;
    private String          mail;
    private String          avatar;
    private String          password;
    private String          ip;
    private String          port;
    private boolean         online;
    private boolean         active;
    private BlockList       blocklist;
    private String port1;
    
    public User () {
        
        this.name           = "";
        this.lastname       = "";
        this.secondlastname = "";
        this.birthdate      = new Date();
        this.nickname       = "";
        this.mail           = "";
        this.password       = "";
        this.ip             = "";
        this.port           = "";
        this.avatar         = "";
        this.online         = false;
        this.active         = false;
        this.blocklist         = new BlockList();
    
}
     public User (String name,String lastname, String secondlastname,Date birthdate,String nickname,String mail,String password,String ip, String port, String active, String status){
        
        this.name           =name;
        this.lastname       =lastname;
        this.secondlastname =secondlastname;
        this.birthdate      =birthdate;
        this.nickname       =nickname;
        this.mail           =mail;
        this.password       =password;
        this.ip             =ip;
        this.port           =port;
        
        if (active.compareTo("true")==0)
            this.active     = true;
       else
            this.active     = false;
       
        if (status.compareTo("true")==0)
            this.online  = true;
          else
            this.online   = false;
       
        this.blocklist         = new BlockList();
        this.avatar         ="src/avatardef.jpg";
    }

    
    
    public User (String name,String lastname, String secondlastname,Date birthdate,String nickname,String mail,String password){
        
        this.name           = name;
        this.lastname       = lastname;
        this.secondlastname = secondlastname;
        this.birthdate      = birthdate;
        this.nickname       = nickname;
        this.mail           = mail;
        this.password       = password;
        this.ip             = "1212";
        this.port           = "dfdf";
        this.active         = true;
        this.blocklist         = new BlockList();
        
        boolean def         = true;
        this.blocklist.addGroup(new Block(def));
        
        this.avatar         = "src/avatardef.jpg";
        
        
    }
    
 public User(String nickname,String ip ,String port ,String port1 )
{
    this.nickname       = nickname;
    this.ip             =ip;
    this.port           =port;
    this.ip             =ip;
    this.port           =port1;
}  
    

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    
    public BlockList getBlockList() {
        return blocklist;
    }

    public void setBlockList(BlockList groups) {
        this.blocklist = groups;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getSecondlastname() {
        return secondlastname;
    }

    public void setSecondlastname(String secondlastname) {
        this.secondlastname = secondlastname;
    }

    public boolean isOnline() {
        return online;
    }

    public void setOnline(boolean status) {
        this.online = status;
    }


    @Override
    public String toString() {
                
        return nickname + "\n";
    }

    public String getPort1() {
        return port1;
    }

    public void setPort1(String port1) {
        this.port1 = port1;
    }
    
    
    
}
