package com.uuhnaut69.tododb.tododb.tododb.work.generated;

import com.speedment.common.annotation.GeneratedCode;
import com.speedment.runtime.config.identifier.TableIdentifier;
import com.speedment.runtime.core.component.SqlAdapter;
import com.speedment.runtime.core.db.SqlFunction;
import com.uuhnaut69.tododb.tododb.tododb.work.Work;
import com.uuhnaut69.tododb.tododb.tododb.work.WorkImpl;

import java.sql.ResultSet;
import java.sql.SQLException;

import static com.speedment.common.injector.State.RESOLVED;

/**
 * The generated Sql Adapter for a {@link
 * com.uuhnaut69.tododb.tododb.tododb.work.Work} entity.
 * <p>
 * This file has been automatically generated by Speedment. Any changes made to
 * it will be overwritten.
 * 
 * @author Speedment
 */
@GeneratedCode("Speedment")
public abstract class GeneratedWorkSqlAdapter implements SqlAdapter<Work> {
    
    private final TableIdentifier<Work> tableIdentifier;
    
    protected GeneratedWorkSqlAdapter() {
        this.tableIdentifier = TableIdentifier.of("tododb", "tododb", "work");
    }
    
    protected Work apply(ResultSet resultSet, int offset) throws SQLException {
        return createEntity()
            .setId(           resultSet.getLong(1 + offset))
            .setEndingDate(   resultSet.getTimestamp(2 + offset))
            .setStartingDate( resultSet.getTimestamp(3 + offset))
            .setWorkName(     resultSet.getString(4 + offset))
            .setWorkStatus(   resultSet.getString(5 + offset))
            ;
    }
    
    protected WorkImpl createEntity() {
        return new WorkImpl();
    }
    
    @Override
    public TableIdentifier<Work> identifier() {
        return tableIdentifier;
    }
    
    @Override
    public SqlFunction<ResultSet, Work> entityMapper() {
        return entityMapper(0);
    }
    
    @Override
    public SqlFunction<ResultSet, Work> entityMapper(int offset) {
        return rs -> apply(rs, offset);
    }
}