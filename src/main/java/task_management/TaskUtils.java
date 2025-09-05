package task_management;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.lang.reflect.Type;
import java.util.*;

public class TaskUtils {
    private static final String FILE_NAME = "tasks.json";
    private static final Gson gson = new Gson();

    public static List<Task> readTasks() {
        try (Reader reader = new FileReader(FILE_NAME)) {
            Type listType = new TypeToken<List<Task>>() {}.getType();
            List<Task> tasks = gson.fromJson(reader, listType);
            return tasks != null ? tasks : new ArrayList<>();
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }

    public static void writeTasks(List<Task> tasks) {
        try (Writer writer = new FileWriter(FILE_NAME)) {
            gson.toJson(tasks, writer);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}

