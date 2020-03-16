package servlet;

import model.Company;
import repository.CompanyRepository;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/company/create")
public class CompanyCreateServlet extends HttpServlet {
    private CompanyRepository companyRepository;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        companyRepository = new CompanyRepository();
//        List<Company> companyList = companyRepository.findAllCompanies();
        String name = request.getParameter("name");
        String domain = request.getParameter("domain");
        String createdAt = request.getParameter("createdAt");

        Company company = new Company(name, domain, createdAt);
        companyRepository.addCompany(company);

        response.sendRedirect("http://localhost:8080/JSPExample_war_exploded/companyListView.jsp");
    }

}
