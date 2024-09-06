package com.example.SpringbootApplication;

public class Main {
    public static void main(String[] args) {
        UserDao userDao = new UserDao();

        // Create table
        userDao.createTable();

        // Insert users
        userDao.insert(new User(0, "John Doe", "john.doe@example.com"));
        userDao.insert(new User(0, "Jane Doe", "jane.doe@example.com"));

        // Get all users
        System.out.println("All users:");
        for (User user : userDao.getAll()) {
            System.out.println(user.getId() + ": " + user.getName() + " (" + user.getEmail() + ")");
        }

        // Get user by id
        System.out.println("\nUser with ID 1:");
        User user = userDao.getById(1);
        if (user != null) {
            System.out.println(user.getId() + ": " + user.getName() + " (" + user.getEmail() + ")");
        }

        // Update user
        if (user != null) {
            user.setName("John Smith");
            user.setEmail("john.smith@example.com");
            userDao.update(user);
        }

        // Get all users after update
        System.out.println("\nAll users after update:");
        for (User u : userDao.getAll()) {
            System.out.println(u.getId() + ": " + u.getName() + " (" + u.getEmail() + ")");
        }

        // Delete user
        userDao.delete(1);

        // Get all users after delete
        System.out.println("\nAll users after delete:");
        for (User u : userDao.getAll()) {
            System.out.println(u.getId() + ": " + u.getName() + " (" + u.getEmail() + ")");
        }
    }
}
