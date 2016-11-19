/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cf.bean;

import java.io.Serializable;

/**
 *
 * @author apple
 */
public class UserInfo implements Serializable{
    int id;
    String loginId;
    String password;
    String userName;
    String sex;
    String birthday;
    int tel;
    String email;
    String address;
    double bonusPoints;

    public UserInfo() {
    }

    
    public UserInfo(int id, String loginId, String password, String userName, String sex, String birthday, int tel, String email, String address, double bonusPoints) {
        this.id = id;
        this.loginId = loginId;
        this.password = password;
        this.userName = userName;
        this.sex = sex;
        this.birthday = birthday;
        this.tel = tel;
        this.email = email;
        this.address = address;
        this.bonusPoints = bonusPoints;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getBonusPoints() {
        return bonusPoints;
    }

    public void setBonusPoints(double bonusPoints) {
        this.bonusPoints = bonusPoints;
    }
    
    
}
