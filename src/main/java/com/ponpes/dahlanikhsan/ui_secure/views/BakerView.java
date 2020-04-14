package com.ponpes.dahlanikhsan.ui_secure.views;

import com.ponpes.dahlanikhsan.app_secure.security.Role;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;

@Route("baker")
@Secured({Role.BAKER, Role.ADMIN})
public class BakerView extends VerticalLayout {
    @Autowired
    public BakerView() {
        Label label = new Label("Hello Baker!");
        add(label);
    }
}
