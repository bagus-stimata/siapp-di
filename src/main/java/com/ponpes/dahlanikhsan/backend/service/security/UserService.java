package com.ponpes.dahlanikhsan.backend.service.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ponpes.dahlanikhsan.backend.domain.security.FUser;

import java.util.Optional;

@Service
public class UserService implements FilterableCrudService<FUser> {

	public static final String MODIFY_LOCKED_USER_NOT_PERMITTED = "User has been locked and cannot be modified or deleted";
	private static final String DELETING_SELF_NOT_PERMITTED = "You cannot delete your own account";
	private final UserRepository userRepository;

	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public Page<FUser> findAnyMatching(Optional<String> filter, Pageable pageable) {
		if (filter.isPresent()) {
			String repositoryFilter = "%" + filter.get() + "%";
			return getRepository()
					.findByEmailLikeIgnoreCaseOrFirstNameLikeIgnoreCaseOrLastNameLikeIgnoreCaseOrRoleLikeIgnoreCase(
							repositoryFilter, repositoryFilter, repositoryFilter, repositoryFilter, pageable);
		} else {
			return find(pageable);
		}
	}

	@Override
	public long countAnyMatching(Optional<String> filter) {
		if (filter.isPresent()) {
			String repositoryFilter = "%" + filter.get() + "%";
			return userRepository.countByEmailLikeIgnoreCaseOrFirstNameLikeIgnoreCaseOrLastNameLikeIgnoreCaseOrRoleLikeIgnoreCase(
					repositoryFilter, repositoryFilter, repositoryFilter, repositoryFilter);
		} else {
			return count();
		}
	}

	@Override
	public UserRepository getRepository() {
		return userRepository;
	}

	public Page<FUser> find(Pageable pageable) {
		return getRepository().findBy(pageable);
	}

	@Override
	public FUser save(FUser currentUser, FUser entity) {
		throwIfUserLocked(entity);
		return getRepository().saveAndFlush(entity);
	}

	@Override
	@Transactional
	public void delete(FUser currentUser, FUser userToDelete) {
		throwIfDeletingSelf(currentUser, userToDelete);
		throwIfUserLocked(userToDelete);
		FilterableCrudService.super.delete(currentUser, userToDelete);
	}

	private void throwIfDeletingSelf(FUser currentUser, FUser user) {
		if (currentUser.equals(user)) {
			throw new UserFriendlyDataException(DELETING_SELF_NOT_PERMITTED);
		}
	}

	private void throwIfUserLocked(FUser entity) {
		if (entity != null && entity.isLocked()) {
			throw new UserFriendlyDataException(MODIFY_LOCKED_USER_NOT_PERMITTED);
		}
	}

	@Override
	public FUser createNew(FUser currentUser) {
		return new FUser();
	}

}
