    /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;
import domain.BlockList;
import domain.StandardObject;
import domain.User;
import domain.UserXmlFile;
import java.io.File;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import jsockets.client.SocketClient;
import jsockets.server.logic.ServerLogic;
import jsockets.util.UtilFunctions;
import java.io.OutputStream.*;
import java.lang.String;

/**
GESTION DE PETICION
 */
public class RequestManagement implements ServerLogic {

    private final String SEPARADOR_PROTOCOLO = ":";
    private int operacion;
    //private UserList users;
    @Override

    public byte[] executeOperation(Object arg) {
        byte[] resultado = null;

        StandardObject standardObject = (StandardObject) arg;

        // se obtiene el protocolo y se separa mediante split por el separador
        // para este ejemplo ":"
        String[] protocol = standardObject.getProtocolo().toString().split(SEPARADOR_PROTOCOLO);

        if (UtilFunctions.isNumeric(protocol[0])) {
            this.operacion = Integer.parseInt(protocol[0]);
        } else {
            throw new RuntimeException("Error.La operacion solicitada no se encuentra soportada");
        }
        
        // dependiendo del numero de operacion enviado en el protocolo:
        switch (this.operacion) {
            case 1: { // operation 1 "Sign Up"
                
                User user = new User();
                user = (User) standardObject.getObjeto();
                
                System.out.println("Se recibio del cliente: " + user.getNickname());
                
                boolean def = UserXmlFile.readObjectFromFile(user.getNickname(), true);
                
                if (def == false){
                    
                    UserXmlFile.saveObjectToFile(user);
                    resultado = UtilFunctions.stringToByteArray("TRUE");
                    System.out.println("Se ha resgistrado al cliente: " + user.getNickname());
                
                }
                else{
                    System.out.println("Error registrando al cliente: " + user.getNickname());
                    System.out.println("Nickname Repeated");
                
                    resultado = UtilFunctions.stringToByteArray("FALSE:Nickname Repeated");
                }
                
                break;
            }
            case 2: { // operation 2 "Log In"
                
                System.out.println("Se recibio del cliente: " + protocol[1]);
                
                boolean conf = UserXmlFile.readObjectFromFile(protocol[1], protocol[2]);
                boolean login = false;
                //System.out.println (conf);
                
                if (conf == true ){
                
                    User user = new User();
                   
                    try {
                    user = UserXmlFile.readObjectFromFile(protocol[1]);
                    }
                    catch (ParseException ex) {
                    Logger.getLogger(RequestManagement.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    System.out.println(protocol[3]);
                    System.out.println(protocol[4]);
                    try {
                        login = UserXmlFile.updateStatusInFile(protocol[1], true, protocol[3], protocol[4]);
                       // System.out.println("Status update");
                    } 
                    catch (ParseException ex) {
                        Logger.getLogger(RequestManagement.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    resultado = UtilFunctions.objectToByteArray(user);
                    
               
                               
                //Avisarle a sus amigos
                boolean act;  
    
     
                String proto = "8:"+protocol[1];
                
              BlockList list=null;
                
            try {
                //leer amigos del que se conecto
              // BlockList list1 = UserXmlFile.readGroupsFromFile(protocol[1]);
                list = UserXmlFile.readAllFriendsFromFile(protocol[1]);
            } catch (ParseException ex) {
                Logger.getLogger(RequestManagement.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            if (list!=null) {
                
                int i=0;
                
                
        
        
                while (i<list.size()){ //Recorrolistadegrupos
            
                    int k=0;
            
                    while (k<list.get(i).getUserList().size()) {
                        //recorro todos los amigos
                        String friend = list.get(i).getUserList().get(k).getNickname();
                        User user2=null;
                        
                    try { //leo el amigo
                        user2 = UserXmlFile.readObjectFromFile(friend);
                    } catch (ParseException ex) {
                        Logger.getLogger(RequestManagement.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                        BlockList listact=null;
                        
                    try { //leo los amigos de su amigo xD
                      // BlockList listact1 = UserXmlFile.readGroupsFromFile(friend);
                        listact = UserXmlFile.readAllFriendsFromFile(friend);
                    } catch (ParseException ex) {
                        Logger.getLogger(RequestManagement.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    if (user2.isOnline()==true)
                    {
                       int port = Integer.parseInt(user2.getPort().trim());
                       

                       enviarRespuesta(proto,listact,user2.getIp(),port);
                       
                       System.out.print("se envio a "+friend);
                    }
                    else{
                        System.out.println("no se envio xq esta off line");
                    }
                        
                        k++;
                    }
            
                    i++;
                }
            }
                }
                else{
                    
                    resultado = UtilFunctions.objectToByteArray(null);
                     
                }
                     
                
                break;
            }
            case 3: {
            
                System.out.println("Se recibio del cliente: " + protocol[1]);
                User user= null;
            
               
                    if(protocol[3].compareTo("2")== 0)
                    {
                        boolean act;  
  
               System.out.println("holaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
                
                 BlockList list=null;
                try {
                    list = UserXmlFile.readAllFriendsFromFile(protocol[1]);
                } catch (ParseException ex) {
                    Logger.getLogger(RequestManagement.class.getName()).log(Level.SEVERE, null, ex);
                }
                 if (list!=null) 
                 {
                
                int i=0;
                
                
        
        
                while (i<list.size()){ //Recorrolistadegrupos
            
                    int k=0;
            
                    while (k<list.get(i).getUserList().size()) {
                        //recorro todos los amigos
                        String friend = list.get(i).getUserList().get(k).getNickname();
                        User user2=null;
                        
                    try { //leo el amigo
                        user2 = UserXmlFile.readObjectFromFile(friend);
                    } catch (ParseException ex) {
                        Logger.getLogger(RequestManagement.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                        BlockList listact=null;
                        
                    try { //leo los amigos de su amigo xD
                      // BlockList listact1 = UserXmlFile.readGroupsFromFile(friend);
                        listact = UserXmlFile.readAllFriendsFromFile(friend);
                    } catch (ParseException ex) {
                        Logger.getLogger(RequestManagement.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    if (user2.isOnline()==true)
                    {
                        System.out.println(user2.getNickname());
                         String proto = "3:"+protocol[1]+":"+protocol[2]+":2";
                       int port = Integer.parseInt(user2.getPort().trim());
                       

                       enviarRespuesta(proto,listact,user2.getIp(),port);
                       
                       System.out.print("se envio a "+friend);
                    }
                    else{
                        System.out.println("no se envio xq esta off line");
                    }
                        
                        k++;
                    }
            
                    i++;
                }
            }
                    }
                 else
                    {
                try {
                    user= UserXmlFile.readObjectFromFile(protocol[1]);
                } catch (ParseException ex) {
                    Logger.getLogger(RequestManagement.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (user!=null)
                {
                  
                if(user.isOnline()==true)
                {
                    SocketClient    cliente;
                    byte[] resultado2;
                    
                    String proto ="3:"+user.getNickname()+":"+protocol[2]+":"+protocol[3];
                    
                    int port = Integer.parseInt(user.getPort());
                    cliente = new SocketClient(false);
                  
                    StandardObject generalObject = new StandardObject (proto,null);
                    resultado2 = cliente.executeRequest(generalObject, user.getIp(), port);   
                       
                       
                       System.out.print("se envio a "+user.getNickname());
                        resultado = UtilFunctions.stringToByteArray("TRUE");
                }
                else
                {
                    System.out.println("no se envio xq esta off line");
                resultado = UtilFunctions.stringToByteArray("FALSE");
                }
                
                }
                else
                {
                    System.out.println("no se envio xq esta off line");
              
                }
       
            

                    }
            break;
            }
            case 4:
            {
                 File fileImagen;
                 
                
                System.out.println("Se recibio del cliente: " + protocol[1]);
                User user= null;
            try {
                user= UserXmlFile.readObjectFromFile(protocol[1]);
            } catch (ParseException ex) {
                Logger.getLogger(RequestManagement.class.getName()).log(Level.SEVERE, null, ex);
            }
                if (user!=null)
                {
                if(user.isOnline()==true)
                {
                    SocketClient    cliente;
                    byte[] resultado2;
                    String proto ="4:"+user.getNickname()+":"+protocol[2];
                    byte[] img;
               img= (byte[]) standardObject.getObjeto();
                    int port = Integer.parseInt(user.getPort());
                    cliente = new SocketClient(false);
                  
                    StandardObject generalObject = new StandardObject (proto,img);
                    resultado2 = cliente.executeRequest(generalObject, user.getIp(), port);   
                       
                       
                       System.out.print("se envio a "+user.getNickname());
                }
                }
                else
                    System.out.println("no se envio xq esta off line");
         
            break;
            }
            case 5: { // operation 5 "Log Out"
                System.out.println("Se recibio del cliente: " + protocol[1]);
                
                boolean conf = false;
            
                try {
                    conf = UserXmlFile.updateStatusInFile(protocol[1], false);
                } 
                catch (ParseException ex) {
                    Logger.getLogger(RequestManagement.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                if (conf == true ){
                    
                    resultado = UtilFunctions.stringToByteArray("TRUE");
                    
                    //Avisarle a sus amigos
                boolean act;  
                byte[] resultado2;
     
                String proto = "8:"+protocol[1];
                
                BlockList list=null;
                
            try {
                //leer amigos del que se desconecto
               // BlockList list1 = UserXmlFile.readGroupsFromFile(protocol[1]);
                list = UserXmlFile.readAllFriendsFromFile(protocol[1]);
            } catch (ParseException ex) {
                Logger.getLogger(RequestManagement.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            if (list!=null) {
                
                int i=0;
                
                
        SocketClient usersocket = new SocketClient();
        
                while (i<list.size()){ //Recorrolistadegrupos
            
                    int k=0;
            
                    while (k<list.get(i).getUserList().size()) {
                        //recorro todos los amigos
                        String friend = list.get(i).getUserList().get(k).getNickname();
                        User user2=null;
                        
                    try { //leo el amigo
                        user2 = UserXmlFile.readObjectFromFile(friend);
                    } catch (ParseException ex) {
                        Logger.getLogger(RequestManagement.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                        BlockList listact=null;
                        
                    try { //leo los amigos de su amigo xD
                       // BlockList listact1 = UserXmlFile.readGroupsFromFile(friend);
                        listact = UserXmlFile.readAllFriendsFromFile(friend);
                    } catch (ParseException ex) {
                        Logger.getLogger(RequestManagement.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    if (user2.isOnline()==true){
                       int port = Integer.parseInt(user2.getPort());
                       
                    
               
                      
                       
                    StandardObject generalObject = new StandardObject (proto,listact);
                       
                        resultado2 = usersocket.executeRequest(generalObject, user2.getIp(), port);
                        
                        String res = UtilFunctions.byteArrayToString(resultado2);
                       System.out.print("se envio a "+friend);
                    }
                    else{
                        System.out.println("no se envio xq esta off line");
                    }
                        
                        k++;
                    }
            
                    i++;
                }
            
                }
                }
                else{
                    
                    resultado = UtilFunctions.stringToByteArray("FALSE");
                
                }
                
                
                break;
            }
                
            case 6: { // operation 6 "Get Friends"
                System.out.println("Se recibio del cliente: " + protocol[1]);
                
                
                
                BlockList list = null;
                
                
                try {
                
                    System.out.flush();
                    //BlockList list1 = UserXmlFile.readGroupsFromFile(protocol[1]);
                    list = UserXmlFile.readAllFriendsFromFile(protocol[1]);
                 
                    } 
                catch (ParseException ex) {
                    System.out.println("Entro en el catch");
                    Logger.getLogger(RequestManagement.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                if (list != null ){
                    
                    resultado=UtilFunctions.objectToByteArray(list);
                    System.out.println("convirtio la lista en byte array");
                    
            }
                else{
                    
                    resultado = UtilFunctions.objectToByteArray(null);
                    System.out.println("la lista es nula");
                
                }
                
     break;
                
                
            }     
            
                
             case 8: { // operation 8 "Add Friend"
                System.out.println("Se recibio del cliente: " + protocol[2]);
                
                boolean conf = UserXmlFile.addFriendToFile(protocol[2], protocol[1], "Other Friends");
                
                if (conf == true ){
                    System.out.println("Se agrego la amistad");
                    resultado = UtilFunctions.stringToByteArray("TRUE");
                }
                else{
                    System.out.println("No se agrego la amistad");
                    resultado = UtilFunctions.stringToByteArray("FALSE");
                
                }
                
                
                break;
            }
                 
             case 13: { // operation 13 "Friend Information"
                System.out.println("Se recibio del cliente solicitud de amigo");
                
                boolean conf = UserXmlFile.readObjectFromFile(protocol[1], true);
                
                if (conf == true ){
                    System.out.println("El amigo existe");
                    resultado = UtilFunctions.stringToByteArray(protocol[1]);
                }
                else{
                    System.out.println("El amigo no existe");
                    resultado = UtilFunctions.stringToByteArray("FALSE");
                }
                
                
                break;
            }
                 
              case 10: { // operation 10 "Add Group

                System.out.println("Se recibio del cliente: " + protocol[1]);
                
                boolean conf1 = false;
                
                conf1 = UserXmlFile.addGroupToFile(protocol[1], protocol[2]);
                
                if (conf1 == true){
                    System.out.println("Se agrego el grupo");
                    resultado = UtilFunctions.stringToByteArray("TRUE");
                }
                else{
                    System.out.println("No se agrego el grupo");
                    resultado = UtilFunctions.stringToByteArray("FALSE");
                
                }
                
                
                
                
                break;
            }
                 
             
                 
             case 12: { // operation 12 "Delete Friend"
                System.out.println("Se recibio del cliente: " + protocol[1]);
                
                boolean conf1 = false;
                boolean conf2 = false;
                
                try {
                    conf1 = UserXmlFile.deleteFriendFromFile(protocol[1], protocol[2]);
                    conf2 = UserXmlFile.deleteFriendFromFile(protocol[2], protocol[1]);
                } catch (ParseException ex) {
                    Logger.getLogger(RequestManagement.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                if (conf1 == true & conf2 == true ){
                    System.out.println("Se borro la amistad");
                    resultado = UtilFunctions.stringToByteArray("TRUE");
                }
                else{
                    System.out.println("No se borro la amistad");
                    resultado = UtilFunctions.stringToByteArray("FALSE");
                
                }
                
                
                
                
                break;
            }
                
                
                
                
            
                
            default: { // cualquier otra operacion
                throw new RuntimeException("Error.La operacion solicitada no se encuentra soportada");
            }
        }

        return resultado;
    }
    public void enviarRespuesta(String proto,Object object, String ip, int port)
    {
        SocketClient    cliente;
        StandardObject  generalObject;
        //String          mensaje;
        byte[] resultado;
        
        cliente = new SocketClient(false);
        
        
        generalObject = new StandardObject(proto, object);
        resultado = cliente.executeRequest(generalObject, ip, port);
        
        System.out.println(" y el resultado fue: "+UtilFunctions.byteArrayToString(resultado));

    }
}
