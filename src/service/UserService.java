package service;

import model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserService {

    private Scanner scanner = new Scanner(System.in);

    public User createUser() {

        System.out.print("Enter Your Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Skills (comma separated): ");
        String skillInput = scanner.nextLine();

        String[] skillsArray = skillInput.split(",");

        List<String> skills = new ArrayList<>();

        for (String skill : skillsArray) {
            skills.add(skill.trim().toLowerCase());
        }

        return new User(name, skills);
    }
}