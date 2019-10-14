package com.uuhnaut69.todo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.uuhnaut69.todo.exception.BadRequestException;
import com.uuhnaut69.todo.exception.ResourceNotFoundException;
import com.uuhnaut69.todo.model.payload.request.WorkRequest;
import com.uuhnaut69.todo.repository.WorkRepository;
import com.uuhnaut69.todo.service.WorkService;
import com.uuhnaut69.tododb.tododb.tododb.work.Work;

@Service
public class WorkServiceImpl implements WorkService {

	private final WorkRepository workRepository;

	public WorkServiceImpl(WorkRepository workRepository) {
		this.workRepository = workRepository;
	}

	@Override
	public List<Work> findAll(int page, int pageSize, String order) {
		return workRepository.findAll(page, pageSize, order);
	}

	@Override
	public Work findById(Long id) {
		return workRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Work", "work id", id));
	}

	@Override
	public void add(WorkRequest request) throws Exception {
		validWorkRequest(request.getWorkName());
		workRepository.add(request);
	}

	@Override
	public void edit(Long id, WorkRequest request) throws Exception {
		findById(id);
		validWorkRequest(request.getWorkName());
		workRepository.edit(id, request);
	}

	@Override
	public void delete(Long id) throws Exception {
		findById(id);
		workRepository.delete(id);
	}

	private void validWorkRequest(String workName) {
		if (workRepository.existsByWorkName(workName)) {
			throw new BadRequestException(workName + " already exists");
		}
	};
}
