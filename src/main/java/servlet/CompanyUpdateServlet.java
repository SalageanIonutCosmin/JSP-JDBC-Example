package servlet;

import model.Company;
import repository.CompanyRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/company/update")
public class CompanyUpdateServlet extends HttpServlet {
    private CompanyRepository companyRepository;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));

        Company companyToBeUpdated = null;

        for (Company company : companyRepository.findAllCompanies()) {
            if (company.getId() == id) {
                companyToBeUpdated = company;
            }
        }
        request.setAttribute("companyToBeUpdated", companyToBeUpdated);
        request.getRequestDispatcher("/companyUpdate.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String domain = request.getParameter("domain");
        String createdAt = request.getParameter("createdAt");

        for (Company company : companyRepository.findAllCompanies()) {
            if (company.getId() == id) {
                company.setName(name);
                company.setDomain(domain);
                company.setCreatedAt(createdAt);
            }
        }
        response.sendRedirect("/company/list");
    }
}
