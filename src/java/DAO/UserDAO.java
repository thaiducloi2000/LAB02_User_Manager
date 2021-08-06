/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DBUtils.DBUtils;
import DTO.UserDTO;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
public class UserDAO {

    public UserDTO checklogin(String userID, String password) throws SQLException {
	UserDTO user = null;
	Connection conn = null;
	PreparedStatement stm = null;
	ResultSet rs = null;
	try {
	    conn = DBUtils.openConection();
	    if (conn != null) {
		String sql = "SELECT userID,userName,password,img,phoneNo,roleID"
			+ " FROM tblUsers "
			+ " WHERE userID='" + userID + "' AND password='" + password + "'";
		stm = conn.prepareStatement(sql);
		rs = stm.executeQuery();
		if (rs.next()) {
		    String userName = rs.getString("userName");
		    String img = rs.getString("img");
		    String phoneNo = rs.getString("phoneNo");
		    String role = rs.getString("roleID");
		    user = new UserDTO(userID, userName, password, img, phoneNo, role, "", "");
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
	return user;
    }

    public List<UserDTO> getListAll(String search) throws SQLException {
	List<UserDTO> list = null;
	Connection conn = null;
	PreparedStatement stm = null;
	ResultSet rs = null;
	try {
	    conn = DBUtils.openConection();
	    if (conn != null) {
		String sql = "SELECT userID,userName,img,phoneNo,roleID "
			+ " FROM tblUsers"
			+ " WHERE userName LIKE '%" + search + "%'"
			+ " AND status='Active' ";
		stm = conn.prepareStatement(sql);

		rs = stm.executeQuery();
		while (rs.next()) {
		    String userID = rs.getString("userID");
		    String userName = rs.getString("userName");
		    String img = rs.getString("img");
		    String phoneNo = rs.getString("phoneNo");
		    String roleID = rs.getString("roleID");
		    if (list == null) {
			list = new ArrayList<>();
		    }
		    list.add(new UserDTO(userID, userName, "", img, phoneNo, roleID, "", ""));
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
    
    public List<UserDTO> getAll() throws SQLException {
	List<UserDTO> list = null;
	Connection conn = null;
	PreparedStatement stm = null;
	ResultSet rs = null;
	try {
	    conn = DBUtils.openConection();
	    if (conn != null) {
		String sql = "SELECT userID,userName,img,phoneNo,roleID "
			+ " FROM tblUsers"
			+ " WHERE  status='Active' ";
		stm = conn.prepareStatement(sql);

		rs = stm.executeQuery();
		while (rs.next()) {
		    String userID = rs.getString("userID");
		    String userName = rs.getString("userName");
		    String img = rs.getString("img");
		    String phoneNo = rs.getString("phoneNo");
		    String roleID = rs.getString("roleID");
		    if (list == null) {
			list = new ArrayList<>();
		    }
		    list.add(new UserDTO(userID, userName, "", img, phoneNo, roleID, "", ""));
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

    public List<String> getListRole() throws SQLException {
	List<String> list = null;
	Connection conn = null;
	PreparedStatement stm = null;
	ResultSet rs = null;
	try {
	    conn = DBUtils.openConection();
	    if (conn != null) {
		String sql = "SELECT roleName "
			+ " FROM tblRole ";
		stm = conn.prepareStatement(sql);

		rs = stm.executeQuery();
		while (rs.next()) {
		    String role = rs.getString("roleName");
		    if (list == null) {
			list = new ArrayList<>();
		    }
		    list.add(role);
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

    public List<UserDTO> getUser(String search, String userID) throws SQLException {
	List<UserDTO> list = null;
	Connection conn = null;
	PreparedStatement stm = null;
	ResultSet rs = null;
	try {
	    conn = DBUtils.openConection();
	    if (conn != null) {
		String sql = "SELECT userName,img,phoneNo,roleID "
			+ " FROM tblUsers"
			+ " WHERE userID='" + userID + "' "
			+ " AND status='Active'";
		stm = conn.prepareStatement(sql);

		rs = stm.executeQuery();
		if (rs.next()) {
		    String userName = rs.getString("userName");
		    String img = rs.getString("img");
		    String phoneNo = rs.getString("phoneNo");
		    String roleID = rs.getString("roleID");
		    if (list == null) {
			list = new ArrayList<>();
		    }
		    list.add(new UserDTO(userID, userName, "", img, phoneNo, roleID, "", ""));
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

    public List<UserDTO> getListByRole(String role, List<UserDTO> list) {
	List<UserDTO> list1 = null;
	for (int i = 0; i < list.size() - 1; i++) {
	    if (list.get(i).getRoleID().equals(role)) {
		if (list1 == null) {
		    list1 = new ArrayList<>();
		}
		list1.add(list.get(i));
	    }
	}
	return list1;
    }

    public List<UserDTO> getListAsSub(String search, String roleID) throws SQLException {
	List<UserDTO> list = null;
	Connection conn = null;
	PreparedStatement stm = null;
	ResultSet rs = null;
	try {
	    conn = DBUtils.openConection();
	    if (conn != null) {
		String sql = "SELECT userID,userName,img,phoneNo,roleID "
			+ " FROM tblUsers"
			+ " WHERE userName LIKE '%" + search + "%' "
			+ " AND roleID='" + roleID + "' "
			+ " AND status='Active'";
		stm = conn.prepareStatement(sql);

		rs = stm.executeQuery();
		while (rs.next()) {
		    String userID = rs.getString("userID");
		    String userName = rs.getString("userName");
		    String img = rs.getString("img");
		    String phoneNo = rs.getString("phoneNo");
		    if (list == null) {
			list = new ArrayList<>();
		    }
		    list.add(new UserDTO(userID, userName, "", img, phoneNo, roleID, "", ""));
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

    public boolean deleteUser(String userID) throws SQLException {
	boolean check = false;
	Connection conn = null;
	PreparedStatement stm = null;
	try {
	    conn = DBUtils.openConection();
	    if (conn != null) {
		String sql = "UPDATE  tblUsers SET status='Inactive'"
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

    public boolean updateUser(UserDTO user) throws SQLException {
	boolean check = false;
	Connection conn = null;
	PreparedStatement stm = null;
	try {
	    conn = DBUtils.openConection();
	    String sql;
	    if (conn != null) {
		if (user.getPassword() == null) {
		    if (user.getImg().equals("CSS\\image\\")) {
			sql = "UPDATE  tblUsers SET userName='" + user.getUserName() + "', "
				+ " phoneNo='" + user.getPhoneNo() + "', "
				+ " roleID='" + user.getRoleID() + "'"
				+ " Where userID='" + user.getUserID() + "'";
		    } else {
			sql = "UPDATE  tblUsers SET userName='" + user.getUserName() + "', "
				+ " img='" + user.getImg() + "', "
				+ " phoneNo='" + user.getPhoneNo() + "', "
				+ " roleID='" + user.getRoleID() + "'"
				+ " Where userID='" + user.getUserID() + "'";
		    }
		} else {
		    if (user.getImg().equals("CSS\\image\\")) {
			sql = "UPDATE  tblUsers SET userName='" + user.getUserName() + "', "
				+ " password='" + user.getPassword() + "', "
				+ " phoneNo='" + user.getPhoneNo() + "', "
				+ " roleID='" + user.getRoleID() + "'"
				+ " Where userID='" + user.getUserID() + "'";
		    } else {
			sql = "UPDATE  tblUsers SET userName='" + user.getUserName() + "', "
				+ " password='" + user.getPassword() + "', "
				+ " phoneNo='" + user.getPhoneNo() + "', "
				+ " roleID='" + user.getRoleID() + "'"
				+ " Where userID='" + user.getUserID() + "'";
		    }
		}
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

    private static String bytesToHex(byte[] hash) {
	StringBuilder hexString = new StringBuilder(2 * hash.length);
	for (int i = 0; i < hash.length; i++) {
	    String hex = Integer.toHexString(0xff & hash[i]);
	    if (hex.length() == 1) {
		hexString.append('0');
	    }
	    hexString.append(hex);
	}
	return hexString.toString().toUpperCase();
    }

    public String hashPassword(String password) throws NoSuchAlgorithmException {
	MessageDigest digest = MessageDigest.getInstance("SHA-256");
	byte[] encodedhash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
	return bytesToHex(encodedhash);
    }

    public boolean insertUser(UserDTO user) throws SQLException {
	boolean check = false;
	Connection conn = null;
	PreparedStatement stm = null;
	try {
	    conn = DBUtils.openConection();
	    if (conn != null) {
		String sql = "INSERT INTO tblUsers(userID,userName,password,img,phoneNo,roleID,status) "
			+ " VALUES (?,?,?,?,?,?,'Active')";
		stm = conn.prepareStatement(sql);
		stm.setString(1, user.getUserID());
		stm.setString(2, user.getUserName());
		stm.setString(3, user.getPassword());
		stm.setString(4, user.getImg());
		stm.setString(5, user.getPhoneNo());
		stm.setString(6, user.getRoleID());
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

    public boolean addPromotion(String userID) throws SQLException {
	boolean check = false;
	Connection conn = null;
	PreparedStatement stm = null;
	try {
	    conn = DBUtils.openConection();
	    if (conn != null) {
		String sql = "UPDATE  tblUsers SET promotionID='R5'"
			+ " WHERE userID='" + userID + "'";
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
    
    public boolean addHistory(String userID,Date dateAdd) throws SQLException{
	boolean check=false;
	Connection conn = null;
	PreparedStatement stm = null;
	try {
	    conn = DBUtils.openConection();
	    if (conn != null) {
		String sql = "INSERT INTO tblHistory(lastUpdate,addDay,lastPromotion,promotionID,userID,status)"
			+ " VALUES (?,?,?,?,?,'Active')";		
		stm = conn.prepareStatement(sql);
		stm.setDate(1, dateAdd);
		stm.setDate(2, dateAdd);
		stm.setString(3, "R5");
		stm.setString(4, "R5");
		stm.setString(5, userID);
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
