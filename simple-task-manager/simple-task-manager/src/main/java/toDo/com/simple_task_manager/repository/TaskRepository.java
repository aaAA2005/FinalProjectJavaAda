package toDo.com.simple_task_manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import toDo.com.simple_task_manager.entity.Task;
@Repository
public interface TaskRepository extends JpaRepository<Task, Long>{

}
