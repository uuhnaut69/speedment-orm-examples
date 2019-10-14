package com.uuhnaut69.todo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.uuhnaut69.todo.constants.AppConstants;
import com.uuhnaut69.todo.model.payload.request.WorkRequest;
import com.uuhnaut69.todo.model.payload.response.ApiResponse;
import com.uuhnaut69.todo.service.WorkService;
import com.uuhnaut69.tododb.tododb.tododb.work.Work;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@Api(value = "ToDo Api")
@RequestMapping(path = "/v1/api/works", produces = MediaType.APPLICATION_JSON_VALUE)
public class WorkController {

	private final WorkService workService;

	public WorkController(WorkService workService) {
		this.workService = workService;
	}

	@GetMapping
	@ApiOperation(value = "Get list work available")
	public ResponseEntity<List<Work>> findAll(@RequestParam(value = "order", defaultValue = "desc") String order,
			@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {

		List<Work> works = workService.findAll(page, pageSize, order);
		return new ResponseEntity<List<Work>>(works, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "Get a work's detail")
	@ApiParam(value = "Work id", required = true)
	public ResponseEntity<Work> findById(@PathVariable Long id) {
		Work work = workService.findById(id);
		return new ResponseEntity<Work>(work, HttpStatus.OK);
	}

	@PostMapping(path = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Add a new work")
	@ApiParam(value = "Work Request Object", required = true)
	public ResponseEntity<ApiResponse> add(@RequestBody @Valid WorkRequest req) throws Exception {
		workService.add(req);
		return new ResponseEntity<ApiResponse>(new ApiResponse(AppConstants.CREATE_SUCCESS), HttpStatus.CREATED);
	}

	@PutMapping(path = "/{id}/edit", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Edit a work")
	@ApiParam(value = "Work id & Work Request Object", required = true)
	public ResponseEntity<ApiResponse> edit(@PathVariable Long id, @RequestBody @Valid WorkRequest req)
			throws Exception {
		workService.edit(id, req);
		return new ResponseEntity<ApiResponse>(new ApiResponse(AppConstants.CREATE_SUCCESS), HttpStatus.OK);
	}

	@DeleteMapping("/{id}/delete")
	@ApiOperation(value = "Delete a work")
	@ApiParam(value = "Work id", required = true)
	public ResponseEntity<Object> delete(@PathVariable Long id) throws Exception {
		workService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
