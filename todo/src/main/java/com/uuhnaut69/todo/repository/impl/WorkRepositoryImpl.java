package com.uuhnaut69.todo.repository.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Repository;

import com.speedment.runtime.core.component.transaction.TransactionComponent;
import com.speedment.runtime.core.component.transaction.TransactionHandler;
import com.speedment.runtime.core.exception.SpeedmentException;
import com.uuhnaut69.todo.model.payload.request.WorkRequest;
import com.uuhnaut69.todo.repository.WorkRepository;
import com.uuhnaut69.tododb.TododbApplication;
import com.uuhnaut69.tododb.tododb.tododb.work.Work;
import com.uuhnaut69.tododb.tododb.tododb.work.WorkImpl;
import com.uuhnaut69.tododb.tododb.tododb.work.WorkManager;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class WorkRepositoryImpl implements WorkRepository {

	private final WorkManager works;
	private final TransactionComponent transactionComponent;

	public WorkRepositoryImpl(TododbApplication app) {
		works = app.getOrThrow(WorkManager.class);
		transactionComponent = app.getOrThrow(TransactionComponent.class);
	}

	@Override
	public List<Work> findAll(int page, int pageSize, String order) {
		log.info("Get works with page {}, pageSize {}, orderType {}", page, pageSize, order);
		if ("desc".equals(order)) {
			return works.stream().sorted(Work.ID.reversed()).skip(page * pageSize).limit(pageSize)
					.collect(Collectors.toList());
		}
		return works.stream().sorted(Work.ID.comparator()).skip(page * pageSize).limit(pageSize)
				.collect(Collectors.toList());
	}

	@Override
	public Optional<Work> findById(Long id) {
		log.info("Get work with id {}", id);
		return works.stream().filter(Work.ID.equal(id)).findAny();
	}

	@Override
	public void add(WorkRequest request) {
		log.debug("Insert work {} into database", request);
		TransactionHandler txHandler = transactionComponent.createTransactionHandler();
		try {
			txHandler.createAndAccept(tx -> {
				Stream.of(new WorkImpl().setWorkName(request.getWorkName()).setStartingDate(request.getStartingDate())
						.setEndingDate(request.getEndingDate()).setWorkStatus(request.getWorkStatus().name()))
						.forEach(works.persister());
				tx.commit();
			});
		} catch (SpeedmentException se) {
			log.error("Failed to persist {}. {}", request, se.getMessage());
		}
	}

	@Override
	public void edit(Long id, WorkRequest request) {
		log.debug("Update work {} into database", request);
		TransactionHandler txHandler = transactionComponent.createTransactionHandler();
		try {
			txHandler.createAndAccept(tx -> {
				List<Work> toEdit = works.stream().filter(Work.ID.equal(id))
						.map(work -> work.setWorkName(request.getWorkName()).setStartingDate(request.getStartingDate())
								.setEndingDate(request.getEndingDate()).setWorkStatus(request.getWorkStatus().name()))
						.collect(Collectors.toList());
				toEdit.forEach(works.updater());
				tx.commit();
			});
		} catch (SpeedmentException se) {
			log.error("Failed to update {}. {}", request, se.getMessage());
		}
	}

	@Override
	public void delete(Long id) {
		log.debug("Delete work {}", id);
		TransactionHandler txHandler = transactionComponent.createTransactionHandler();
		txHandler.createAndAccept(tx -> {
			List<Work> toDelete = works.stream().filter(Work.ID.equal(id)).collect(Collectors.toList());
			toDelete.forEach(works.remover());
			tx.commit();
		});
	}

	@Override
	public Boolean existsByWorkName(String workName) {
		Optional<Work> work = works.stream().filter(Work.WORK_NAME.equal(workName)).findAny();
		if (work.isPresent()) {
			return true;
		}
		return false;
	}

}
