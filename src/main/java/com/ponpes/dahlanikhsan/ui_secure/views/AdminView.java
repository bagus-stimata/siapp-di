package com.ponpes.dahlanikhsan.ui_secure.views;

import com.ponpes.dahlanikhsan.app_securityconfig.security.Role;
import com.ponpes.dahlanikhsan.backend.domain.security.FUser;
import com.ponpes.dahlanikhsan.backend.service.security.UserRepository;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;

import java.util.List;

@Route("admin")
@Secured(Role.ADMIN)
//@SpringComponent //Tanpa ini bisa jika bawah sudah autowire
public class AdminView extends VerticalLayout {

    private UserRepository userRepository;

    /*
    KETIKA AUTO WIRE MAKA OTOMATIS KAN DIJALANKAN CONSTRUCTORNYA
    INI NAMANYA DENDENDCY INJECTION
     */
    @Autowired
    public AdminView(UserRepository userRepository) {
        Label label = new Label("Looks like you are admin!");
        add(label);

        this.userRepository = userRepository;

       List<FUser> list = userRepository.findAll();
       for (FUser userBean: list) {
           Label labelUser = new Label(userBean.getFirstName());
           add(labelUser);
       }

    }

}
