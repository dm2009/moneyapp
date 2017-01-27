package org.moneyproj.dao;

/**
 *
 * @author Dmitriy S
 *
 * @param <ID>
 *            unique identifier.
 * @param <T>
 *            type.
 */
public interface Dao<ID, T> {
    /**
     * Create object.
     *
     * @param entity
     *            object type.
     */
    void create(T entity);

    /**
     * Read object.
     *
     * @param id
     *            object id.
     * @return object type.
     */
    T read(ID id);

    /**
     * Update object.
     *
     * @param entity
     *            object type.
     */
    void update(T entity);

    /**
     * Delete object.
     *
     * @param id object id.
     */
    void delete(ID id);
}
