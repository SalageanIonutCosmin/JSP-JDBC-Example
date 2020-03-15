package servlet;

import model.Company;
import repository.CompanyRepository;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Iterator;

@WebServlet("/company/delete")
public class CompanyDeleteServlet extends HttpServlet {
    private CompanyRepository companyRepository;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        Iterator<Company> iterator = companyRepository.findAllCompanies().iterator();

        while (iterator.hasNext()) {
            if (iterator.next().getId() == id) {
                iterator.remove();
                break;
            }
        }
        response.sendRedirect("/company/list");
    }
}
