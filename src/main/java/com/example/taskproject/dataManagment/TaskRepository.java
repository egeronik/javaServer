package com.example.taskproject.dataManagment;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface TaskRepository extends CrudRepository<Task,Integer> {
}
