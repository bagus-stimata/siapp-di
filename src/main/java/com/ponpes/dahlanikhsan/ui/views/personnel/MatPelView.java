package com.ponpes.dahlanikhsan.ui.views.personnel;

import com.ponpes.dahlanikhsan.MainView;
import com.ponpes.dahlanikhsan.backend.domain.example.DummyData;
import com.ponpes.dahlanikhsan.backend.model.MatPel;
import com.ponpes.dahlanikhsan.ui.components.FlexBoxLayout;
import com.ponpes.dahlanikhsan.ui.components.Initials;
import com.ponpes.dahlanikhsan.ui.components.ListItem;
import com.ponpes.dahlanikhsan.ui.components.detailsdrawer.DetailsDrawer;
import com.ponpes.dahlanikhsan.ui.components.detailsdrawer.DetailsDrawerFooter;
import com.ponpes.dahlanikhsan.ui.components.detailsdrawer.DetailsDrawerHeader;
import com.ponpes.dahlanikhsan.ui.layout.size.Horizontal;
import com.ponpes.dahlanikhsan.ui.layout.size.Right;
import com.ponpes.dahlanikhsan.ui.layout.size.Top;
import com.ponpes.dahlanikhsan.ui.layout.size.Vertical;
import com.ponpes.dahlanikhsan.ui.util.LumoStyles;
import com.ponpes.dahlanikhsan.ui.util.UIUtils;
import com.ponpes.dahlanikhsan.ui.util.css.BoxSizing;
import com.ponpes.dahlanikhsan.ui.views.SplitViewFrame;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.ColumnTextAlign;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.radiobutton.RadioGroupVariant;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.data.provider.DataProvider;
import com.vaadin.flow.data.provider.ListDataProvider;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = "matPelView", layout = MainView.class)
@PageTitle("Mata Pelajaran")
public class MatPelView extends SplitViewFrame {

	private Grid<MatPel> grid;
	private ListDataProvider<MatPel> dataProvider;

	private DetailsDrawer detailsDrawer;
	private DetailsDrawerHeader detailsDrawerHeader;

	public MatPelView() {
		setViewContent(createContent());
		setViewDetails(createDetailsDrawer());

		filter();
	}

	private Component createContent() {
		FlexBoxLayout content = new FlexBoxLayout(createGrid());
		content.setBoxSizing(BoxSizing.BORDER_BOX);
		content.setHeightFull();
		content.setPadding(Horizontal.RESPONSIVE_X, Top.RESPONSIVE_X);
		return content;
	}

	private Grid createGrid() {
		grid = new Grid<>();
		grid.addSelectionListener(event -> event.getFirstSelectedItem()
				.ifPresent(this::showDetails));
		dataProvider = DataProvider.ofCollection(DummyData.getMatPels());
		grid.setDataProvider(dataProvider);
		grid.setHeightFull();

		grid.addColumn(MatPel::getId)
				.setAutoWidth(true)
				.setFlexGrow(0)
				.setFrozen(true)
				.setHeader("ID")
				.setSortable(true);
		grid.addColumn(new ComponentRenderer<>(this::createUserInfo))
				.setAutoWidth(true)
				.setHeader("Name");
		grid.addColumn(new ComponentRenderer<>(this::createActive))
				.setAutoWidth(true)
				.setFlexGrow(0)
				.setHeader("Active")
				.setTextAlign(ColumnTextAlign.END);
		grid.addColumn(new ComponentRenderer<>(this::createInvoices))
				.setAutoWidth(true)
				.setFlexGrow(0)
				.setHeader("Invoices")
				.setTextAlign(ColumnTextAlign.END);
		grid.addColumn(new ComponentRenderer<>(this::createCompanies))
				.setAutoWidth(true)
				.setFlexGrow(0)
				.setHeader("Companies")
				.setTextAlign(ColumnTextAlign.END);
		grid.addColumn(new ComponentRenderer<>(this::createDate)).setFlexGrow(0)
				.setAutoWidth(true)
				.setFlexGrow(0)
				.setHeader("Last Report")
				.setTextAlign(ColumnTextAlign.END);

		return grid;
	}

	private Component createUserInfo(MatPel itemHeader) {
		ListItem item = new ListItem(
				new Initials(itemHeader.getInitials()), itemHeader.getDescription(),
				itemHeader.getKode1());
		item.setPadding(Vertical.XS);
		item.setSpacing(Right.M);
		return item;
	}

	private Component createActive(MatPel person) {
		Icon icon;
		if (person.getRandomBoolean()) {
			icon = UIUtils.createPrimaryIcon(VaadinIcon.CHECK);
		} else {
			icon = UIUtils.createDisabledIcon(VaadinIcon.CLOSE);
		}
		return icon;
	}

	private Component createInvoices() {
		return UIUtils.createAmountLabel(DummyData.getRandomInt(0, 5000));
	}

	private Component createCompanies() {
		return UIUtils.createUnitsLabel(DummyData.getRandomInt(0, 50));
	}

	private Component createDate(MatPel person) {
//		return new Span(UIUtils.formatDate(person.getLastModified()));
		return new Span("tes");
	}

	private DetailsDrawer createDetailsDrawer() {
		detailsDrawer = new DetailsDrawer(DetailsDrawer.Position.RIGHT);

		// Header
		detailsDrawerHeader = new DetailsDrawerHeader("");
		detailsDrawerHeader.addCloseListener(buttonClickEvent -> detailsDrawer.hide());
		detailsDrawer.setHeader(detailsDrawerHeader);

		// Footer
		DetailsDrawerFooter footer = new DetailsDrawerFooter();
		footer.addSaveListener(e -> {
			detailsDrawer.hide();
			UIUtils.showNotification("Changes saved.");
		});
		footer.addCancelListener(e -> detailsDrawer.hide());
		detailsDrawer.setFooter(footer);

		return detailsDrawer;
	}

	private void showDetails(MatPel person) {
		detailsDrawerHeader.setTitle(person.getDescription());
		detailsDrawer.setContent(createDetails(person));
		detailsDrawer.show();
	}

	private FormLayout createDetails(MatPel person) {
		TextField firstName = new TextField();
		firstName.setValue(person.getNotes());
		firstName.setWidthFull();

		TextField lastName = new TextField();
		lastName.setValue(person.getNotes());
		lastName.setWidthFull();

		RadioButtonGroup<String> gender = new RadioButtonGroup<>();
		gender.addThemeVariants(RadioGroupVariant.LUMO_VERTICAL);
		gender.setItems("Active", "Inactive");
		gender.setValue(person.getRandomBoolean() ? "Active" : "Inactive");

		FlexLayout phone = UIUtils.createPhoneLayout();

		TextField email = new TextField();
		email.setValue(person.getKode1());
		email.setWidthFull();

		ComboBox company = new ComboBox();
		company.setItems(DummyData.getCompanies());
		company.setValue(DummyData.getCompany());
		company.setWidthFull();

		// Form layout
		FormLayout form = new FormLayout();
		form.addClassNames(LumoStyles.Padding.Bottom.L,
				LumoStyles.Padding.Horizontal.L, LumoStyles.Padding.Top.S);
		form.setResponsiveSteps(
				new FormLayout.ResponsiveStep("0", 1,
						FormLayout.ResponsiveStep.LabelsPosition.TOP),
				new FormLayout.ResponsiveStep("21em", 2,
						FormLayout.ResponsiveStep.LabelsPosition.TOP));
		form.addFormItem(firstName, "First Name");
		form.addFormItem(lastName, "Last Name");
		FormLayout.FormItem statusItem = form.addFormItem(gender, "Status");
		FormLayout.FormItem phoneItem = form.addFormItem(phone, "Phone");
		FormLayout.FormItem emailItem = form.addFormItem(email, "Email");
		FormLayout.FormItem companyItem = form.addFormItem(company, "Company");
		FormLayout.FormItem uploadItem = form.addFormItem(new Upload(),
				"Image");
		UIUtils.setColSpan(2, statusItem, phoneItem, emailItem, companyItem,
				uploadItem);
		return form;
	}

	private void filter() {
//		dataProvider.setFilterByValue(MatPel::getRole, MatPel.Role.ACCOUNTANT);
	}

}
