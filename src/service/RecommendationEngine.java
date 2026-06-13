package service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import model.Job;
import model.Recommendation;
import model.User;

public class RecommendationEngine {

    private JobService jobService = new JobService();

    public List<Recommendation> recommendJobs(User user) {

        List<Job> jobs = jobService.getAllJobs();

        List<Recommendation> recommendations = new ArrayList<>();

        for (Job job : jobs) {

            int matchCount = 0;
            List<String> missingSkills = new ArrayList<>();

            for (String requiredSkill : job.getRequiredSkills()) {

                if (user.getSkills().contains(requiredSkill.toLowerCase())) {
                    matchCount++;
                } else {
                     missingSkills.add(requiredSkill);
                }
            }

            double percentage =
                    ((double) matchCount / job.getRequiredSkills().size()) * 100;

            recommendations.add(
                new Recommendation(
                    job,
                    percentage,
                    missingSkills
                )
            );
            
        }

        recommendations.sort(
                Comparator.comparingDouble(
                        Recommendation::getMatchPercentage
                ).reversed()
        );

        return recommendations;
    }
}