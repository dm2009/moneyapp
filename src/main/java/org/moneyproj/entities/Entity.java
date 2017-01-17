package org.moneyproj.entities;

import java.io.Serializable;

/**
 *
 * @author Dmitriy S
 *
 */
public class Entity implements Serializable {

    /**
     * UID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The id.
     */
    private Integer id;

    /**
     * The name.
     */
    private String name;

    /**
     * @return the id
     */
    public final Integer getId() {
        return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public final void setId(final Integer id) {
        this.id = id;
    }

    /**
     * @inheritDoc
     * @return HashCode of object.
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    /**
     * @return the name
     */
    public final String getName() {
        return name;
    }

    /**
     * @param name
     *            the name to set
     */
    public final void setName(final String name) {
        this.name = name;
    }

    /**
     * This method compares the equality of the current object with the object
     * of same type
     *
     * @return true if objects are equals
     * @param obj
     *            object for compare
     */
    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Entity other = (Entity) obj;
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }
        return true;
    }

}
