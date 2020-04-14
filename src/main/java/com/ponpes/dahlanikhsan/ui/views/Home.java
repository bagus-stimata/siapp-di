package com.ponpes.dahlanikhsan.ui.views;

import com.ponpes.dahlanikhsan.MainView;
import com.ponpes.dahlanikhsan.backend.domain.example.Payment;
import com.ponpes.dahlanikhsan.ui.components.DataSeriesItemWithRadius;
import com.ponpes.dahlanikhsan.ui.components.FlexBoxLayout;
import com.ponpes.dahlanikhsan.ui.layout.size.Horizontal;
import com.ponpes.dahlanikhsan.ui.layout.size.Right;
import com.ponpes.dahlanikhsan.ui.util.*;
import com.ponpes.dahlanikhsan.ui.util.css.*;
import com.ponpes.dahlanikhsan.ui.util.css.Position;
import com.vaadin.flow.component.Component;
//import com.vaadin.flow.component.board.Row;
//import com.vaadin.flow.component.charts.Chart;
//import com.vaadin.flow.component.charts.model.*;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Home Ponpes Dahlan Ikhsan")
//@Route(value = "home", layout = MainView.class) //Main layout tidak perlu untuk di beri @Route
@Route(value = "", layout = MainView.class)
public class Home extends ViewFrame {

	private static final String CLASS_NAME = "home";
	public static final String MAX_WIDTH = "1024px";

	public Home() {
		setId("home");
//		setViewContent(createContent());
	}

	private Component createContent() {
//		Component createBanner = createBanner();
//		
//		Component dataProgress = createDataProgresChart();
//		
//		Component transactions = createTransactions();
//		Component docs = createDocs();

//		FlexBoxLayout content = new FlexBoxLayout(p, transactions, docs);
//		FlexBoxLayout content = new FlexBoxLayout(dataProgress);
//		content.setAlignItems(FlexComponent.Alignment.CENTER);
//		content.setFlexDirection(FlexDirection.COLUMN);

		FlexBoxLayout content = new FlexBoxLayout();
		return content;
	}


//	private Component createDataProgresChart() {
//		FlexBoxLayout dataProgress = new FlexBoxLayout(
//				createDataProgresChart_Header(VaadinIcon.TIMER, "Data Progres"),
//				createDataProgressChart_Content());
//		dataProgress.setBoxSizing(BoxSizing.BORDER_BOX);
//		dataProgress.setDisplay(Display.BLOCK);
//		dataProgress.setMargin(com.ponpes.dahlanikhsan.ui.layout.size.Top.L);
//		dataProgress.setMaxWidth(MAX_WIDTH);
//		dataProgress.setPadding(Horizontal.RESPONSIVE_L);
//		dataProgress.setWidthFull();
//		return dataProgress;
//	}

	private FlexBoxLayout createDataProgresChart_Header(VaadinIcon icon, String title) {
		FlexBoxLayout header = new FlexBoxLayout(
				UIUtils.createIcon(IconSize.M, TextColor.TERTIARY, icon),
				UIUtils.createH3Label(title));
		header.setAlignItems(FlexComponent.Alignment.CENTER);
		header.setMargin(com.ponpes.dahlanikhsan.ui.layout.size.Bottom.L, Horizontal.RESPONSIVE_L);
		header.setSpacing(Right.L);
		return header;
	}

//	private Component createDataProgressChart_Content() {
//		Row charts = new Row();
//		UIUtils.setBackgroundColor(LumoStyles.Color.BASE_COLOR, charts);
//		UIUtils.setBorderRadius(BorderRadius.S, charts);
//		UIUtils.setShadow(Shadow.XS, charts);
//
//		for (Payment.Status status : Payment.Status.values()) {
//			charts.add(createDataProgressChart_Content_Item(status));
//		}
//
//		return charts;
//	}

//	private Component createDataProgressChart_Content_Item(Payment.Status status) {
//		int value;
//
//		switch (status) {
//			case PENDING:
//				value = 24;
//				break;
//
//			case SUBMITTED:
//				value = 40;
//				break;
//
//			case CONFIRMED:
//				value = 32;
//				break;
//
//			default:
//				value = 4;
//				break;
//		}
//
//		FlexBoxLayout textContainer = new FlexBoxLayout(
//				UIUtils.createH2Label(Integer.toString(value)),
//				UIUtils.createLabel(FontSize.S, "%"));
//		textContainer.setAlignItems(FlexComponent.Alignment.BASELINE);
//		textContainer.setPosition(com.ponpes.dahlanikhsan.ui.util.css.Position.ABSOLUTE);
//		textContainer.setSpacing(Right.XS);
//
//		Chart chart = createProgressChart(status, value);
//
//		FlexBoxLayout chartContainer = new FlexBoxLayout(chart, textContainer);
//		chartContainer.setAlignItems(FlexComponent.Alignment.CENTER);
//		chartContainer
//				.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
//		chartContainer.setPosition(Position.RELATIVE);
//		chartContainer.setHeight("120px");
//		chartContainer.setWidth("120px");
//
//		FlexBoxLayout paymentChart = new FlexBoxLayout(
//				new Label(status.getName()), chartContainer);
//		paymentChart.addClassName(CLASS_NAME + "__payment-chart");
//		paymentChart.setAlignItems(FlexComponent.Alignment.CENTER);
//		paymentChart.setFlexDirection(FlexDirection.COLUMN);
//		paymentChart.setPadding(com.ponpes.dahlanikhsan.ui.layout.size.Bottom.S, com.ponpes.dahlanikhsan.ui.layout.size.Top.M);
//		return paymentChart;
//	}

//	private Chart createProgressChart(Payment.Status status, int value) {
//		Chart chart = new Chart();
//		chart.addClassName(status.getName().toLowerCase());
//		chart.setSizeFull();
//
//		Configuration configuration = chart.getConfiguration();
//		configuration.getChart().setType(ChartType.SOLIDGAUGE);
//		configuration.setTitle("");
//		configuration.getTooltip().setEnabled(false);
//
//		configuration.getyAxis().setMin(0);
//		configuration.getyAxis().setMax(100);
//		configuration.getyAxis().getLabels().setEnabled(false);
//
//		PlotOptionsSolidgauge opt = new PlotOptionsSolidgauge();
//		opt.getDataLabels().setEnabled(false);
//		configuration.setPlotOptions(opt);
//
//		DataSeriesItemWithRadius point = new DataSeriesItemWithRadius();
//		point.setY(value);
//		point.setInnerRadius("100%");
//		point.setRadius("110%");
//		configuration.setSeries(new DataSeries(point));
//
//		Pane pane = configuration.getPane();
//		pane.setStartAngle(0);
//		pane.setEndAngle(360);
//
//		Background background = new Background();
//		background.setShape(BackgroundShape.ARC);
//		background.setInnerRadius("100%");
//		background.setOuterRadius("110%");
//		pane.setBackground(background);
//
//		return chart;
//	}

}
