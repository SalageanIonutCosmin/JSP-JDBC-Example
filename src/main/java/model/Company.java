package model;

public class Company {
    private Integer id;
    private String name;
    private String domain;
    private String createdAt;

    public Company() {

    }

    public Company(String name, String domain, String createdAt) {
        this.name = name;
        this.domain = domain;
        this.createdAt = createdAt;
    }

    public Company(Integer id, String name, String domain, String createdAt) {
        this.id = id;
        this.name = name;
        this.domain = domain;
        this.createdAt = createdAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", domain='" + domain + '\'' +
                ", createdAt='" + createdAt + '\'' +
                '}';
    }
}
