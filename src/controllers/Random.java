package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;


/**
 * Servlet implementation class Random
 */
@WebServlet("/Random")
public class Random extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Random() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String wordcount = (String) session.getAttribute("wordcount");
		if (wordcount == null) {
			wordcount = "0";
		}
		session.setAttribute("wordcount", wordcount);
		request.getRequestDispatcher("WEB-INF/views/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String wordcount = (String) session.getAttribute("wordcount");
		int wordnumber = Integer.parseInt(wordcount);
		wordnumber++;
		wordcount = Integer.toString(wordnumber);
		
		
		
		session.setAttribute("randomString", saltStr);
		session.setAttribute("wordcount", wordcount);
		response.sendRedirect("/RandomWord/Random");
	}

}
