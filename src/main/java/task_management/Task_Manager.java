package task_management;

import java.util.*;

public class Task_Manager {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- Task Management System ---");
            System.out.println("1. Add New Task");
            System.out.println("2. View All Tasks");
            System.out.println("3. Update Task");
            System.out.println("4. Delete Task");
            System.out.println("5. Mark Task as Completed");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> addTask();
                case 2 -> viewTasks();
                case 3 -> updateTask();
                case 4 -> deleteTask();
                case 5 -> markCompleted();
                case 6 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    private static void addTask() {
        List<Task> tasks = TaskUtils.readTasks();

        System.out.print("Enter Task ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (Task t : tasks) {
            if (t.getTaskId() == id) {
                System.out.println("Task ID already exists!");
                return;
            }
        }

        System.out.print("Enter Description: ");
        String desc = sc.nextLine();

        System.out.print("Enter Due Date: ");
        String date = sc.nextLine();

        Task task = new Task(id, desc, date, false);
        tasks.add(task);

        TaskUtils.writeTasks(tasks);
        System.out.println("Task added successfully!");
    }

    private static void viewTasks() {
        List<Task> tasks = TaskUtils.readTasks();
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
        } else {
            tasks.forEach(System.out::println);
        }
    }

    private static void updateTask() {
        List<Task> tasks = TaskUtils.readTasks();

        System.out.print("Enter Task ID to update: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (Task t : tasks) {
            if (t.getTaskId() == id) {
                System.out.print("Enter new Description: ");
                t.setDescription(sc.nextLine());

                System.out.print("Enter new Due Date: ");
                t.setDueDate(sc.nextLine());

                TaskUtils.writeTasks(tasks);
                System.out.println("Task updated successfully!");
                return;
            }
        }
        System.out.println("Task not found!");
    }

    private static void deleteTask() {
        List<Task> tasks = TaskUtils.readTasks();

        System.out.print("Enter Task ID to delete: ");
        int id = sc.nextInt();

        boolean removed = tasks.removeIf(t -> t.getTaskId() == id);
        if (removed) {
            TaskUtils.writeTasks(tasks);
            System.out.println("Task deleted successfully!");
        } else {
            System.out.println("Task not found!");
        }
    }

    private static void markCompleted() {
        List<Task> tasks = TaskUtils.readTasks();

        System.out.print("Enter Task ID to mark as completed: ");
        int id = sc.nextInt();

        for (Task t : tasks) {
            if (t.getTaskId() == id) {
                t.setCompleted(true);
                TaskUtils.writeTasks(tasks);
                System.out.println("Task marked as completed!");
                return;
            }
        }
        System.out.println("Task not found!");
    }
}
