package com.dinesh.smsapi.forms;

import com.dinesh.smsapi.entities.Role;
import com.dinesh.smsapi.entities.Status;
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

import java.util.List;

public class PersonForm extends FormLayout {
    Binder<Person> personBinder = new Binder<>(Person.class);
    Person person;
    TextField firstName = new TextField("Naam");
    TextField surname = new TextField("Familienaam");
    ComboBox<Role> roleComboBox = new ComboBox<>("Rol");
    ComboBox<Status> statusComboBox = new ComboBox<>("Status");
    Button save = new Button("save");
    Button delete = new Button("delete");
    Button close = new Button("cancel");


    public PersonForm(List<Role> roleList, List<Status> statusList) {
        roleComboBox.setItems(roleList);
        roleComboBox.setItemLabelGenerator(Role::getRole);
        statusComboBox.setItems(statusList);
        statusComboBox.setItemLabelGenerator(Status::getStatus);

        configBinder();

        add(firstName, surname, roleComboBox, statusComboBox, createButtonsLayout());
    }

    public void configBinder() {
        personBinder.bind(firstName, Person::getName, Person::setName);
        personBinder.bind(surname, Person::getLast_name, Person::setLast_name);
        personBinder.bind(roleComboBox, Person::getRole, Person::setRole);
        personBinder.bind(statusComboBox, Person::getStatus, Person::setStatus);
    }

    private HorizontalLayout createButtonsLayout() {
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        delete.addThemeVariants(ButtonVariant.LUMO_ERROR);
        close.addThemeVariants(ButtonVariant.LUMO_TERTIARY);

        save.addClickShortcut(Key.ENTER);
        close.addClickShortcut(Key.ESCAPE);

        save.addClickListener(event -> validateAndSave());
        delete.addClickListener(event -> fireEvent(new PersonForm.DeleteEvent(this, person)));
        close.addClickListener(event -> fireEvent(new PersonForm.CloseEvent(this)));

        personBinder.addStatusChangeListener(e -> save.setEnabled(personBinder.isValid()));

        return new HorizontalLayout(save, delete, close);
    }

    private void validateAndSave() {
        try {
            personBinder.writeBean(person);
            fireEvent(new SaveEvent(this, person));
        } catch (ValidationException e) {
            e.printStackTrace();
        }
    }

    public void setPerson(Person person) {
        this.person = person;
        personBinder.readBean(person);
    }

    public static abstract class PersonFormEvent extends ComponentEvent<PersonForm> {
        private Person person;

        protected PersonFormEvent(PersonForm source, Person person) {
            super(source, false);
            this.person = person;
        }

        public Person getPerson() {
            return person;
        }
    }

    public static class SaveEvent extends PersonForm.PersonFormEvent {
        SaveEvent(PersonForm source, Person person) {
            super(source, person);
        }
    }

    public static class DeleteEvent extends PersonForm.PersonFormEvent {
        DeleteEvent(PersonForm source, Person person) {
            super(source, person);
        }

    }

    public static class CloseEvent extends PersonForm.PersonFormEvent {
        CloseEvent(PersonForm source) {
            super(source, null);
        }
    }

    public <T extends ComponentEvent<?>> Registration addListener(Class<T> eventType,
                                                                  ComponentEventListener<T> listener) {
        return getEventBus().addListener(eventType, listener);
    }
}
