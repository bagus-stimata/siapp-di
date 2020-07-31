package com.ponpes.dahlanikhsan.app_security.securityconfig;

import com.ponpes.dahlanikhsan.app_security.ui_secure.LoginView;
import com.ponpes.dahlanikhsan.app_security.ui_secure.view_utils.AccessDeniedException;
import com.ponpes.dahlanikhsan.app_security.ui_secure.view_utils.OfflineBanner;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.server.ServiceInitEvent;
import com.vaadin.flow.server.VaadinServiceInitListener;
import com.vaadin.flow.spring.annotation.SpringComponent;

/**
 * Adds before enter listener to check access to views.
 * Adds the Offline banner.
 * 
 */
@SpringComponent
public class ConfigureUIServiceInitListener implements VaadinServiceInitListener {

	@Override
	public void serviceInit(ServiceInitEvent event) {
		/*
		 * Non Aktifkan Jika: Security-Ignored
		 */
		event.getSource().addUIInitListener(uiEvent -> {
			final UI ui = uiEvent.getUI();
			ui.add(new OfflineBanner() );
			ui.addBeforeEnterListener(this::beforeEnter);
		});
		
	}

	/**
	 * Reroutes the user if she is not authorized to access the view. 
	 *
	 * @param event
	 *            before navigation event with event details
	 */
	private void beforeEnter(BeforeEnterEvent event) {
		final boolean accessGranted = SecurityUtils.isAccessGranted(event.getNavigationTarget());
		/*
		 * Non Aktifkan Jika: Security-Ignored
		 */
		if (!accessGranted) {
			if (SecurityUtils.isUserLoggedIn()) {
				event.rerouteToError(AccessDeniedException.class);
			} else {
				event.rerouteTo(LoginView.class);
			}
		}//endif	
	}

	
}
