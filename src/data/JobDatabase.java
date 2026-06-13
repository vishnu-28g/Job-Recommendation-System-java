package data;

import java.io.*;
import java.util.*;
import model.Job;

public class JobDatabase {

    public static List<Job> getJobs() {

        List<Job> jobs = new ArrayList<>();

        try {

            BufferedReader br =
                    new BufferedReader(
                            new FileReader(
                                    "../resources/jobs.txt"));

            String line;

            while((line = br.readLine()) != null) {

                String[] parts = line.split(",");

                int id = Integer.parseInt(parts[0]);

                String company = parts[1];
                String title = parts[2];

                List<String> skills =
                        Arrays.asList(parts[3].split(" "));

                jobs.add(new Job(
        1,
        "Java Developer",
        "TCS",
        Arrays.asList("java", "sql", "spring"),
        "Chennai",
        6.5
));

jobs.add(new Job(
        2,
        "Web Developer",
        "Infosys",
        Arrays.asList("html", "css", "javascript"),
        "Bangalore",
        5.5
));

jobs.add(new Job(
        3,
        "Data Analyst",
        "Accenture",
        Arrays.asList("python", "sql", "powerbi"),
        "Hyderabad",
        7.0
));

jobs.add(new Job(
        4,
        "Software Engineer",
        "Wipro",
        Arrays.asList("java", "sql", "oop"),
        "Chennai",
        6.0
));

jobs.add(new Job(
        5,
        "Backend Developer",
        "Zoho",
        Arrays.asList("java", "spring", "mysql"),
        "Chennai",
        8.0
));

jobs.add(new Job(
        6,
        "SDE",
        "Amazon",
        Arrays.asList("java", "sql", "dsa"),
        "Bangalore",
        12.0
));
            }

            br.close();

        } catch(Exception e) {

            System.out.println(
                    "Error reading jobs file: "
                    + e.getMessage()
            );
        }

        return jobs;
    }
}