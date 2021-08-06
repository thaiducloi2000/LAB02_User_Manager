/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DBUtils.DBUtils;
import DTO.PromotionDTO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PC
 */
public class PromotionDAO {
    
    public List<PromotionDTO> getListPromotion() throws SQLException{
	List<PromotionDTO> list=null;
	Connection conn = null;
	PreparedStatement stm = null;
	ResultSet rs = null;
	try {
	    conn = DBUtils.openConection();
	    if (conn != null) {
		String sql = "SELECT H.lastUpdate,H.addDay,H.lastPromotion,P.promotionID,H.userID"
			+ " FROM tblHistory H,tblPromotions P"
			+ " WHERE H.status='Active' AND H.promotionID=P.promotionID";
		stm = conn.prepareStatement(sql);		
		rs = stm.executeQuery();
		while (rs.next()) {
		    Date lastUpdate=rs.getDate("lastUpdate");
		    Date addDay=rs.getDate("addDay");
		    String lastPromotion=rs.getString("lastPromotion");
		    String promotionID=rs.getString("promotionID");
		    String userID=rs.getString("userID");
		    String status="Active";
		    if(list==null){
			list=new ArrayList<>();
		    }
		    list.add(new PromotionDTO(lastUpdate, addDay, lastPromotion, promotionID, userID, status));		    
		}
	    }
	} catch (Exception e) {
	} finally {
	    if (rs != null) {
		rs.close();
	    }
	    if (stm != null) {
		stm.close();
	    }
	    if (conn != null) {
		conn.close();
	    }
	}
	return list;
    }
    
    public boolean deleteUser(String userID) throws SQLException{
	boolean check=false;
	Connection conn = null;
	PreparedStatement stm = null;
	try {
	    conn = DBUtils.openConection();
	    if (conn != null) {
		String sql = "UPDATE  tblHistory SET status='Inactive'"
			+ " Where userID='" + userID + "'";
		stm = conn.prepareStatement(sql);
		
		check = stm.executeUpdate() > 0 ? true : false;
	    }
	} catch (Exception e) {
	} finally {
	    if (stm != null) {
		stm.close();
	    }
	    if (conn != null) {
		conn.close();
	    }
	}
	return check;
    }

    public boolean updatePromotion(String userID, String lastPromotion, String promotionID, Date Date) throws SQLException {
	boolean check=false;
	Connection conn = null;
	PreparedStatement stm = null;
	try {
	    conn = DBUtils.openConection();
	    if (conn != null) {
		String sql = "UPDATE  tblHistory SET "
			+ " lastPromotion='"+lastPromotion+"',"
			+ " promotionID='"+promotionID+"',"
			+ " lastUpdate='"+Date+"'"
			+ " Where userID='" + userID + "'";
		stm = conn.prepareStatement(sql);
		
		check = stm.executeUpdate() > 0 ? true : false;
	    }
	} catch (Exception e) {
	} finally {
	    if (stm != null) {
		stm.close();
	    }
	    if (conn != null) {
		conn.close();
	    }
	}
	return check;
    }
    
}
