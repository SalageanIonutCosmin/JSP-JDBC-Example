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
        Integer id = Integer.valueOf(request.getParameter("id"));
        companyRepository = new CompanyRepository();

        Iterator<Company> iterator = companyRepository.findAllCompanies().iterator();

        while (iterator.hasNext()) {
            Company company = iterator.next();
            if (company.getId() == id) {
                companyRepository.deleteCompany(id);
                iterator.remove();
                break;
            }
        }
        response.sendRedirect("http://localhost:8080/JSPExample_war_exploded/company/list");
    }
}
