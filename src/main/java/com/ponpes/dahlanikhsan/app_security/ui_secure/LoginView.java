package com.ponpes.dahlanikhsan.app_security.ui_secure;

import com.ponpes.dahlanikhsan.AppParam;
import com.ponpes.dahlanikhsan.app_security.securityconfig.SecurityUtils;
import com.ponpes.dahlanikhsan.app_security.ui_secure.view_utils.BakeryConst;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.login.LoginI18n;
import com.vaadin.flow.component.login.LoginOverlay;
import com.vaadin.flow.component.page.Viewport;
import com.vaadin.flow.router.*;

@Route
@PageTitle("Login")
@JsModule("./styles/shared-styles.js")
@Viewport(BakeryConst.VIEWPORT)
public class LoginView extends LoginOverlay
	implements AfterNavigationObserver, BeforeEnterObserver {

	public LoginView() {
		LoginI18n i18n = LoginI18n.createDefault();
		i18n.setHeader(new LoginI18n.Header());
		i18n.getHeader().setTitle(AppParam.APP_NAME.trim().toUpperCase() );
//		i18n.getHeader().setDescription(
//			"admin@vaadin.com + admin\n" + "barista@vaadin.com + barista");
		i18n.getHeader().setDescription(AppParam.APP_DESC1);
		i18n.setAdditionalInformation(null);
		i18n.setForm(new LoginI18n.Form());
		i18n.getForm().setSubmit("Sign in");
		i18n.getForm().setTitle("Sign in");
		i18n.getForm().setUsername("UserID/Email");
		i18n.getForm().setPassword("Password");
		setI18n(i18n);
//		setForgotPasswordButtonVisible(false);
		setForgotPasswordButtonVisible(true);
		setAction("login");
		
	}
	
	@Override
	public void beforeEnter(BeforeEnterEvent event) {
		if (SecurityUtils.isUserLoggedIn()) {
//			event.forwardTo(StorefrontView.class);
//			event.forwardTo(StorefrontView.class);
		} else {
			setOpened(true);
		}
	}

	@Override
	public void afterNavigation(AfterNavigationEvent event) {
		setError(
			event.getLocation().getQueryParameters().getParameters().containsKey(
				"error"));
	}

}
