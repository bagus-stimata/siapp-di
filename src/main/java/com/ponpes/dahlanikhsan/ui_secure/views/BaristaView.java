package com.ponpes.dahlanikhsan.ui_secure.views;

import com.ponpes.dahlanikhsan.app_secure.security.Role;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;

@Route("barista")
@Secured({Role.BARISTA, Role.ADMIN})
public class BaristaView extends VerticalLayout {
    @Autowired
    public BaristaView() {
        Label label = new Label("Hello Barista!");
        add(label);
    }
}
