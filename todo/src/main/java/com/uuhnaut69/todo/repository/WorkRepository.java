package com.uuhnaut69.todo.repository;

import java.util.List;
import java.util.Optional;

import com.uuhnaut69.todo.model.payload.request.WorkRequest;
import com.uuhnaut69.tododb.tododb.tododb.work.Work;

public interface WorkRepository {

	List<Work> findAll(int page, int pageSize, String order);

	Optional<Work> findById(Long id);

	void add(WorkRequest request);

	void edit(Long id, WorkRequest request);

	void delete(Long id);

	Boolean existsByWorkName(String workName);

}
