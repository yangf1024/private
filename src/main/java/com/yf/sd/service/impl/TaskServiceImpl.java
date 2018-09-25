package com.yf.sd.service.impl;


import com.yf.sd.mapper.TaskMapper;
import com.yf.sd.pojo.Task;
import com.yf.sd.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskMapper taskMapper;

    @Override
    public int newTask(Task task) {
        return taskMapper.addTask(task);
    }
}
