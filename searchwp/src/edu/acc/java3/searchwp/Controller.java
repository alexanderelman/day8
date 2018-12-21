package edu.acc.java3.searchwp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import java.util.regex.*;
import java.util.stream.*;
import javax.servlet.http.*;


public class Controller extends HttpServlet {
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException {
		String term = request.getParameter("term");
		if (term == null || term.length() == 0) {
			request.setAttribute("flash", "Search Term Required");
		}
		else {
			ServletContext sc = this.getServletContext();
			InputStream is = sc.getResourceAsStream("/WEB-INF/war_and_peace.txt");
			List<Integer> lineNumbers = new ArrayList<>();
			int lineno = 0, count = 0;
			Pattern patt = Pattern.compile(term, Pattern.CASE_INSENSITIVE);
			try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
				List<String> lines = br.lines().collect(Collectors.toList());
				for (String line : lines) {
					int occurrencesOnLine = 0;
					lineno++;
					Matcher m = patt.matcher(line);
					while (m.find()) occurrencesOnLine++;
					if (occurrencesOnLine > 0) {
						lineNumbers.add(lineno);
						count += occurrencesOnLine;
					}
				}
				request.setAttribute("count", count);
				request.setAttribute("lines", lineNumbers);
				request.setAttribute("countPL", count == 1 ? "" : "s");
				request.setAttribute("linePL", lineNumbers.size() == 1 ? "" : "s");
			} catch (Exception e) {
				request.setAttribute("flash", e.getMessage());
			}
		}
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
}