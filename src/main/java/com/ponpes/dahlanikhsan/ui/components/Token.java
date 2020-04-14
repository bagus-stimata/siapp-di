package com.ponpes.dahlanikhsan.ui.components;

import com.ponpes.dahlanikhsan.ui.layout.size.Left;
import com.ponpes.dahlanikhsan.ui.layout.size.Right;
import com.ponpes.dahlanikhsan.ui.util.FontSize;
import com.ponpes.dahlanikhsan.ui.util.LumoStyles;
import com.ponpes.dahlanikhsan.ui.util.TextColor;
import com.ponpes.dahlanikhsan.ui.util.UIUtils;
import com.ponpes.dahlanikhsan.ui.util.css.BorderRadius;
import com.ponpes.dahlanikhsan.ui.util.css.Display;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.VaadinIcon;

public class Token extends FlexBoxLayout {

	private final String CLASS_NAME = "token";

	public Token(String text) {
		setAlignItems(Alignment.CENTER);
		setBackgroundColor(LumoStyles.Color.Primary._10);
		setBorderRadius(BorderRadius.M);
		setClassName(CLASS_NAME);
		setDisplay(Display.INLINE_FLEX);
		setPadding(Left.S, Right.XS);
		setSpacing(Right.XS);

		Label label = UIUtils.createLabel(FontSize.S, TextColor.BODY, text);
		Button button = UIUtils.createButton(VaadinIcon.CLOSE_SMALL, ButtonVariant.LUMO_SMALL, ButtonVariant.LUMO_TERTIARY_INLINE);
		add(label, button);
	}

}
