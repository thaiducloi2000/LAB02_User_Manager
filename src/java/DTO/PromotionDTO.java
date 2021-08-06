/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.sql.Date;

/**
 *
 * @author PC
 */
public class PromotionDTO {
    private Date lastUpdate;
    private Date addDay;
    private String lastPromotion;
    private String promotionID;
    private String userID;
    private String Status;

    public PromotionDTO(Date lastUpdate, Date addDay, String lastPromotion, String promotionID, String userID, String Status) {
	this.lastUpdate = lastUpdate;
	this.addDay = addDay;
	this.lastPromotion = lastPromotion;
	this.promotionID = promotionID;
	this.userID = userID;
	this.Status = Status;
    }

    public Date getLastUpdate() {
	return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
	this.lastUpdate = lastUpdate;
    }

    public Date getAddDay() {
	return addDay;
    }

    public void setAddDay(Date addDay) {
	this.addDay = addDay;
    }

    public String getLastPromotion() {
	return lastPromotion;
    }

    public void setLastPromotion(String lastPromotion) {
	this.lastPromotion = lastPromotion;
    }

    public String getPromotionID() {
	return promotionID;
    }

    public void setPromotionID(String promotionID) {
	this.promotionID = promotionID;
    }

    public String getUserID() {
	return userID;
    }

    public void setUserID(String userID) {
	this.userID = userID;
    }

    public String getStatus() {
	return Status;
    }

    public void setStatus(String Status) {
	this.Status = Status;
    }
    
    
}
