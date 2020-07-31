package com.ponpes.dahlanikhsan.app_security.ui_secure.view_utils;

public class AccessDeniedException extends RuntimeException {
	public AccessDeniedException() {
	}

	public AccessDeniedException(String message) {
		super(message);
	}
}
