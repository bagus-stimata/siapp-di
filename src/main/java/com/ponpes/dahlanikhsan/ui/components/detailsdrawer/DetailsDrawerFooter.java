package com.ponpes.dahlanikhsan.ui.components.detailsdrawer;

import com.ponpes.dahlanikhsan.ui.components.FlexBoxLayout;
import com.ponpes.dahlanikhsan.ui.layout.size.Horizontal;
import com.ponpes.dahlanikhsan.ui.layout.size.Right;
import com.ponpes.dahlanikhsan.ui.layout.size.Vertical;
import com.ponpes.dahlanikhsan.ui.util.LumoStyles;
import com.ponpes.dahlanikhsan.ui.util.UIUtils;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.shared.Registration;

public class DetailsDrawerFooter extends FlexBoxLayout {

	private Button save;
	private Button cancel;

	public DetailsDrawerFooter() {
		setBackgroundColor(LumoStyles.Color.Contrast._5);
		setPadding(Horizontal.RESPONSIVE_L, Vertical.S);
		setSpacing(Right.S);
		setWidthFull();

		save = UIUtils.createPrimaryButton("Save");
		cancel = UIUtils.createTertiaryButton("Cancel");
		add(save, cancel);
	}

	public Registration addSaveListener(
			ComponentEventListener<ClickEvent<Button>> listener) {
		return save.addClickListener(listener);
	}

	public Registration addCancelListener(
			ComponentEventListener<ClickEvent<Button>> listener) {
		return cancel.addClickListener(listener);
	}

}
