package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import java.util.*;
import java.text.SimpleDateFormat;


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
		
		String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		StringBuilder builder = new StringBuilder();
		int count = 10;
		while (count-- != 0) {
			int character = (int)(Math.random()*ALPHA_NUMERIC_STRING.length());
			builder.append(ALPHA_NUMERIC_STRING.charAt(character));
		}
		ALPHA_NUMERIC_STRING = builder.toString();
		

		String timeStamp = new SimpleDateFormat("EEE MMM dd, yyyy hh:mm").format(Calendar.getInstance().getTime());
		
		session.setAttribute("timeStamp", timeStamp);
		session.setAttribute("randomString", ALPHA_NUMERIC_STRING);
		session.setAttribute("wordcount", wordcount);
		response.sendRedirect("/RandomWord/Random");
	}

}
