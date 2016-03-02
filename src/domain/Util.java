/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author ricardocasanova
 */
public class Util
{
    public static       String USER_NICKNAME            = "";
    public static final String USER_TAG                 = "user";
    public static final String USER_NAME_TAG            = "name";
    public static final String USER_LASTNAME_TAG        = "lastname";
    public static final String USER_SECONDLASTNAME_TAG  = "secondlastname";
    public static final String USER_BIRTHDATE_TAG       = "birthdate";
    public static final String USER_NICKNAME_TAG        = "nickname";
    public static final String USER_MAIL_TAG            = "mail";
    public static final String USER_PASSWORD_TAG        = "password";
    public static final String USER_IP_TAG              = "ip";
    public static final String USER_PORT_TAG            = "port";
    public static final String USER_ACTIVE_TAG          = "active"; 
    public static final String USER_ONLINE_TAG          = "status";
    
    public static final String ERROR_USER_NAME_TAG              = "Error loading User from XML - Error in the attribute " + USER_NAME_TAG + " of the XML tag";
    public static final String ERROR_USER_LASTNAME_TAG          = "Error loading User from XML - Error in the attribute " + USER_LASTNAME_TAG + " of the XML tag";
    public static final String ERROR_USER_SECONDLASTNAME_TAG    = "Error loading User from XML - Error in the attribute " + USER_SECONDLASTNAME_TAG + " of the XML tag";
    public static final String ERROR_USER_NICKNAME_TAG          = "Error loading User from XML - Error in the attribute " + USER_NICKNAME_TAG + " of the XML tag";
    public static final String ERROR_USER_MAIL_TAG              = "Error loading User from XML - Error in the attribute " + USER_MAIL_TAG + " of the XML tag";
    public static final String ERROR_USER_PASSWORD_TAG          = "Error loading User from XML - Error in the attribute " + USER_PASSWORD_TAG + " of the XML tag";
    public static final String ERROR_USER_BIRTHDATE_TAG         = "Error loading User from XML - Error in the attribute " + USER_BIRTHDATE_TAG + " of the XML tag";
    public static final String ERROR_USER_IP_TAG                = "Error loading User from XML - Error in the attribute " + USER_IP_TAG + " of the XML tag";
    public static final String ERROR_USER_PORT_TAG              = "Error loading User from XML - Error in the attribute " + USER_PORT_TAG + " of the XML tag";
    public static final String ERROR_USER_ACTIVE_TAG            = "Error loading User from XML - Error in the attribute " + USER_ACTIVE_TAG + " of the XML tag";
    public static final String ERROR_USER_ONLINE_TAG            = "Error loading User from XML - Error in the attribute " + USER_ONLINE_TAG + " of the XML tag";
    
    public static final String BLOCK_TAG                = "blocks";
    public static final String BLOCK_NICKNAME1_TAG     = "nickname1";
    public static final String BLOCK_NICKNAME2_TAG     = "nickname2";
    public static final String BLOCK_GROUP_TAG         = "block";
    public static final String BLOCK_FRIENDSHIP_TAG    = "friendship";
    
    public static final String GROUP_TAG             = "group";
    public static final String GROUP_NICKNAME_TAG    = "nickname";
    public static final String GROUP_GROUP_TAG       = "group";
    
    public static final String ERROR_GROUP_NICKNAME_TAG    = "Error loading Group from XML - Error in the attribute " + GROUP_NICKNAME_TAG + " of the XML tag";
    public static final String ERROR_GROUP_GROUP_TAG       = "Error loading Group from XML - Error in the attribute " + GROUP_GROUP_TAG + " of the XML tag";
    
    public static final String ERROR_BLOCK_NICKNAME1_TAG       = "Error loading Friend from XML - Error in the attribute " + BLOCK_NICKNAME1_TAG + " of the XML tag";
    public static final String ERROR_BLOCK_NICKNAME2_TAG       = "Error loading Friend from XML - Error in the attribute " + BLOCK_NICKNAME2_TAG + " of the XML tag";
    public static final String ERROR_BLOCK_GROUP_TAG           = "Error loading Friend from XML - Error in the attribute " + BLOCK_GROUP_TAG + " of the XML tag";
    public static final String ERROR_BLOCK_FRIENDSHIP_TAG      = "Error loading Friend from XML - Error in the attribute " + BLOCK_FRIENDSHIP_TAG + " of the XML tag";
    
    public static final String ERROR_XML_EMPTY_FILE                 = "Error loading XML file - The file is empty";
    public static final String ERROR_XML_PROCESSING_FILE            = "Error loading XML file - It's not possible processing the file";
    public static final String ERROR_XML_USER_NICKNAME_NOT_EXIST    = "Error loading XML file - The User don't exist";
    
    public static final String USERS_XML_PATH           = "src/domain/xml/users.xml";
    public static final String BLOCKS_XML_PATH     = "src/domain/xml/blocks.xml";
    public static final String GROUPS_XML_PATH          = "src/domain/xml/groups.xml";
    
    }

