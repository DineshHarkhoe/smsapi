package com.dinesh.smsapi.views;

import com.dinesh.smsapi.SmsService;
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

@Route(value = "", layout = MainLayout.class)
@PageTitle("Home")
public class HomeView extends VerticalLayout {
    StudentForm studentForm;
    SmsService service;
    Grid<Student> grid = new Grid<>(Student.class);
    TextField filterText = new TextField();

    public HomeView(SmsService service) {
        this.service = service;
        addClassName("home-view");
        setSizeFull();
        configureGrid();
        configureForm();
        add(getToolbar(), getContents());
        updateGrid();
        closeEditor();
    }

    private void configureGrid() {
        grid.addClassName("student-grid");
        grid.setSizeFull();
        grid.removeAllColumns();
        grid.addColumn(Student::getStudent_name).setHeader("Name");
        grid.addColumn(Student::getStudent_surname).setHeader("Surname");
        grid.addColumn(student -> student.getStudy().getStudy()).setHeader("Study");
        grid.addColumn(student -> student.getStudy().getFaculty().getFaculty()).setHeader("Faculty");
        grid.addColumn(Student::getCohort).setHeader("Cohort");
        grid.getColumns().forEach(col -> col.setAutoWidth(true));

        grid.asSingleSelect().addValueChangeListener(event -> editStudent(event.getValue()));
    }

    private void configureForm() {
        studentForm = new StudentForm(service.getAllOrientatie(), service.getAllStudy(),
                service.getAllStatus());
        studentForm.setWidth("25em");
        studentForm.addListener(StudentForm.SaveEvent.class, this::saveStudent);
        studentForm.addListener(StudentForm.CloseEvent.class, e -> closeEditor());
        studentForm.addListener(StudentForm.DeleteEvent.class, this::deleteStudent);
    }

    //toolbar for filtering
    private HorizontalLayout getToolbar() {
        filterText.setPlaceholder("filter by name");
        filterText.setClearButtonVisible(true);
        filterText.setValueChangeMode(ValueChangeMode.LAZY);

        Button addStudentButton = new Button("Add student");
        addStudentButton.addClickListener(click -> addStudent());

        HorizontalLayout toolbar = new HorizontalLayout(filterText, addStudentButton);
        toolbar.addClassName("home-toolbar");
        return toolbar;
    }

    //Group all components together and send to constructor
    private Component getContents() {
        HorizontalLayout content = new HorizontalLayout(grid, studentForm);
        content.addClassName("content");
        content.setSizeFull();
        return content;
    }

    private void updateGrid() {
        grid.setItems(service.getAllStudents());
    }

    public void editStudent(Student student) {
        if (student == null) {
            closeEditor();
        } else {
            studentForm.setStudent(student);
            studentForm.setVisible(true);
            addClassName("editing");
        }
    }

    private void closeEditor() {
        studentForm.setStudent(null);
        studentForm.setVisible(false);
        removeClassName("editing");
    }

    private void addStudent() {
        grid.asSingleSelect().clear();
        editStudent(new Student());
    }

    private void saveStudent(StudentForm.SaveEvent event) {
        service.saveStudent(event.getStudent());
        updateGrid();
        closeEditor();
    }

    private void deleteStudent(StudentForm.DeleteEvent event) {
        service.deleteStudent(event.getStudent());
        updateGrid();
        closeEditor();
    }
}
