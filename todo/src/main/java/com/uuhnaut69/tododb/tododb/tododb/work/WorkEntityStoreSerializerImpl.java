package com.uuhnaut69.tododb.tododb.tododb.work;

import com.uuhnaut69.tododb.tododb.tododb.work.generated.GeneratedWorkEntityStoreSerializerImpl;

import java.nio.ByteBuffer;
import java.util.function.LongFunction;
import java.util.function.LongToIntFunction;

/**
 * An {@link
 * com.speedment.enterprise.datastore.runtime.entitystore.EntityStoreSerializer}
 * class for table {@link com.speedment.runtime.config.Table} named work.
 * <p>
 * This file is safe to edit. It will not be overwritten by the code generator.
 * 
 * @author uuhnaut69
 */
public final class WorkEntityStoreSerializerImpl extends GeneratedWorkEntityStoreSerializerImpl {
    
    public WorkEntityStoreSerializerImpl(LongFunction<ByteBuffer> bufferFinder, LongToIntFunction offsetFinder) {
        super(bufferFinder, offsetFinder);
    }
}