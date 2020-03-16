package servlet;

import model.Company;
import repository.CompanyRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/company/list")
public class CompanyListServlet extends HttpServlet {
    private CompanyRepository companyRepository;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        companyRepository = new CompanyRepository();
        List<Company> companyList = companyRepository.findAllCompanies();
        request.setAttribute("companyList", companyList);
        request.getRequestDispatcher("/companyListView.jsp").forward(request, response);
    }
}
