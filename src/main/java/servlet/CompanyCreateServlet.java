package servlet;

import model.Company;
import repository.CompanyRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/company/create")
public class CompanyCreateServlet extends HttpServlet {
    private CompanyRepository companyRepository;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("/companyAdd.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        companyRepository = new CompanyRepository();

        String name = request.getParameter("name");
        String domain = request.getParameter("domain");
        String createdAt = request.getParameter("createdAt");

        Company company = new Company();
        company.setName(name);
        company.setDomain(domain);
        company.setCreatedAt(createdAt);

        companyRepository.addCompany(company);

        request.setAttribute("company", company);

        request.getRequestDispatcher("/companyListView.jsp").forward(request, response);
    }

}
