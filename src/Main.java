import java.util.List;
import model.Recommendation;
import model.User;
import service.RecommendationEngine;
import service.UserService;

public class Main {

    public static void main(String[] args) {

        System.out.println("=====================================");
        System.out.println("      JOB RECOMMENDATION ENGINE      ");
        System.out.println("=====================================");

        UserService userService = new UserService();

        User user = userService.createUser();

        RecommendationEngine engine = new RecommendationEngine();

        List<Recommendation> recommendations =
                engine.recommendJobs(user);

        System.out.println("\n=====================================");
        System.out.println(" Hello, " + user.getName());
        System.out.println(" Recommended Jobs For You");
        System.out.println("=====================================\n");

        int rank = 1;
        for (Recommendation recommendation : recommendations) {

    if (recommendation.getMatchPercentage() > 0) {

        // Print job ONCE
       System.out.println("\n==================================================");
       System.out.println("Rank #" + rank);
       System.out.println("==================================================");

    System.out.println("Job Title : "
            + recommendation.getJob().getTitle());

    System.out.println("Company   : "
            + recommendation.getJob().getCompany());

    System.out.println("Location  : "
            + recommendation.getJob().getLocation());

    System.out.println("Salary    : "
            + recommendation.getJob().getSalary()
            + " LPA");

    System.out.println("Match     : "
            + String.format("%.2f",
            recommendation.getMatchPercentage())
            + "%");

    System.out.println("\nMissing Skills:");

    for(String skill : recommendation.getMissingSkills()) {
        System.out.println("->" + skill);
    }

    System.out.println("\nLearning Recommendations:");

    for(String skill : recommendation.getMissingSkills()) {
        showLearningPath(skill);
    }
    String level;
    System.out.println();

    if(recommendation.getMatchPercentage() >= 80)
        level = "Excellent Match";
    else if(recommendation.getMatchPercentage() >= 60)
        level = "Good Match";
    else
        level = "Needs Improvement";

    System.out.println("Status : " + level);

    System.out.println("\n--------------------------------------------------");
            System.out.println();

        rank++;
    }
}


        if (rank == 1) {
            System.out.println("No matching jobs found.");
        }

        System.out.println("\n=====================================");
        System.out.println("      Thank You For Using JRE        ");
        System.out.println("=====================================");
    }
    private static void showLearningPath(String skill) {

    switch(skill.toLowerCase()) {

        case "spring":
            System.out.println("  -> Learn Spring Boot");
            System.out.println("  -> Learn REST APIs");
            break;

        case "mysql":
            System.out.println("  -> Learn MySQL Queries");
            System.out.println("  -> Learn Database Design");
            break;

        case "powerbi":
            System.out.println("  -> Learn Power BI Dashboard");
            System.out.println("  -> Learn Data Visualization");
            break;

        case "oop":
            System.out.println("  -> Learn OOP Concepts");
            System.out.println("  -> Practice Java Projects");
            break;

        default:
            System.out.println("  -> Learn " + skill);
    }
}
}