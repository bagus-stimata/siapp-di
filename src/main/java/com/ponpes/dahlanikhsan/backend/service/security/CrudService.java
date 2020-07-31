package com.ponpes.dahlanikhsan.backend.service.security;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ponpes.dahlanikhsan.backend.domain.security.FUser;

import javax.persistence.EntityNotFoundException;

public interface CrudService<T> {

	JpaRepository<T, Long> getRepository();

	default T save(FUser currentUser, T entity) {
		return getRepository().saveAndFlush(entity);
	}

	default void delete(FUser currentUser, T entity) {
		if (entity == null) {
			throw new EntityNotFoundException();
		}
		getRepository().delete(entity);
	}

	default void delete(FUser currentUser, long id) {
		delete(currentUser, load(id));
	}

	default long count() {
		return getRepository().count();
	}

	default T load(long id) {
		T entity = getRepository().findById(id).orElse(null);
		if (entity == null) {
			throw new EntityNotFoundException();
		}
		return entity;
	}

	T createNew(FUser currentUser);
}
