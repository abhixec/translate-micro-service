package com.abhinav.example.backend;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import java.io.*;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.abhinav.example.translate.PigTranslate;

/**
 * Servlet implementation class BackendHttpServlet
 */
@WebServlet("/translate")
public class BackendHttpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json");
		String inputString = request.getParameter("input");
		System.out.println(inputString);
		ResponseDTO res = new ResponseDTO();
		ObjectMapper mapper = new ObjectMapper();
		String outputString = new PigTranslate().translate(inputString);
		res.setTranslateText(outputString);
		System.out.println(outputString);
		PrintWriter out = response.getWriter();
		mapper.writerWithDefaultPrettyPrinter().writeValue(out,res);
	}

}
