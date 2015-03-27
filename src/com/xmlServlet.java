package com;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

/**
 * Servlet implementation class xmlServlet
 */
public class xmlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String s = request.getParameter("param");
		System.out.println(s);

		response.getOutputStream().print("ok");
	}

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();

		ServletContext content = getServletContext();
		// 获取src 下的文件
		// System.out.println(content.getRealPath("/person.xml"));

		// 获取webContent下的文件
		InputStream in = content.getResourceAsStream("/person.xml");
		SAXBuilder builder = new SAXBuilder();
		Document doc = null;
		try {
			doc = builder.build(in);
			Element element = doc.getRootElement();
			List<Element> list = element.getChildren();
			for (Element ele : list) {
				String id = ele.getAttributeValue("id");
				System.out.println(id);

				String name = ele.getChildText("name");
				System.out.println(name);
			}

		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
