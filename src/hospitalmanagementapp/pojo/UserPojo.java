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
public class UserPojo {
    private String userId;
    private String password;
    private String userType;

    @Override
    public String toString() {
        return "UserPojo{" + "userId=" + userId + ", password=" + password + ", userType=" + userType + '}';
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
    
}
