package com.dinesh.smsapi.forms;

import com.dinesh.smsapi.entities.Orientatie;
import com.dinesh.smsapi.entities.Role;
import com.dinesh.smsapi.entities.Status;
import com.dinesh.smsapi.entities.Study;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;

import java.util.List;

public class StudentForm extends FormLayout {
    TextField firstName = new TextField("Naam");
    TextField surname = new TextField("Familienaam");
    TextField adres = new TextField("Adress");
    NumberField cohort = new NumberField("Cohort");
    ComboBox<String> geslacht = new ComboBox<>("Geslacht");
    ComboBox<Role> roleComboBox = new ComboBox<>("Rol");
    ComboBox<Status> statusComboBox = new ComboBox<>("Status");
    ComboBox<Orientatie> orientatieComboBox = new ComboBox<>("Orientatie");
    ComboBox<Study> studyComboBox = new ComboBox<>("Studie");
    Button save = new Button("save");
    Button delete = new Button("delete");
    Button close = new Button("cancel");

    public StudentForm(List<Role> roleList, List<Status> statusList,
                       List<Orientatie> orientatieList, List<Study> studyList) {
        roleComboBox.setItems(roleList);
        roleComboBox.setItemLabelGenerator(Role::getRole);
        statusComboBox.setItems(statusList);
        statusComboBox.setItemLabelGenerator(Status::getStatus);
        orientatieComboBox.setItems(orientatieList);
        orientatieComboBox.setItemLabelGenerator(Orientatie::getOrientatie_keuze);
        studyComboBox.setItems(studyList);
        studyComboBox.setItemLabelGenerator(Study::getStudy_name);

        add(firstName, surname, roleComboBox, geslacht,
                studyComboBox, cohort, orientatieComboBox,
                adres, statusComboBox, createButtonsLayout());
    }

    private HorizontalLayout createButtonsLayout() {
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        delete.addThemeVariants(ButtonVariant.LUMO_ERROR);
        close.addThemeVariants(ButtonVariant.LUMO_TERTIARY);

        save.addClickShortcut(Key.ENTER);
        close.addClickShortcut(Key.ESCAPE);
        return new HorizontalLayout(save, delete, close);
    }
}
