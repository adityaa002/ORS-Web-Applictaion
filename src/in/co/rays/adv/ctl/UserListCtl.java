package in.co.rays.adv.ctl;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.adv.bean.UserBean;
import in.co.rays.adv.model.UserModel;

@WebServlet("/UserListCtl")
public class UserListCtl extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		UserModel model = new UserModel();

		UserBean bean = null;

		int pageNo = 1;

		int pageSize = 5;

		try {
			List list = model.search(bean, pageNo, pageSize);
			List nextList = model.search(bean, pageNo + 1, pageSize);
			req.setAttribute("list", list);
			req.setAttribute("nextList", nextList);
			req.setAttribute("pageNo", pageNo);

			RequestDispatcher rd = req.getRequestDispatcher("UserListView.jsp");
			rd.forward(req, resp);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		UserModel model = new UserModel();

		UserBean bean = null;

		int pageNo = 1;

		int pageSize = 5;

		String op = req.getParameter("operation");

		pageNo = Integer.parseInt(req.getParameter("pageNo"));

		if (op.equals("previous")) {
			pageNo--;

		}
		if (op.equals("add")) {

			resp.sendRedirect("AddUserCtl");

		}
		if (op.equals("next")) {
			pageNo++;

		}
		if (op.equals("delete")) {
			pageNo = 1;

			bean = new UserBean();
			String[] ids = req.getParameterValues("ids");

			if (ids != null && ids.length > 0) {
				for (String id : ids) {
					try {
						model.delete(Integer.parseInt(id));
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}

		}

		try {
			List list = model.search(bean, pageNo, pageSize);
			List nextList = model.search(bean, pageNo + 1, pageSize);

			req.setAttribute("list", list);
			req.setAttribute("nextList", nextList);
			req.setAttribute("pageNo", pageNo);

			RequestDispatcher rd = req.getRequestDispatcher("UserListView.jsp");
			rd.forward(req, resp);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
