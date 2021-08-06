/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.io.Serializable;

/**
 *
 * @author PC
 */
public class UserDTO implements Serializable {

    private String userID;
    private String userName;
    private String password;
    private String img;
    private String phoneNo;
    private String roleID;
    private String status;
    private String promotion;

    public UserDTO(String userID, String userName, String password, String img, String phoneNo, String roleID, String status, String promotion) {
	this.userID = userID;
	this.userName = userName;
	this.password = password;
	this.img = img;
	this.phoneNo = phoneNo;
	this.roleID = roleID;
	this.status = status;
	this.promotion = promotion;
    }

    public String getUserID() {
	return userID;
    }

    public void setUserID(String userID) {
	this.userID = userID;
    }

    public String getUserName() {
	return userName;
    }

    public void setUserName(String userName) {
	this.userName = userName;
    }

    public String getPassword() {
	return password;
    }

    public void setPassword(String password) {
	this.password = password;
    }

    public String getImg() {
	return img;
    }

    public void setImg(String img) {
	this.img = img;
    }

    public String getPhoneNo() {
	return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
	this.phoneNo = phoneNo;
    }

    public String getRoleID() {
	return roleID;
    }

    public void setRoleID(String roleID) {
	this.roleID = roleID;
    }

    public String getStatus() {
	return status;
    }

    public void setStatus(String status) {
	this.status = status;
    }

    public String getPromotion() {
	return promotion;
    }

    public void setPromotion(String promotion) {
	this.promotion = promotion;
    }

}
