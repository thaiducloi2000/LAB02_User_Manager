/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.UserDAO;
import DBUtils.CopyFile;
import DTO.UserDTO;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author PC
 */
@WebServlet(name = "CreateController", urlPatterns = {"/CreateController"})
public class CreateController extends HttpServlet {

    private static final String SUCCESS="search.jsp";
    private static final String ERROR="create_account.jsp"; 
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	String url=ERROR;
	try {
	    String userID=request.getParameter("userID");
	    String userName=request.getParameter("userName");
	    String password=request.getParameter("password");
	    String phoneNo=request.getParameter("phoneNo");
	    String roleID=request.getParameter("roleID");
	    String img=request.getParameter("img");
	    int lastIndex = img.lastIndexOf("\\");
            String imgaName = img.substring(lastIndex + 1);
	    if(!img.isEmpty()){
		if(img.contains(".png")|| img.contains(".jpg")){
		    File head=new File(img);
		    File tail=new File("E:\\Program Files\\New world\\For Studying\\pc1438\\LAB231\\LAB02_User_Manager\\web\\CSS\\image\\"+ imgaName);
		    CopyFile.copyFileUsingStream(head, tail);
		}else{
		    
		}
	    }	    
	    UserDAO dao=new UserDAO();
	    UserDTO user=new UserDTO(userID, userName, dao.hashPassword(password), "CSS\\image\\"+imgaName, phoneNo, roleID, "","");
	    boolean check=dao.insertUser(user);
	    if(check){
		List<UserDTO> list=dao.getAll();
		HttpSession session=request.getSession();
		session.setAttribute("LIST_USER", list);
		request.setAttribute("LIST_User", list);
		url=SUCCESS;
	    }
	} catch (Exception e) {
	}finally{
	    request.getRequestDispatcher(url).forward(request, response);
	}
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
	return "Short description";
    }// </editor-fold>

}
