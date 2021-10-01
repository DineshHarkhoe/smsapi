package com.dinesh.smsapi.forms;

import com.dinesh.smsapi.entities.Orientatie;
import com.dinesh.smsapi.entities.Status;
import com.dinesh.smsapi.entities.Student;
import com.dinesh.smsapi.entities.Study;
import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.shared.Registration;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class StudentForm extends FormLayout {
    Binder<Student> studentBinder = new Binder<>(Student.class);
    Student student;
    List<Integer> yearRange = new ArrayList<>();
    TextField name = new TextField("Name");
    TextField surname = new TextField("Surname");
    ComboBox<Integer> cohort = new ComboBox<>("Cohort");
    ComboBox<String> geslacht = new ComboBox<>("Geslacht");
    ComboBox<Orientatie> orientatieComboBox = new ComboBox<>("Orientatie");
    ComboBox<Study> studyComboBox = new ComboBox<>("Studie");
    ComboBox<Status> statusComboBox = new ComboBox<>("Status");
    Button save = new Button("save");
    Button delete = new Button("delete");
    Button close = new Button("cancel");

    public StudentForm(List<Orientatie> orientatieList, List<Study> studyList,
                       List<Status> statusList) {
        for (int p = LocalDateTime.now().getYear() - 20; p <= LocalDateTime.now().getYear(); p++) {
            yearRange.add(p);
        }
        orientatieComboBox.setItems(orientatieList);
        orientatieComboBox.setItemLabelGenerator(Orientatie::getOrientatie);
        studyComboBox.setItems(studyList);
        studyComboBox.setItemLabelGenerator(Study::getStudy);
        statusComboBox.setItems(statusList);
        statusComboBox.setItemLabelGenerator(Status::getStatus);
        geslacht.setItems("man", "vrouw", "nvt");
        cohort.setItems(yearRange);

        configBinder();

        add(name, surname, geslacht, studyComboBox, cohort,
                statusComboBox, orientatieComboBox, createButtonsLayout());
    }

    private void configBinder() {
        studentBinder.bind(name, Student::getStudent_name, Student::setStudent_name);
        studentBinder.bind(surname, Student::getStudent_surname, Student::setStudent_surname);
        studentBinder.bind(cohort, Student::getCohort, Student::setCohort);
        studentBinder.bind(geslacht, Student::getGeslacht, Student::setGeslacht);
        studentBinder.bind(orientatieComboBox, Student::getOrientatie, Student::setOrientatie);
        studentBinder.bind(studyComboBox, Student::getStudy, Student::setStudy);
        studentBinder.bind(statusComboBox, Student::getStatus, Student::setStatus);
    }

    public void setStudent(Student student) {
        this.student = student;
        studentBinder.readBean(student);
    }

    private HorizontalLayout createButtonsLayout() {
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        delete.addThemeVariants(ButtonVariant.LUMO_ERROR);
        close.addThemeVariants(ButtonVariant.LUMO_TERTIARY);

        save.addClickShortcut(Key.ENTER);
        close.addClickShortcut(Key.ESCAPE);

        save.addClickListener(event -> validateAndSave());
        delete.addClickListener(event -> fireEvent(new DeleteEvent(this, student)));
        close.addClickListener(event -> fireEvent(new CloseEvent(this)));

        studentBinder.addStatusChangeListener(e -> save.setEnabled(studentBinder.isValid()));

        return new HorizontalLayout(save, delete, close);
    }

    private void validateAndSave() {
        try {
            studentBinder.writeBean(student);
            fireEvent(new SaveEvent(this, student));
        } catch (ValidationException e) {
            e.printStackTrace();
        }
    }

    public static abstract class StudentFormEvent extends ComponentEvent<StudentForm> {
        private Student student;

        protected StudentFormEvent(StudentForm source, Student student) {


            super(source, false);
            this.student = student;
        }

        public Student getStudent() {
            return student;
        }
    }

    public static class SaveEvent extends StudentFormEvent {
        SaveEvent(StudentForm source, Student student) {
            super(source, student);
        }
    }

    public static class DeleteEvent extends StudentFormEvent {
        DeleteEvent(StudentForm source, Student student) {
            super(source, student);
        }

    }

    public static class CloseEvent extends StudentFormEvent {
        CloseEvent(StudentForm source) {
            super(source, null);
        }
    }

    public <T extends ComponentEvent<?>> Registration addListener(Class<T> eventType,
                                                                  ComponentEventListener<T> listener) {
        return getEventBus().addListener(eventType, listener);
    }
}
