package com.myapp.app.data;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Setter;

@Setter
@MappedSuperclass
public abstract class AbstractEntity {
    private Integer id;

    @Id
    @GeneratedValue
    public Integer getId() {
        return id;
    }

	@Override
    public int hashCode() {
        if (id != null) {
            return id.hashCode();
        }
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof AbstractEntity other)) {
            return false; // null or other class
        }

		if (id != null) {
            return id.equals(other.id);
        }
        return super.equals(other);
    }
}