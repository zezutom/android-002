// Import the necessary Java synchronization and scheduling classes.

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @class SimpleAtomicLong
 *
 * @brief This class implements a subset of the
 *        java.util.concurrent.atomic.SimpleAtomicLong class using a
 *        ReentrantReadWriteLock to illustrate how they work.
 */
class SimpleAtomicLong
{
    /**
     * The value that's manipulated atomically via the methods.
     */
    private long mValue;
    
    /**
     * The ReentrantReadWriteLock used to serialize access to mValue.
     */
    // DONE - replace the null with the appropriate initialization:
    private ReentrantReadWriteLock mRWLock = new ReentrantReadWriteLock();

    /**
     * Creates a new SimpleAtomicLong with the given initial value.
     */
    public SimpleAtomicLong(long initialValue)
    {
        // DONE - you fill in here
    	mValue = initialValue;
    }

    /**
     * @brief Gets the current value.
     * 
     * @returns The current value
     */
    public long get()
    {
        long value;
        // DONE - you fill in here, using a readLock()
        mRWLock.readLock().lock();
        try {
        	value = mValue;	
        } finally {
        	mRWLock.readLock().unlock();	
        }        
        return value;
    }

    /**
     * @brief Atomically decrements by one the current value
     *
     * @returns the updated value
     */
    public long decrementAndGet()
    {
        long value;
        // DONE - you fill in here, using a writeLock()
        mRWLock.writeLock().lock();
        try {
        	value = --mValue;	
        } finally {
        	mRWLock.writeLock().unlock();	
        }                
        return value;
    }

    /**
     * @brief Atomically increments by one the current value
     *
     * @returns the previous value
     */
    public long getAndIncrement()
    {
        long value;
        // DONE - you fill in here, using a writeLock()
        mRWLock.writeLock().lock();
        try {
        	value = mValue++;	
        } finally {
        	mRWLock.writeLock().unlock();	
        }                
        return value;
    }

    /**
     * @brief Atomically decrements by one the current value
     *
     * @returns the previous value
     */
    public long getAndDecrement()
    {
        long value;
        // DONE - you fill in here, using a writeLock()
        mRWLock.writeLock().lock();
        try {
        	value = mValue--;	
        } finally {
        	mRWLock.writeLock().unlock();	
        }                        
        return value;
    }

    /**
     * @brief Atomically increments by one the current value
     *
     * @returns the updated value
     */
    public long incrementAndGet()
    {
        long value;
        // DONE - you fill in here, using a writeLock()
        mRWLock.writeLock().lock();
        try {
        	value = ++mValue;	
        } finally {
        	mRWLock.writeLock().unlock();	
        }                        
        return value;
    }
}

