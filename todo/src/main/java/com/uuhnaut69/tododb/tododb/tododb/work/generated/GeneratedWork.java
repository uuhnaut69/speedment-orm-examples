package com.uuhnaut69.tododb.tododb.tododb.work.generated;

import com.speedment.common.annotation.GeneratedCode;
import com.speedment.enterprise.datastore.runtime.field.DatastoreFields;
import com.speedment.runtime.config.identifier.ColumnIdentifier;
import com.speedment.runtime.config.identifier.TableIdentifier;
import com.speedment.runtime.core.util.OptionalUtil;
import com.speedment.runtime.field.ComparableField;
import com.speedment.runtime.field.LongField;
import com.speedment.runtime.field.StringField;
import com.speedment.runtime.typemapper.TypeMapper;
import com.uuhnaut69.tododb.tododb.tododb.work.Work;

import java.sql.Timestamp;
import java.util.Optional;

/**
 * The generated base for the {@link
 * com.uuhnaut69.tododb.tododb.tododb.work.Work}-interface representing entities
 * of the {@code work}-table in the database.
 * <p>
 * This file has been automatically generated by Speedment. Any changes made to
 * it will be overwritten.
 * 
 * @author Speedment
 */
@GeneratedCode("Speedment")
public interface GeneratedWork {
    
    /**
     * This Field corresponds to the {@link Work} field that can be obtained
     * using the {@link Work#getId()} method.
     */
    LongField<Work, Long> ID = DatastoreFields.createLongField(
        Identifier.ID,
        Work::getId,
        Work::setId,
        TypeMapper.primitive(),
        true
    );
    /**
     * This Field corresponds to the {@link Work} field that can be obtained
     * using the {@link Work#getEndingDate()} method.
     */
    ComparableField<Work, Timestamp, Timestamp> ENDING_DATE = DatastoreFields.createComparableField(
        Identifier.ENDING_DATE,
        o -> OptionalUtil.unwrap(o.getEndingDate()),
        Work::setEndingDate,
        TypeMapper.identity(),
        false
    );
    /**
     * This Field corresponds to the {@link Work} field that can be obtained
     * using the {@link Work#getStartingDate()} method.
     */
    ComparableField<Work, Timestamp, Timestamp> STARTING_DATE = DatastoreFields.createComparableField(
        Identifier.STARTING_DATE,
        o -> OptionalUtil.unwrap(o.getStartingDate()),
        Work::setStartingDate,
        TypeMapper.identity(),
        false
    );
    /**
     * This Field corresponds to the {@link Work} field that can be obtained
     * using the {@link Work#getWorkName()} method.
     */
    StringField<Work, String> WORK_NAME = DatastoreFields.createStringField(
        Identifier.WORK_NAME,
        Work::getWorkName,
        Work::setWorkName,
        TypeMapper.identity(),
        true
    );
    /**
     * This Field corresponds to the {@link Work} field that can be obtained
     * using the {@link Work#getWorkStatus()} method.
     */
    StringField<Work, String> WORK_STATUS = DatastoreFields.createStringField(
        Identifier.WORK_STATUS,
        o -> OptionalUtil.unwrap(o.getWorkStatus()),
        Work::setWorkStatus,
        TypeMapper.identity(),
        false
    );
    
    /**
     * Returns the id of this Work. The id field corresponds to the database
     * column tododb.tododb.work.id.
     * 
     * @return the id of this Work
     */
    long getId();
    
    /**
     * Returns the endingDate of this Work. The endingDate field corresponds to
     * the database column tododb.tododb.work.ending_date.
     * 
     * @return the endingDate of this Work
     */
    Optional<Timestamp> getEndingDate();
    
    /**
     * Returns the startingDate of this Work. The startingDate field corresponds
     * to the database column tododb.tododb.work.starting_date.
     * 
     * @return the startingDate of this Work
     */
    Optional<Timestamp> getStartingDate();
    
    /**
     * Returns the workName of this Work. The workName field corresponds to the
     * database column tododb.tododb.work.work_name.
     * 
     * @return the workName of this Work
     */
    String getWorkName();
    
    /**
     * Returns the workStatus of this Work. The workStatus field corresponds to
     * the database column tododb.tododb.work.work_status.
     * 
     * @return the workStatus of this Work
     */
    Optional<String> getWorkStatus();
    
    /**
     * Sets the id of this Work. The id field corresponds to the database column
     * tododb.tododb.work.id.
     * 
     * @param id to set of this Work
     * @return   this Work instance
     */
    Work setId(long id);
    
    /**
     * Sets the endingDate of this Work. The endingDate field corresponds to the
     * database column tododb.tododb.work.ending_date.
     * 
     * @param endingDate to set of this Work
     * @return           this Work instance
     */
    Work setEndingDate(Timestamp endingDate);
    
    /**
     * Sets the startingDate of this Work. The startingDate field corresponds to
     * the database column tododb.tododb.work.starting_date.
     * 
     * @param startingDate to set of this Work
     * @return             this Work instance
     */
    Work setStartingDate(Timestamp startingDate);
    
    /**
     * Sets the workName of this Work. The workName field corresponds to the
     * database column tododb.tododb.work.work_name.
     * 
     * @param workName to set of this Work
     * @return         this Work instance
     */
    Work setWorkName(String workName);
    
    /**
     * Sets the workStatus of this Work. The workStatus field corresponds to the
     * database column tododb.tododb.work.work_status.
     * 
     * @param workStatus to set of this Work
     * @return           this Work instance
     */
    Work setWorkStatus(String workStatus);
    
    enum Identifier implements ColumnIdentifier<Work> {
        
        ID            ("id"),
        ENDING_DATE   ("ending_date"),
        STARTING_DATE ("starting_date"),
        WORK_NAME     ("work_name"),
        WORK_STATUS   ("work_status");
        
        private final String columnId;
        private final TableIdentifier<Work> tableIdentifier;
        
        Identifier(String columnId) {
            this.columnId        = columnId;
            this.tableIdentifier = TableIdentifier.of(    getDbmsId(), 
                getSchemaId(), 
                getTableId());
        }
        
        @Override
        public String getDbmsId() {
            return "tododb";
        }
        
        @Override
        public String getSchemaId() {
            return "tododb";
        }
        
        @Override
        public String getTableId() {
            return "work";
        }
        
        @Override
        public String getColumnId() {
            return this.columnId;
        }
        
        @Override
        public TableIdentifier<Work> asTableIdentifier() {
            return this.tableIdentifier;
        }
    }
}