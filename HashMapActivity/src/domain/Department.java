package domain;

public class Department
{
    private String depCode;
    private String depName;
    private Double depTotalSalary;

    public String getDepCode(String trim) {
        return depCode;
    }

    public void setDepCode(String depCode) {
        this.depCode = depCode;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public Double getDepTotalSalary() {
        return depTotalSalary;
    }

    public void setDepTotalSalary(Double depTotalSalary) {
        this.depTotalSalary = depTotalSalary;
    }
}
