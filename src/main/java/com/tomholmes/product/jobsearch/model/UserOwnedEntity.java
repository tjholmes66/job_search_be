package com.tomholmes.product.jobsearch.model;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class UserOwnedEntity {
    @CreatedBy
    @Column(name = "user_id", nullable = false, updatable = false)
    private String userId;

    public String getUserId() { return userId; }
}
