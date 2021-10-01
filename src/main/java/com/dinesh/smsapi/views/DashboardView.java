package com.dinesh.smsapi.views;

import com.dinesh.smsapi.SmsService;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.charts.Chart;
import com.vaadin.flow.component.charts.model.ChartType;
import com.vaadin.flow.component.charts.model.DataSeries;
import com.vaadin.flow.component.charts.model.DataSeriesItem;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = "dashboard", layout = MainLayout.class)
@PageTitle("Dashboard | smsApp")
public class DashboardView extends VerticalLayout {
    private final SmsService service;

    public DashboardView(SmsService service) {
        this.service = service;
        addClassName("dashboard-view");
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        add(getStudentsStats(), getFacultiesChart());
    }

    private Component getStudentsStats() {
        Span stats = new Span(service.countStudents() + " students");
        stats.addClassNames("text-x1", "mt-m");
        return stats;
    }

    private Chart getFacultiesChart() {
        Chart chart = new Chart(ChartType.PIE);

        DataSeries dataSeries = new DataSeries();
        service.getAllStudy().forEach(study ->
                dataSeries.add(new DataSeriesItem(study.getStudy(), 5)));
        chart.getConfiguration().setSeries(dataSeries);
        return chart;
    }
}
