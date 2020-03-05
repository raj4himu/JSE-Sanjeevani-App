/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalmanagementapp.pojo;

/**
 *
 * @author Himanshu raj
 */
public class UserProfile //This class is used for loggedin user hello+username.
{
    private static String username;//It is taken static beacause only one user to handle.
    private static String usertype;

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        UserProfile.username = username;
    }

    public static String getUsertype() {
        return usertype;
    }

    public static void setUsertype(String usertype) {
        UserProfile.usertype = usertype;
    }
    
    
}
