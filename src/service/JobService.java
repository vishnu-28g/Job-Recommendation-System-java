package service;

import data.JobDatabase;
import model.Job;

import java.util.List;

public class JobService {

    public List<Job> getAllJobs() {
        return JobDatabase.getJobs();
    }
}
