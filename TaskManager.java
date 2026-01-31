package com.taskmanager;
import java.util.*;

class Task {
    int id;
    String name;
    boolean isCompleted;

    Task(int id, String name) {
        this.id = id;
        this.name = name;
        this.isCompleted = false;
    }
}

public class TaskManager {

    static ArrayList<Task> tasks = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static int taskId = 1;

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n==== TASK MANAGER SYSTEM ====");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Mark Task as Completed");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    viewTasks();
                    break;
                case 3:
                    completeTask();
                    break;
                case 4:
                    deleteTask();
                    break;
                case 5:
                    System.out.println("Exiting... Thank you!");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    static void addTask() {
        System.out.print("Enter task name: ");
        String name = sc.nextLine();
        Task t = new Task(taskId++, name);
        tasks.add(t);
        System.out.println("Task added successfully!");
    }

    static void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
            return;
        }

        System.out.println("\n--- Task List ---");
        for (Task t : tasks) {
            System.out.println(t.id + ". " + t.name + " | Status: " + (t.isCompleted ? "Completed" : "Pending"));
        }
    }

    static void completeTask() {
        System.out.print("Enter task ID to mark completed: ");
        int id = sc.nextInt();

        for (Task t : tasks) {
            if (t.id == id) {
                t.isCompleted = true;
                System.out.println("Task marked as completed!");
                return;
            }
        }
        System.out.println("Task not found!");
    }

    static void deleteTask() {
        System.out.print("Enter task ID to delete: ");
        int id = sc.nextInt();

        Iterator<Task> it = tasks.iterator();
        while (it.hasNext()) {
            Task t = it.next();
            if (t.id == id) {
                it.remove();
                System.out.println("Task deleted successfully!");
                return;
            }
        }
        System.out.println("Task not found!");
    }
}
