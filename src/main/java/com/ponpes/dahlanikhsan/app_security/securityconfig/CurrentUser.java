package com.ponpes.dahlanikhsan.app_security.securityconfig;


import com.ponpes.dahlanikhsan.app_security.model.FUser;

@FunctionalInterface
public interface CurrentUser {

	FUser getUser();
}
