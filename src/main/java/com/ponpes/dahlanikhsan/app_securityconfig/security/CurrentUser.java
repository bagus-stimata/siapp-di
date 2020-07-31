package com.ponpes.dahlanikhsan.app_securityconfig.security;


import com.ponpes.dahlanikhsan.backend.domain.security.FUser;

@FunctionalInterface
public interface CurrentUser {

	FUser getUser();
}
