package com.yourorg.aws.strategy;

/**
 * Strategy interface for CRUD operations against a data store
 * such as DynamoDB.
 *
 * Generic types keep it flexible.
 */
public interface CrudOperationStrategy<T, R> {

    R create(T item);

    R read(String key);

    R update(T item);

    void delete(String key);
}
