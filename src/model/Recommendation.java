package model;

import java.util.List;

public class Recommendation {

    private Job job;
    private double matchPercentage;
    private List<String> missingSkills;

    public Recommendation(Job job,
                          double matchPercentage,
                          List<String> missingSkills) {

        this.job = job;
        this.matchPercentage = matchPercentage;
        this.missingSkills = missingSkills;
    }

    public Job getJob() {
        return job;
    }

    public double getMatchPercentage() {
        return matchPercentage;
    }

    public List<String> getMissingSkills() {
        return missingSkills;
    }
}