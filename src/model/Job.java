package model;

import java.util.List;

public class Job {

    private int jobId;
    private String title;
    private String company;
    private List<String> requiredSkills;
    private String location;
    private double salary;

    public Job(int jobId,
               String title,
               String company,
               List<String> requiredSkills,
               String location,
               double salary) {

        this.jobId = jobId;
        this.title = title;
        this.company = company;
        this.requiredSkills = requiredSkills;
        this.location = location;
        this.salary = salary;
    }

    public int getJobId() {
        return jobId;
    }

    public String getTitle() {
        return title;
    }

    public String getCompany() {
        return company;
    }

    public List<String> getRequiredSkills() {
        return requiredSkills;
    }

    public String getLocation() {
        return location;
    }

    public double getSalary() {
        return salary;
    }
}