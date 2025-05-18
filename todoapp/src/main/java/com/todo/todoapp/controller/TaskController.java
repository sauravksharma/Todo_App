package com.todo.todoapp.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.todo.todoapp.models.Task;
import com.todo.todoapp.service.TaskService;

@Controller
@RequestMapping("/tasks")
public class TaskController {

	private final TaskService taskService;

	public TaskController(TaskService taskService) {
		this.taskService = taskService;
	}

	// Display all tasks
	@GetMapping
	public String getTasks(Model model) {
		List<Task> tasks = taskService.getAllTasks();
		model.addAttribute("tasks", tasks);
		return "tasks"; // render tasks.html
	}

	// Create task
	@PostMapping("/create")
	public String createTask(@RequestParam String title) {
		taskService.createTask(title);
		return "redirect:/tasks";
	}

	// Delete task
	@PostMapping("/delete/{id}")
	public String deleteTask(@PathVariable Long id) {
		taskService.deleteTask(id);
		return "redirect:/tasks";
	}

	// Toggle task completion
	@PostMapping("/toggle/{id}")
	public String toggleTask(@PathVariable Long id) {
		taskService.toggleTask(id);
		return "redirect:/tasks";
	}
}
