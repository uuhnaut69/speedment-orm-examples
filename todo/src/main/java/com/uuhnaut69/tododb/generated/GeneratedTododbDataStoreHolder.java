package com.uuhnaut69.tododb.generated;

import com.speedment.common.annotation.GeneratedCode;
import com.speedment.enterprise.datastore.runtime.DataStoreHolder;
import com.speedment.enterprise.datastore.runtime.entitystore.EntityStore;
import com.speedment.enterprise.datastore.runtime.entitystore.EntityStoreHolder;
import com.speedment.enterprise.datastore.runtime.fieldcache.FieldCache;
import com.speedment.enterprise.datastore.runtime.fieldcache.MultiFieldCache;
import com.speedment.enterprise.datastore.runtime.statistic.Statistics;
import com.speedment.enterprise.datastore.runtime.util.StatisticsUtil;
import com.speedment.runtime.config.identifier.ColumnIdentifier;
import com.uuhnaut69.tododb.tododb.tododb.work.Work;
import com.uuhnaut69.tododb.tododb.tododb.work.generated.GeneratedWorkCacheHolder;

import java.util.Optional;
import java.util.stream.Stream;

import static java.util.Objects.requireNonNull;

/**
 * A holder class for the various caches that are used to speed up the project.
 * <p>
 * This file has been automatically generated by Speedment. Any changes made to
 * it will be overwritten.
 * 
 * @author Speedment
 */
@GeneratedCode("Speedment")
public final class GeneratedTododbDataStoreHolder implements DataStoreHolder {
    
    private final GeneratedWorkCacheHolder workHolder;
    
    public GeneratedTododbDataStoreHolder(GeneratedWorkCacheHolder workHolder) {
        this.workHolder = requireNonNull(workHolder);
    }
    
    @Override
    @SuppressWarnings("unchecked")
    public <ENTITY> EntityStore<ENTITY> getEntityStore(
            String dbmsName,
            String schemaName,
            String tableName) {
        return (EntityStore<ENTITY>) workHolder.getEntityStore();
    }
    
    @Override
    @SuppressWarnings("unchecked")
    public <ENTITY, CACHE extends FieldCache<CACHE>> CACHE getFieldCache(ColumnIdentifier<ENTITY> columnId) {
        return (CACHE) workHolder.getFieldCache((ColumnIdentifier<Work>) columnId);
    }
    
    @Override
    @SuppressWarnings("unchecked")
    public <ENTITY, T0, T1, CACHE extends MultiFieldCache<T0, T1, CACHE>> Optional<CACHE> getMultiFieldCache(ColumnIdentifier<ENTITY> firstColumnId, ColumnIdentifier<ENTITY> secondColumnId) {
        return Optional.empty(); // No multi-indexes are used in the project
    }
    
    @Override
    @SuppressWarnings("unchecked")
    public <ENTITY> boolean isHavingMultiFieldCache(ColumnIdentifier<ENTITY> columnId) {
        return false; // No multi-indexes are used in the project
    }
    
    @Override
    public void close() {
        holders().forEach(EntityStoreHolder::close);
    }
    
    @Override
    public Statistics getStatistics() {
        return StatisticsUtil.create(
            holders()
                .toArray(EntityStoreHolder[]::new)
        );
    }
    
    @Override
    public Stream<EntityStoreHolder<?>> holders() {
        return Stream.of(
            workHolder
        );
    }
}