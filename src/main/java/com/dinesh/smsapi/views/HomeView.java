package com.dinesh.smsapi.views;

import com.dinesh.smsapi.entities.Student;
import com.dinesh.smsapi.forms.StudentForm;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.util.Collections;

@Route(value = "")
//@Theme(themeFolder = "flowsms")
@PageTitle("Home")
public class HomeView extends VerticalLayout {
    StudentForm studentForm;
    Grid<Student> grid = new Grid<>(Student.class);
    TextField filterText = new TextField();

    public HomeView() {
        addClassName("list-view");
        setSizeFull();
        configureGrid();
        configureForm();
        add(getToolbar(), getContents());
    }

    private void configureGrid() {
        grid.addClassName("student-grid");
        grid.setSizeFull();
        grid.addColumn(student -> student.getPerson().getName()).setHeader("Name");
        grid.addColumn(student -> student.getPerson().getLast_name()).setHeader("Surname");
        grid.addColumn(student -> student.getStudy().getFaculty().getFaculty_name()).setHeader("Faculty");
        grid.addColumn(student -> student.getStudy().getStudy_name()).setHeader("Study");
        grid.addColumn(student -> student.getCohort()).setHeader("Cohort");
        grid.getColumns().forEach(col -> col.setAutoWidth(true));
    }

    private void configureForm() {
        studentForm = new StudentForm(Collections.emptyList(), Collections.emptyList(),
                Collections.emptyList(), Collections.emptyList());
        studentForm.setWidth("25em");
    }

    //toolbar for filtering
    private HorizontalLayout getToolbar() {
        filterText.setPlaceholder("filter by name");
        filterText.setClearButtonVisible(true);
        filterText.setValueChangeMode(ValueChangeMode.LAZY);

        Button addNewContact = new Button();

        HorizontalLayout toolbar = new HorizontalLayout(filterText, addNewContact);
        toolbar.addClassName("home-toolbar");
        return toolbar;
    }

    //Group all components together and send to constr
    private Component getContents() {
        HorizontalLayout content = new HorizontalLayout(grid, studentForm);
        content.setFlexGrow(2, grid);
        content.setFlexGrow(1, studentForm);
        content.addClassName("content");
        content.setSizeFull();
        return content;
    }
}
