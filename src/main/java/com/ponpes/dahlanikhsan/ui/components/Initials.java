package com.ponpes.dahlanikhsan.ui.components;

import com.ponpes.dahlanikhsan.ui.util.FontSize;
import com.ponpes.dahlanikhsan.ui.util.FontWeight;
import com.ponpes.dahlanikhsan.ui.util.LumoStyles;
import com.ponpes.dahlanikhsan.ui.util.UIUtils;
import com.ponpes.dahlanikhsan.ui.util.css.BorderRadius;

public class Initials extends FlexBoxLayout {

	private String CLASS_NAME = "initials";

	public Initials(String initials) {
		setAlignItems(Alignment.CENTER);
		setBackgroundColor(LumoStyles.Color.Contrast._10);
		setBorderRadius(BorderRadius.L);
		setClassName(CLASS_NAME);
		UIUtils.setFontSize(FontSize.S, this);
		UIUtils.setFontWeight(FontWeight._600, this);
		setHeight(LumoStyles.Size.M);
		setJustifyContentMode(JustifyContentMode.CENTER);
		setWidth(LumoStyles.Size.M);

		add(initials);
	}

}
