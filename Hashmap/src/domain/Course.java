package domain;

public class Course
{
    private String courseCode;
    private String description;
    private Integer unit;
    private Double grade;

    public String getCourseCode() {
        return courseCode;
    }

    public String getDescription() {
        return description;
    }

    public Integer getUnit() {
        return unit;
    }

    public Double getGrade() {
        return grade;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setUnit(Integer unit) {
        this.unit = unit;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }
}
