package com.uuhnaut69.todo.service;

import java.util.List;

import com.uuhnaut69.todo.model.payload.request.WorkRequest;
import com.uuhnaut69.tododb.tododb.tododb.work.Work;

public interface WorkService {

	List<Work> findAll(int page, int pageSize, String order);

	Work findById(Long id);

	void add(WorkRequest request) throws Exception;

	void edit(Long id, WorkRequest request) throws Exception;

	void delete(Long id) throws Exception;

}
