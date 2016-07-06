package org.madbit.ejb.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.ejb.EJB;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.madbit.ejb.component.StatefulTestLocal;
import org.madbit.ejb.component.StatelessTestLocal;

@WebServlet(displayName="TestServlet", loadOnStartup=1, urlPatterns="/testServlet")
public class TestServlet extends HttpServlet {

	private static final long serialVersionUID = -3735124703362492065L;

	@EJB
	private StatelessTestLocal statelessTest;
	
	@EJB
	private StatefulTestLocal statefulTest;
	
	private InitialContext context;
	
	@Override
	public void init() throws ServletException {
		try { 
			context = new InitialContext();
		} catch (NamingException e) {
			throw new ServletException(e);
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		StatelessTestLocal statelessTest2;
		StatefulTestLocal statefulTest2;
		
		try {
			statelessTest2 = (StatelessTestLocal) context.lookup("java:global/ejb-test/ejb-components/EJBTestStateless!org.madbit.ejb.component.StatelessTestLocal");
			statefulTest2 = (StatefulTestLocal) context.lookup("java:global/ejb-test/ejb-components/EJBTestStateful!org.madbit.ejb.component.StatefulTestLocal");
		} catch (NamingException e) {
			throw new ServletException(e);
		}
		
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>Hello Servlet Get</h1>");
		out.println("<ul>");
		out.println("<li>Stateless count " + statelessTest.getNum() + "</li>");
		out.println("<li>Stateless2 count " + statelessTest2.getNum() + "</li>");
		out.println("<li>Stateful count " + statefulTest.getNum() + "</li>");
		out.println("<li>Stateful2 count " + statefulTest2.getNum() + "</li>");
		out.println("</ul>");
		
		statelessTest.increaseNum();
		statelessTest2.increaseNum();
		statefulTest.increaseNum();
		statefulTest2.increaseNum();
		
		out.println("<h2>After increase</h2>");

		out.println("<ul>");
		out.println("<li>Stateless count " + statelessTest.getNum() + "</li>");
		out.println("<li>Stateless2 count " + statelessTest2.getNum() + "</li>");
		out.println("<li>Stateful count " + statefulTest.getNum() + "</li>");
		out.println("<li>Stateful2 count " + statefulTest2.getNum() + "</li>");
		out.println("</ul>");
		out.println("</body>");
		out.println("</html>");
	}
}
