package com.ponpes.dahlanikhsan.backend.service.security;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ponpes.dahlanikhsan.backend.domain.security.FUser;

public interface UserRepository extends JpaRepository<FUser, Long> {

	FUser findByEmailIgnoreCase(String email);

	Page<FUser> findBy(Pageable pageable);

	Page<FUser> findByEmailLikeIgnoreCaseOrFirstNameLikeIgnoreCaseOrLastNameLikeIgnoreCaseOrRoleLikeIgnoreCase(
            String emailLike, String firstNameLike, String lastNameLike, String roleLike, Pageable pageable);

	long countByEmailLikeIgnoreCaseOrFirstNameLikeIgnoreCaseOrLastNameLikeIgnoreCaseOrRoleLikeIgnoreCase(
            String emailLike, String firstNameLike, String lastNameLike, String roleLike);
}
