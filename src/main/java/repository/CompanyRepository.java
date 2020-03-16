package repository;

import constants.Constants;
import model.Company;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CompanyRepository {

    private static final String ADD_COMPANY = "insert into company" + "(name,domain,createdAt) values" + "(?,?,?)";
    private static final String SELECT_COMPANY_BY_ID = "select id,name,domain,createdAt from company where id =?";
    private static final String SELECT_ALL_COMPANIES = "select * from company.company";
    private static final String DELETE_COMPANY = "delete from company where id = ?;";
    private static final String UPDATE_COMPANY = "update company set name = ?,domain= ?, createdAt =? where id = ?;";

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(Constants.URL, Constants.USER, Constants.PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    protected void disconnect() {
        Connection connection = null;
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Company findCompanyById(Integer id) {
        Company company = null;
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_COMPANY_BY_ID);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String domain = resultSet.getString("domain");
                String createdAt = resultSet.getString("createdAt");
                company = new Company(id, name, domain, createdAt);
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return company;
    }

    public List<Company> findAllCompanies() {
        List<Company> companyList = new ArrayList<Company>();
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_COMPANIES);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String domain = resultSet.getString("domain");
                String createdAt = resultSet.getString("createdAt");
                Company company = new Company(id, name, domain, createdAt);
                companyList.add(company);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        disconnect();
        return companyList;
    }

    public Company addCompany(Company company) {
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(ADD_COMPANY);
            preparedStatement.setString(1, company.getName());
            preparedStatement.setString(2, company.getDomain());
            preparedStatement.setString(3, company.getCreatedAt());
            preparedStatement.executeUpdate();

            disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return company;
    }

    public boolean deleteCompany(Company company) {
        boolean rowDeleted = false;
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_COMPANY);
            preparedStatement.setInt(1, company.getId());
            rowDeleted = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowDeleted;
    }

    public boolean updateCompany(Company company) {
        boolean rowUpdated = false;
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_COMPANY);
            preparedStatement.setInt(1, company.getId());
            preparedStatement.setString(2, company.getName());
            preparedStatement.setString(3, company.getDomain());
            preparedStatement.setString(4, company.getCreatedAt());

            rowUpdated = preparedStatement.executeUpdate() > 0;
            preparedStatement.close();
            disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowUpdated;
    }
}
