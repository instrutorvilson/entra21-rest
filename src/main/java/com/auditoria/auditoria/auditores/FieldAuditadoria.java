package com.auditoria.auditoria.auditores;

import java.time.Instant;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class FieldAuditadoria {
	@CreatedBy
	private String createBy;
	
	@LastModifiedBy
	private String modifyBy;
	
	@CreatedDate
	private Instant createAt = Instant.now();
	
	@LastModifiedDate
	private Instant modifyAt = Instant.now();

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public String getModifyBy() {
		return modifyBy;
	}

	public void setModifyBy(String modifyBy) {
		this.modifyBy = modifyBy;
	}

	public Instant getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Instant createAt) {
		this.createAt = createAt;
	}

	public Instant getModifyAt() {
		return modifyAt;
	}

	public void setModifyAt(Instant modifyAt) {
		this.modifyAt = modifyAt;
	}	
	
}
