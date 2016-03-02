package domain;






import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.JDOMParseException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;


/**
 *
 * @author ricardocasanova
 */


public class UserXmlFile
{

    public static boolean readObjectFromFile(String nicknamelog, String passwordlog)
    {
        Document        doc;
        Element         root,child;
        List <Element>  rootChildrens;
        String          name, lastname, status, secondlastname, birthdate, nickname, mail, password, ip, port, active;
        boolean         found = false;
        int             pos = 0;

        SAXBuilder      builder = new SAXBuilder();

        try
        {
            doc = builder.build(Util.USERS_XML_PATH);

            root = doc.getRootElement();

            rootChildrens = root.getChildren();

            while (!found && pos < rootChildrens.size())
            {
                child = rootChildrens.get(pos);

                name              = child.getAttributeValue(Util.USER_NAME_TAG);
                lastname          = child.getAttributeValue(Util.USER_LASTNAME_TAG);
                secondlastname    = child.getAttributeValue(Util.USER_SECONDLASTNAME_TAG);
                birthdate         = child.getAttributeValue(Util.USER_BIRTHDATE_TAG);
                nickname          = child.getAttributeValue(Util.USER_NICKNAME_TAG);
                mail              = child.getAttributeValue(Util.USER_MAIL_TAG);
                password          = child.getAttributeValue(Util.USER_PASSWORD_TAG);
                ip                = child.getAttributeValue(Util.USER_IP_TAG);
                port              = child.getAttributeValue(Util.USER_PORT_TAG);
                active            = child.getAttributeValue(Util.USER_ACTIVE_TAG);
                status            = child.getAttributeValue(Util.USER_ONLINE_TAG);
                
                
                if(name             != null   &&   
                   nickname         != null   &&   nickname.compareTo(nicknamelog)==0 &&
                   mail             != null   &&
                   password         != null   &&   password.compareTo(passwordlog)==0 &&
                   ip               != null   && 
                   port             != null   && 
                   active           != null   &&   active.compareTo("true")==0 &&
                   lastname         != null   && 
                   secondlastname   != null   &&
                   birthdate        != null   &&
                   status           != null)
                {
                    found = true;
                }
                else
                {
                    if (name == null)
                        System.out.println(Util.ERROR_USER_NAME_TAG);

                    if (lastname == null)
                        System.out.println(Util.ERROR_USER_LASTNAME_TAG);

                    if (secondlastname == null)
                        System.out.println(Util.ERROR_USER_SECONDLASTNAME_TAG);
                    
                    if (birthdate == null)
                        System.out.println(Util.ERROR_USER_BIRTHDATE_TAG);
                    
                    if (nickname == null)
                        System.out.println(Util.ERROR_USER_NICKNAME_TAG);
                    
                    if (mail == null)
                        System.out.println(Util.ERROR_USER_MAIL_TAG);
                    
                    if (password == null)
                        System.out.println(Util.ERROR_USER_PASSWORD_TAG);
                    
                    if (ip == null)
                        System.out.println(Util.ERROR_USER_IP_TAG);
                    
                    if (port == null)
                        System.out.println(Util.ERROR_USER_PORT_TAG);
                    
                    
                    if (active == null)
                        System.out.println(Util.ERROR_USER_ACTIVE_TAG);
                    
                    if (status == null)
                        System.out.println(Util.ERROR_USER_ONLINE_TAG);
                    
                    
                    //pos++;
                }
                pos++;
            }
        }
        catch(JDOMParseException e)
        {
            System.out.println(Util.ERROR_XML_EMPTY_FILE);
            e.printStackTrace();
        }
        catch(JDOMException e)
        {
            System.out.println(Util.ERROR_XML_PROCESSING_FILE);
            e.printStackTrace();
        }
        catch(IOException e)
        {
            System.out.println(Util.ERROR_XML_PROCESSING_FILE);
            e.printStackTrace();
        }

        return found;
    }
    
    public static boolean readObjectFromFile(String nicknamelog, boolean def)
    {
        Document        doc;
        Element         root,child;
        List <Element>  rootChildrens;
        String          name, lastname, secondlastname, birthdate, nickname, mail, password, ip, port, active;
        boolean         found = false;
        int             pos = 0;

        SAXBuilder      builder = new SAXBuilder();

        try
        {
            doc = builder.build(Util.USERS_XML_PATH);

            root = doc.getRootElement();

            rootChildrens = root.getChildren();

            while (!found && pos < rootChildrens.size())
            {
                child = rootChildrens.get(pos);

                name              = child.getAttributeValue(Util.USER_NAME_TAG);
                lastname          = child.getAttributeValue(Util.USER_LASTNAME_TAG);
                secondlastname    = child.getAttributeValue(Util.USER_SECONDLASTNAME_TAG);
                birthdate         = child.getAttributeValue(Util.USER_BIRTHDATE_TAG);
                nickname          = child.getAttributeValue(Util.USER_NICKNAME_TAG);
                mail              = child.getAttributeValue(Util.USER_MAIL_TAG);
                password          = child.getAttributeValue(Util.USER_PASSWORD_TAG);
                ip                = child.getAttributeValue(Util.USER_IP_TAG);
                port              = child.getAttributeValue(Util.USER_PORT_TAG);
                active            = child.getAttributeValue(Util.USER_ACTIVE_TAG);
                
                
                if(name             != null   &&   
                   nickname         != null   &&   nickname.compareTo(nicknamelog)==0 &&
                   mail             != null   &&
                   password         != null   &&   
                   ip               != null   && 
                   port             != null   && 
                   active           != null   && 
                   lastname         != null   && 
                   secondlastname   != null   &&
                   birthdate        != null       )
                {
                    found = true;
                }
                else
                {
                    if (name == null)
                        System.out.println(Util.ERROR_USER_NAME_TAG);

                    if (lastname == null)
                        System.out.println(Util.ERROR_USER_LASTNAME_TAG);

                    if (secondlastname == null)
                        System.out.println(Util.ERROR_USER_SECONDLASTNAME_TAG);
                    
                    if (birthdate == null)
                        System.out.println(Util.ERROR_USER_BIRTHDATE_TAG);
                    
                    if (nickname == null)
                        System.out.println(Util.ERROR_USER_NICKNAME_TAG);
                    
                    if (mail == null)
                        System.out.println(Util.ERROR_USER_MAIL_TAG);
                    
                    if (password == null)
                        System.out.println(Util.ERROR_USER_PASSWORD_TAG);
                    
                    if (ip == null)
                        System.out.println(Util.ERROR_USER_IP_TAG);
                    
                    if (port == null)
                        System.out.println(Util.ERROR_USER_PORT_TAG);
                    
                    /*
                    if (active == null)
                        System.out.println(Util.ERROR_USER_ACTIVE_TAG);
                    
                    */
                    pos++;
                }
            }
        }
        catch(JDOMParseException e)
        {
            System.out.println(Util.ERROR_XML_EMPTY_FILE);
            e.printStackTrace();
        }
        catch(JDOMException e)
        {
            System.out.println(Util.ERROR_XML_PROCESSING_FILE);
            e.printStackTrace();
        }
        catch(IOException e)
        {
            System.out.println(Util.ERROR_XML_PROCESSING_FILE);
            e.printStackTrace();
        }

        return found;
    }
    
    
    public static User readObjectFromFile(String nicknameUser) throws ParseException
    {
        User            user = null;
        Document        doc;
        Element         root,child;
        List <Element>  rootChildrens;
        String          name, online, lastname, nickname, secondlastname, ip , port, birthdate, mail, password, active;
        boolean         found = false;
        int             pos = 0;

        SAXBuilder      builder = new SAXBuilder();

        try
        {
            doc = builder.build(Util.USERS_XML_PATH);

            root = doc.getRootElement();

            rootChildrens = root.getChildren();

            while (!found && pos < rootChildrens.size())
            {
                child = rootChildrens.get(pos);

                name               = child.getAttributeValue(Util.USER_NAME_TAG);
                lastname           = child.getAttributeValue(Util.USER_LASTNAME_TAG);
                secondlastname     = child.getAttributeValue(Util.USER_SECONDLASTNAME_TAG);
                birthdate          = child.getAttributeValue(Util.USER_BIRTHDATE_TAG);
                nickname           = child.getAttributeValue(Util.USER_NICKNAME_TAG);
                mail               = child.getAttributeValue(Util.USER_MAIL_TAG);
                password           = child.getAttributeValue(Util.USER_PASSWORD_TAG);
                ip                 = child.getAttributeValue(Util.USER_IP_TAG);
                port               = child.getAttributeValue(Util.USER_PORT_TAG);
                active             = child.getAttributeValue(Util.USER_ACTIVE_TAG);
                online             = child.getAttributeValue(Util.USER_ONLINE_TAG);
                
                
                
                if(name != null && lastname != null && active != null && 
                   port != null && ip != null && password != null && 
                   mail != null &&  nickname != null && secondlastname != null && 
                   birthdate != null &&  online != null && nickname.equals(nicknameUser))
                {
                    DateFormat df= new SimpleDateFormat("dd/MM/yy");
                    
                    Date birth = df.parse(birthdate);
                    
                    user = new User(name,lastname, secondlastname, birth, nickname, mail, password, ip, port, active,online);
                    found = true;                   
                    
                    if (user == null)
                    System.out.println(Util.ERROR_XML_USER_NICKNAME_NOT_EXIST);
                }
                else
                {
                    if (name == null)
                        System.out.println(Util.ERROR_USER_NAME_TAG);
                    if (lastname == null)
                        System.out.println(Util.ERROR_USER_LASTNAME_TAG);
                    if (secondlastname == null)
                        System.out.println(Util.ERROR_USER_SECONDLASTNAME_TAG);
                    if (birthdate == null)
                        System.out.println(Util.ERROR_USER_BIRTHDATE_TAG);
                    if (mail == null)
                        System.out.println(Util.ERROR_USER_MAIL_TAG);
                    if (password == null)
                        System.out.println(Util.ERROR_USER_PASSWORD_TAG);
                    if (ip == null)
                        System.out.println(Util.ERROR_USER_IP_TAG);
                    if (port == null)
                        System.out.println(Util.ERROR_USER_PORT_TAG);
                    if (active == null)
                        System.out.println(Util.ERROR_USER_ACTIVE_TAG);
                    if (online == null)
                        System.out.println(Util.ERROR_USER_ONLINE_TAG);
                    
                   // pos++;
                }
                pos++;
            }
        }
        catch(JDOMParseException e)
        {
            System.out.println(Util.ERROR_XML_EMPTY_FILE);
            e.printStackTrace();
        }
        catch(JDOMException e)
        {
            System.out.println(Util.ERROR_XML_PROCESSING_FILE);
            e.printStackTrace();
        }
        catch(IOException e)
        {
            System.out.println(Util.ERROR_XML_PROCESSING_FILE);
            e.printStackTrace();
        }

        return user;
    }

    public static UserList realAllObjectsFromFile(UserList userlist) throws ParseException
    {
        User            user = null;
        Document        doc;
        Element         root,child;
        List <Element>  rootChildrens;
        String          name, status, lastname, nickname, secondlastname, ip , port, birthdate, mail, password, active;
        int             pos = 0;

        SAXBuilder      builder = new SAXBuilder();

        try
        {
            doc = builder.build(Util.USERS_XML_PATH);

            root = doc.getRootElement();

            rootChildrens = root.getChildren();

            while (pos < rootChildrens.size())
            {
                child = rootChildrens.get(pos);

                name               = child.getAttributeValue(Util.USER_NAME_TAG);
                lastname           = child.getAttributeValue(Util.USER_LASTNAME_TAG);
                secondlastname     = child.getAttributeValue(Util.USER_SECONDLASTNAME_TAG);
                birthdate          = child.getAttributeValue(Util.USER_BIRTHDATE_TAG);
                nickname           = child.getAttributeValue(Util.USER_NICKNAME_TAG);
                mail               = child.getAttributeValue(Util.USER_MAIL_TAG);
                password           = child.getAttributeValue(Util.USER_PASSWORD_TAG);
                ip                 = child.getAttributeValue(Util.USER_IP_TAG);
                port               = child.getAttributeValue(Util.USER_PORT_TAG);
                active             = child.getAttributeValue(Util.USER_ACTIVE_TAG);
                status             = child.getAttributeValue(Util.USER_ONLINE_TAG);
                
                
                if (name != null && lastname != null && active != null && 
                   port != null && ip != null && password != null && 
                   mail != null &&  nickname != null && secondlastname != null && 
                   birthdate != null && status != null)
                
                {
                    
                    DateFormat df= new SimpleDateFormat("dd/MM/yy");
                    
                    Date birth = df.parse(birthdate);
                    
                    user = new User (name,lastname, secondlastname, birth, nickname, mail, password, ip, port, active, status);
                    userlist.addUser(user);
              
                }
                else
                {
                    if (name == null)
                        System.out.println(Util.ERROR_USER_NAME_TAG);
                    if (lastname == null)
                        System.out.println(Util.ERROR_USER_LASTNAME_TAG);
                    if (secondlastname == null)
                        System.out.println(Util.ERROR_USER_SECONDLASTNAME_TAG);
                    if (birthdate == null)
                        System.out.println(Util.ERROR_USER_BIRTHDATE_TAG);
                    if (mail == null)
                        System.out.println(Util.ERROR_USER_MAIL_TAG);
                    if (password == null)
                        System.out.println(Util.ERROR_USER_PASSWORD_TAG);
                    if (ip == null)
                        System.out.println(Util.ERROR_USER_IP_TAG);
                    if (port == null)
                        System.out.println(Util.ERROR_USER_PORT_TAG);
                    if (active == null)
                        System.out.println(Util.ERROR_USER_ACTIVE_TAG);
                    if (status == null)
                        System.out.println(Util.ERROR_USER_ONLINE_TAG);
                }
                
                pos++;
            }
        }
        catch(JDOMParseException e)
        {
            System.out.println(Util.ERROR_XML_EMPTY_FILE);
            e.printStackTrace();
        }
        catch(JDOMException e)
        {
            System.out.println(Util.ERROR_XML_PROCESSING_FILE);
            e.printStackTrace();
        }
        catch(IOException e)
        {
            System.out.println(Util.ERROR_XML_PROCESSING_FILE);
            e.printStackTrace();
        }

        return userlist;
    }

    public static boolean saveObjectToFile(User user)
    {
        Document    doc;
        Element     root, newChild;

        SAXBuilder  builder = new SAXBuilder();

        try
        {
            doc = builder.build(Util.USERS_XML_PATH);

            root = doc.getRootElement();

            newChild = new Element(Util.USER_TAG);

            newChild.setAttribute(Util.USER_NAME_TAG, user.getName());
            newChild.setAttribute(Util.USER_LASTNAME_TAG, user.getLastname());
            newChild.setAttribute(Util.USER_SECONDLASTNAME_TAG, user.getSecondlastname());
            
            DateFormat df= new SimpleDateFormat("dd/MM/yy");
                    
            String birth = df.format(user.getBirthdate());
                    
            newChild.setAttribute(Util.USER_BIRTHDATE_TAG, birth);
            newChild.setAttribute(Util.USER_NICKNAME_TAG, user.getNickname());
            newChild.setAttribute(Util.USER_MAIL_TAG, user.getMail());
            newChild.setAttribute(Util.USER_PASSWORD_TAG, user.getPassword());
            newChild.setAttribute(Util.USER_IP_TAG, user.getIp());
            newChild.setAttribute(Util.USER_PORT_TAG, user.getPort());
            newChild.setAttribute(Util.USER_ACTIVE_TAG, "true");
            newChild.setAttribute(Util.USER_ONLINE_TAG, "false");
            
            root.addContent(newChild);

            try
            {
                Format format = Format.getPrettyFormat();
             
                XMLOutputter out = new XMLOutputter(format);

                FileOutputStream file = new FileOutputStream(Util.USERS_XML_PATH);

                out.output(doc,file);

                file.flush();
                file.close();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        catch(JDOMParseException e)
        {
            System.out.println(Util.ERROR_XML_EMPTY_FILE);
            e.printStackTrace();
        }
        catch(JDOMException e)
        {
            System.out.println(Util.ERROR_XML_PROCESSING_FILE);
            e.printStackTrace();
        }
        catch(IOException e)
        {
            System.out.println(Util.ERROR_XML_PROCESSING_FILE);
            e.printStackTrace();
        }

        return true;
    }
    
   public static BlockList readAllFriendsFromFile(String nicknameuser, BlockList list) throws ParseException
    {
        Block           group = null;
        //GroupList       list = null;
        User            userfriend = null;
        Document        doc;
        Element         root,child;
        List <Element>  rootChildrens;
        String          nickname1, nickname2, groupname, friendship;
        int             pos = 0;

        SAXBuilder      builder = new SAXBuilder();

        try
        {
            doc = builder.build(Util.BLOCKS_XML_PATH);
            root = doc.getRootElement();

            rootChildrens = root.getChildren();

            while (pos < rootChildrens.size())
            {
                child = rootChildrens.get(pos);

                nickname1        = child.getAttributeValue(Util.BLOCK_NICKNAME1_TAG);
                nickname2        = child.getAttributeValue(Util.BLOCK_NICKNAME2_TAG);
                groupname        = child.getAttributeValue(Util.BLOCK_GROUP_TAG);
                friendship       = child.getAttributeValue(Util.BLOCK_FRIENDSHIP_TAG);

                if(nickname1  != null && nickname2 != null && groupname != null &&
                   friendship != null && nickname1.equals(nicknameuser) && 
                   friendship.compareTo("true")==0)
                {
                    userfriend = UserXmlFile.readObjectFromFile(nickname2);
                    
                    if (userfriend!=null)
                    {
                        
                        if (list==null) {
                            list = new BlockList();
                            group = new Block (groupname);
                            group.getUserList().addUser(userfriend);
                            list.addGroup(group);
                            
                            
                        }
                         
                         
                        else {
                                                
                        if (list.checkGroup(groupname,list)==false){
                            
                            //System.out.println("Entra e check roup == false");
                            
                            group = new Block(groupname);
                            group.getUserList().addUser(userfriend);
                            list.addGroup(group);
                            
                        }
                        else {
                          
                             group = list.get(groupname,list);
                            group.getUserList().addUser(userfriend);  
                            
                            
                            System.out.println("Entra e check roup == true");
                            
                            
                        }
                    }
                     
                    }
                    else
                        System.out.println(Util.ERROR_USER_NICKNAME_TAG);
                    
                    
                }
                else
                {
                    if (nickname1 == null)
                        System.out.println(Util.ERROR_BLOCK_NICKNAME1_TAG);
                    
                    if (nickname2 == null)
                        System.out.println(Util.ERROR_BLOCK_NICKNAME2_TAG);

                    if (groupname == null)
                        System.out.println(Util.ERROR_BLOCK_GROUP_TAG);
                    
                    if (friendship == null)
                        System.out.println(Util.ERROR_BLOCK_FRIENDSHIP_TAG);
                
                
                }
                
                pos++;
            }
            
        }
        catch(JDOMParseException e)
        {
            System.out.println(Util.ERROR_XML_EMPTY_FILE);
            e.printStackTrace();
        }
        catch(JDOMException e)
        {
            System.out.println(Util.ERROR_XML_PROCESSING_FILE);
            e.printStackTrace();
        }
        catch(IOException e)
        {
            System.out.println(Util.ERROR_XML_PROCESSING_FILE);
            e.printStackTrace();
        }

System.out.println(list);
        return list;
    }
    
    
    public static boolean deleteFriendFromFile(String nickname, String friendnick) throws ParseException
    {
        
        Document        doc;
        Element         root,child;
        List <Element>  rootChildrens;
        String          nickname1, nickname2, groupname, friendship;
        int             pos = 0;
        boolean         del = false;

        SAXBuilder      builder = new SAXBuilder();

        try
        {
            doc = builder.build(Util.BLOCKS_XML_PATH);
            root = doc.getRootElement();

            rootChildrens = root.getChildren();

            while (pos < rootChildrens.size())
            {
                child = rootChildrens.get(pos);

                nickname1        = child.getAttributeValue(Util.BLOCK_NICKNAME1_TAG);
                nickname2        = child.getAttributeValue(Util.BLOCK_NICKNAME2_TAG);
                groupname        = child.getAttributeValue(Util.BLOCK_GROUP_TAG);
                friendship       = child.getAttributeValue(Util.BLOCK_FRIENDSHIP_TAG);

                if(nickname1 != null && nickname2 != null && groupname != null &&
                   nickname1.equals(nickname) && friendnick.equals(nickname2)
                   && friendship.compareTo("true")==0)
                {
                    child.removeAttribute(Util.BLOCK_FRIENDSHIP_TAG);
                    child.setAttribute(Util.BLOCK_FRIENDSHIP_TAG, "false");
                    del = true;
                    

            try
            {
                Format format = Format.getPrettyFormat();
             
                XMLOutputter out = new XMLOutputter(format);

                FileOutputStream file = new FileOutputStream(Util.BLOCKS_XML_PATH);

                out.output(doc,file);

                file.flush();
                file.close();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
                }
               
                else
                {
                    if (nickname1 == null)
                        System.out.println(Util.ERROR_BLOCK_NICKNAME1_TAG);
                    
                    if (nickname2 == null)
                        System.out.println(Util.ERROR_BLOCK_NICKNAME2_TAG);

                    if (groupname == null)
                        System.out.println(Util.ERROR_BLOCK_GROUP_TAG);
                    
                    if (groupname == null)
                        System.out.println(Util.ERROR_BLOCK_FRIENDSHIP_TAG);
                }
                
                pos++;
            }
        }
        catch(JDOMParseException e)
        {
            System.out.println(Util.ERROR_XML_EMPTY_FILE);
            e.printStackTrace();
        }
        catch(JDOMException e)
        {
            System.out.println(Util.ERROR_XML_PROCESSING_FILE);
            e.printStackTrace();
        }
        catch(IOException e)
        {
            System.out.println(Util.ERROR_XML_PROCESSING_FILE);
            e.printStackTrace();
        }
        
        return del;

    }
    
    public static boolean addFriendToFile (String nickname,String friendnick, String group) 
    {
        
        Document    doc;
        Element     root, newChild;
        boolean     res=false;

        SAXBuilder  builder = new SAXBuilder();

        try
        {
            doc = builder.build(Util.BLOCKS_XML_PATH);

            root = doc.getRootElement();

            newChild = new Element(Util.BLOCK_TAG);

            newChild.setAttribute(Util.BLOCK_NICKNAME1_TAG, nickname);
            newChild.setAttribute(Util.BLOCK_NICKNAME2_TAG, friendnick);
            newChild.setAttribute(Util.BLOCK_GROUP_TAG, group);
            newChild.setAttribute (Util.BLOCK_FRIENDSHIP_TAG, "true");
            
            root.addContent(newChild);
            
            newChild = new Element(Util.BLOCK_TAG);

            newChild.setAttribute(Util.BLOCK_NICKNAME1_TAG, friendnick);
            newChild.setAttribute(Util.BLOCK_NICKNAME2_TAG, nickname);
            newChild.setAttribute(Util.BLOCK_GROUP_TAG, "Other Friends");
            newChild.setAttribute (Util.BLOCK_FRIENDSHIP_TAG, "true");
            
            root.addContent(newChild);
            
            
            res=true;

            try
            {
                Format format = Format.getPrettyFormat();
             
                XMLOutputter out = new XMLOutputter(format);

                FileOutputStream file = new FileOutputStream(Util.BLOCKS_XML_PATH);

                out.output(doc,file);

                file.flush();
                file.close();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        catch(JDOMParseException e)
        {
            System.out.println(Util.ERROR_XML_EMPTY_FILE);
            e.printStackTrace();
        }
        catch(JDOMException e)
        {
            System.out.println(Util.ERROR_XML_PROCESSING_FILE);
            e.printStackTrace();
        }
        catch(IOException e)
        {
            System.out.println(Util.ERROR_XML_PROCESSING_FILE);
            e.printStackTrace();
        }

        return res;
    
    }
    
     public static boolean updateStatusInFile(String nickuser,boolean statususer, String IP, String PORT) throws ParseException
    {
        Document        doc;
        Element         root,child;
        List <Element>  rootChildrens;
        String          name, status, lastname, nickname, secondlastname, ip , port, birthdate, mail, password, active;
        boolean         found = false;
        int             pos = 0;

        SAXBuilder      builder = new SAXBuilder();

        try
        {
            doc = builder.build(Util.USERS_XML_PATH);

            root = doc.getRootElement();

            rootChildrens = root.getChildren();

            while (!found && pos < rootChildrens.size())
            {
                child = rootChildrens.get(pos);

                name               = child.getAttributeValue(Util.USER_NAME_TAG);
                lastname           = child.getAttributeValue(Util.USER_LASTNAME_TAG);
                secondlastname     = child.getAttributeValue(Util.USER_SECONDLASTNAME_TAG);
                birthdate          = child.getAttributeValue(Util.USER_BIRTHDATE_TAG);
                nickname           = child.getAttributeValue(Util.USER_NICKNAME_TAG);
                mail               = child.getAttributeValue(Util.USER_MAIL_TAG);
                password           = child.getAttributeValue(Util.USER_PASSWORD_TAG);
                ip                 = child.getAttributeValue(Util.USER_IP_TAG);
                port               = child.getAttributeValue(Util.USER_PORT_TAG);
                active             = child.getAttributeValue(Util.USER_ACTIVE_TAG);
                status             = child.getAttributeValue(Util.USER_ONLINE_TAG);
                
                
                
                if(name != null && lastname != null && active           != null && 
                   port != null && ip       != null && password         != null && 
                   mail != null && nickname != null && secondlastname   != null && 
                   birthdate != null && status != null && nickname.equals(nickuser))
                {
                    
                    found = true;
                    
                    if (statususer==true){
                        child.removeAttribute(Util.USER_ONLINE_TAG);
                        child.setAttribute(Util.USER_ONLINE_TAG, "true");
                    }
                    else {
                        child.removeAttribute(Util.USER_ONLINE_TAG);
                        child.setAttribute(Util.USER_ONLINE_TAG, "false");
                    }
                    
                    child.removeAttribute(Util.USER_IP_TAG);
                    child.setAttribute(Util.USER_IP_TAG, IP);
                    
                    child.removeAttribute(Util.USER_PORT_TAG);
                    child.setAttribute(Util.USER_PORT_TAG, PORT);
                    
            try
            {
                Format format = Format.getPrettyFormat();
             
                XMLOutputter out = new XMLOutputter(format);

                FileOutputStream file = new FileOutputStream(Util.USERS_XML_PATH);

                out.output(doc,file);

                file.flush();
                file.close();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
                }
                else
                {
                    if (name == null)
                        System.out.println(Util.ERROR_USER_NAME_TAG);
                    if (lastname == null)
                        System.out.println(Util.ERROR_USER_LASTNAME_TAG);
                    if (secondlastname == null)
                        System.out.println(Util.ERROR_USER_SECONDLASTNAME_TAG);
                    if (birthdate == null)
                        System.out.println(Util.ERROR_USER_BIRTHDATE_TAG);
                    if (mail == null)
                        System.out.println(Util.ERROR_USER_MAIL_TAG);
                    if (password == null)
                        System.out.println(Util.ERROR_USER_PASSWORD_TAG);
                    if (ip == null)
                        System.out.println(Util.ERROR_USER_IP_TAG);
                    if (port == null)
                        System.out.println(Util.ERROR_USER_PORT_TAG);
                    if (active == null)
                        System.out.println(Util.ERROR_USER_ACTIVE_TAG);
                    if (status == null)
                        System.out.println(Util.ERROR_USER_ONLINE_TAG);
                    
                    pos++;
                }
            }
        }
        catch(JDOMParseException e)
        {
            System.out.println(Util.ERROR_XML_EMPTY_FILE);
            e.printStackTrace();
        }
        catch(JDOMException e)
        {
            System.out.println(Util.ERROR_XML_PROCESSING_FILE);
            e.printStackTrace();
        }
        catch(IOException e)
        {
            System.out.println(Util.ERROR_XML_PROCESSING_FILE);
            e.printStackTrace();
        }

        return found;
    }
     
     public static boolean updateStatusInFile(String nickuser,boolean statususer) throws ParseException
    {
        Document        doc;
        Element         root,child;
        List <Element>  rootChildrens;
        String          name, status, lastname, nickname, secondlastname, ip , port, birthdate, mail, password, active;
        boolean         found = false;
        int             pos = 0;

        SAXBuilder      builder = new SAXBuilder();

        try
        {
            doc = builder.build(Util.USERS_XML_PATH);

            root = doc.getRootElement();

            rootChildrens = root.getChildren();

            while (!found && pos < rootChildrens.size())
            {
                child = rootChildrens.get(pos);

                name               = child.getAttributeValue(Util.USER_NAME_TAG);
                lastname           = child.getAttributeValue(Util.USER_LASTNAME_TAG);
                secondlastname     = child.getAttributeValue(Util.USER_SECONDLASTNAME_TAG);
                birthdate          = child.getAttributeValue(Util.USER_BIRTHDATE_TAG);
                nickname           = child.getAttributeValue(Util.USER_NICKNAME_TAG);
                mail               = child.getAttributeValue(Util.USER_MAIL_TAG);
                password           = child.getAttributeValue(Util.USER_PASSWORD_TAG);
                ip                 = child.getAttributeValue(Util.USER_IP_TAG);
                port               = child.getAttributeValue(Util.USER_PORT_TAG);
                active             = child.getAttributeValue(Util.USER_ACTIVE_TAG);
                status             = child.getAttributeValue(Util.USER_ONLINE_TAG);
                
                
                
                if(name != null && lastname != null && active           != null && 
                   port != null && ip       != null && password         != null && 
                   mail != null && nickname != null && secondlastname   != null && 
                   birthdate != null && status != null && nickname.equals(nickuser))
                {
                    
                    found = true;
                    
                    if (statususer==true){
                        child.removeAttribute(Util.USER_ONLINE_TAG);
                        child.setAttribute(Util.USER_ONLINE_TAG, "true");
                    }
                    else {
                        child.removeAttribute(Util.USER_ONLINE_TAG);
                        child.setAttribute(Util.USER_ONLINE_TAG, "false");
                    }
                   
                    
            try
            {
                Format format = Format.getPrettyFormat();
             
                XMLOutputter out = new XMLOutputter(format);

                FileOutputStream file = new FileOutputStream(Util.USERS_XML_PATH);

                out.output(doc,file);

                file.flush();
                file.close();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
                }
                else
                {
                    if (name == null)
                        System.out.println(Util.ERROR_USER_NAME_TAG);
                    if (lastname == null)
                        System.out.println(Util.ERROR_USER_LASTNAME_TAG);
                    if (secondlastname == null)
                        System.out.println(Util.ERROR_USER_SECONDLASTNAME_TAG);
                    if (birthdate == null)
                        System.out.println(Util.ERROR_USER_BIRTHDATE_TAG);
                    if (mail == null)
                        System.out.println(Util.ERROR_USER_MAIL_TAG);
                    if (password == null)
                        System.out.println(Util.ERROR_USER_PASSWORD_TAG);
                    if (ip == null)
                        System.out.println(Util.ERROR_USER_IP_TAG);
                    if (port == null)
                        System.out.println(Util.ERROR_USER_PORT_TAG);
                    if (active == null)
                        System.out.println(Util.ERROR_USER_ACTIVE_TAG);
                    if (status == null)
                        System.out.println(Util.ERROR_USER_ONLINE_TAG);
                    
                    pos++;
                }
            }
        }
        catch(JDOMParseException e)
        {
            System.out.println(Util.ERROR_XML_EMPTY_FILE);
            e.printStackTrace();
        }
        catch(JDOMException e)
        {
            System.out.println(Util.ERROR_XML_PROCESSING_FILE);
            e.printStackTrace();
        }
        catch(IOException e)
        {
            System.out.println(Util.ERROR_XML_PROCESSING_FILE);
            e.printStackTrace();
        }

        return found;
    }
     
     
     public static BlockList readGroupsFromFile (String nickuser){
         
        Block          group = null;
        BlockList       list = null;
        Document        doc;
        Element         root,child;
        List <Element>  rootChildrens;
        String          nickname, groupname;
        int             pos = 0;

        SAXBuilder      builder = new SAXBuilder();

        try
        {
            doc = builder.build(Util.GROUPS_XML_PATH);
            root = doc.getRootElement();

            rootChildrens = root.getChildren();

            while (pos < rootChildrens.size())
            {
                child = rootChildrens.get(pos);

                nickname        = child.getAttributeValue(Util.GROUP_NICKNAME_TAG);
                groupname        = child.getAttributeValue(Util.GROUP_GROUP_TAG);
                
                if(nickname  != null && groupname != null &&
                   nickname.compareTo(nickuser)==0)
                {
                    
                    if (list==null) {
                            list = new BlockList ();
                            group = new Block (groupname);
                            list.addGroup(group);
                    }
                    else {
                                                
                           group = new Block (groupname);
                            list.addGroup(group);
                            
                    }
                            
                }
                        
                
                else
                {
                    if (nickname == null)
                        System.out.println(Util.ERROR_GROUP_NICKNAME_TAG);
                    
                    if (groupname == null)
                        System.out.println(Util.ERROR_GROUP_GROUP_TAG);
                   
                }
                
                pos++;
            }
            
        }
        catch(JDOMParseException e)
        {
            System.out.println(Util.ERROR_XML_EMPTY_FILE);
            e.printStackTrace();
        }
        catch(JDOMException e)
        {
            System.out.println(Util.ERROR_XML_PROCESSING_FILE);
            e.printStackTrace();
        }
        catch(IOException e)
        {
            System.out.println(Util.ERROR_XML_PROCESSING_FILE);
            e.printStackTrace();
        }

    return list;
     }
     
     public static boolean addGroupToFile (String nickuser, String groupname)
     {
        Document    doc;
        Element     root, newChild;
        boolean res = false;
        
        SAXBuilder  builder = new SAXBuilder();

        try
        {
            doc = builder.build(Util.GROUPS_XML_PATH);

            root = doc.getRootElement();

            newChild = new Element(Util.GROUP_TAG);

            newChild.setAttribute(Util.GROUP_NICKNAME_TAG, nickuser);
            newChild.setAttribute(Util.GROUP_GROUP_TAG, groupname);
            
            root.addContent(newChild);
            
            res=true;

            try
            {
                Format format = Format.getPrettyFormat();
             
                XMLOutputter out = new XMLOutputter(format);

                FileOutputStream file = new FileOutputStream(Util.GROUPS_XML_PATH);

                out.output(doc,file);

                file.flush();
                file.close();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        catch(JDOMParseException e)
        {
            System.out.println(Util.ERROR_XML_EMPTY_FILE);
            e.printStackTrace();
        }
        catch(JDOMException e)
        {
            System.out.println(Util.ERROR_XML_PROCESSING_FILE);
            e.printStackTrace();
        }
        catch(IOException e)
        {
            System.out.println(Util.ERROR_XML_PROCESSING_FILE);
            e.printStackTrace();
        }

        return res;
     }
     public static BlockList readAllFriendsFromFile(String nicknameuser) throws ParseException
    {
        Block           group = null;
        BlockList       list = null;
        User            userfriend = null;
        Document        doc;
        Element         root,child;
        List <Element>  rootChildrens;
        String          nickname1, nickname2, groupname, friendship;
        int             pos = 0;

        SAXBuilder      builder = new SAXBuilder();

        try
        {
            doc = builder.build(Util.BLOCKS_XML_PATH);
            root = doc.getRootElement();

            rootChildrens = root.getChildren();

            while (pos < rootChildrens.size())
            {
                child = rootChildrens.get(pos);

                nickname1        = child.getAttributeValue(Util.BLOCK_NICKNAME1_TAG);
                nickname2        = child.getAttributeValue(Util.BLOCK_NICKNAME2_TAG);
                groupname        = child.getAttributeValue(Util.BLOCK_GROUP_TAG);
                friendship       = child.getAttributeValue(Util.BLOCK_FRIENDSHIP_TAG);

                if(nickname1  != null && nickname2 != null && groupname != null &&
                   friendship != null && nickname1.equals(nicknameuser) && 
                   friendship.compareTo("true")==0)
                {
                    userfriend = UserXmlFile.readObjectFromFile(nickname2);
                    
                    if (userfriend!=null)
                    {
                        
                        if (list==null) {
                            list = new BlockList();
                            group = new Block (groupname);
                            group.getUserList().addUser(userfriend);
                            list.addGroup(group);
                            
                            
                        }
                        else
                        {
                                                
                        if (list.checkGroup(groupname,list)==false){
                            
                            
                            
                            group = new Block (groupname);
                            group.getUserList().addUser(userfriend);
                            list.addGroup(group);
                            
                        }
                             else 
                               {
                            
                            //System.out.println("Entra e check roup == true");
                            
                            group = list.get(groupname,list);
                            group.getUserList().addUser(userfriend);  
                            
                        }
                            
                        }
                        
                        
                    }
                    else
                        System.out.println(Util.ERROR_USER_NICKNAME_TAG);
                    
                    
                }
                else
                {
                    if (nickname1 == null)
                        System.out.println(Util.ERROR_BLOCK_NICKNAME1_TAG);
                    
                    if (nickname2 == null)
                        System.out.println(Util.ERROR_BLOCK_NICKNAME2_TAG);

                    if (groupname == null)
                        System.out.println(Util.ERROR_BLOCK_GROUP_TAG);
                    
                    if (friendship == null)
                        System.out.println(Util.ERROR_BLOCK_FRIENDSHIP_TAG);
                
                
                }
                
                pos++;
            }
            
        }
        catch(JDOMParseException e)
        {
            System.out.println(Util.ERROR_XML_EMPTY_FILE);
            e.printStackTrace();
        }
        catch(JDOMException e)
        {
            System.out.println(Util.ERROR_XML_PROCESSING_FILE);
            e.printStackTrace();
        }
        catch(IOException e)
        {
            System.out.println(Util.ERROR_XML_PROCESSING_FILE);
            e.printStackTrace();
        }


        return list;
    }
}

