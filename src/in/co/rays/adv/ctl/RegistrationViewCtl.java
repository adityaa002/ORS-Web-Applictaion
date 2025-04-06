package in.co.rays.adv.ctl;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.adv.bean.UserBean;
import in.co.rays.adv.model.UserModel;

@WebServlet("/RegistrationViewCtl")
public class RegistrationViewCtl extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.sendRedirect("RegistrationView.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.sendRedirect("RegistrationView.jsp");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");



		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");
		String loginId = req.getParameter("loginId");
		String password = req.getParameter("password");
		String dob = req.getParameter("dob");
		String address = req.getParameter("address");

		UserBean bean = new UserBean();
		bean.setFirstName(firstName);
		bean.setLastName(lastName);
		bean.setLoginId(loginId);
		bean.setPassword(password);
		try {
			bean.setDob(sdf.parse(dob));
		} catch (ParseException e) {
			System.out.println(e.getMessage());
		}
		bean.setAddress(address);

		UserModel model = new UserModel();
		try {
			model.add(bean);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(firstName);
		System.out.println(lastName);
		System.out.println(loginId);
		System.out.println(password);
		System.out.println(dob);
		System.out.println(address);

	}

}
