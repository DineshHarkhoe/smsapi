package com.dinesh.smsapi;

import com.dinesh.smsapi.entities.*;
import com.dinesh.smsapi.repositories.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SmsService {
    private final StudentRepository studentRepository;
    private final StudyRepository studyRepository;
    private final RoleRepository roleRepository;
    private final StatusRepository statusRepository;
    private final FacultyRepository facultyRepository;
    private final OrientatieRepository orientatieRepository;
    private final WetenschapperRepository wetenschapperRepository;
    private final SubjectRepository subjectRepository;
    private final GradeRepository gradeRepository;
    private final AdministratieRepository administratieRepository;
    private final Faculty_bestuurRepository faculty_bestuurRepository;
    private final StudcieRepository studcieRepository;

    public SmsService(StudentRepository studentRepository, StudyRepository studyRepository,
                      RoleRepository roleRepository, StatusRepository statusRepository,
                      FacultyRepository facultyRepository, OrientatieRepository orientatieRepository,
                      WetenschapperRepository wetenschapperRepository, SubjectRepository subjectRepository,
                      GradeRepository gradeRepository, AdministratieRepository administratieRepository,
                      Faculty_bestuurRepository faculty_bestuurRepository, StudcieRepository studcieRepository) {
        this.studentRepository = studentRepository;
        this.studyRepository = studyRepository;
        this.roleRepository = roleRepository;
        this.statusRepository = statusRepository;
        this.facultyRepository = facultyRepository;
        this.orientatieRepository = orientatieRepository;
        this.wetenschapperRepository = wetenschapperRepository;
        this.subjectRepository = subjectRepository;
        this.gradeRepository = gradeRepository;
        this.administratieRepository = administratieRepository;
        this.faculty_bestuurRepository = faculty_bestuurRepository;
        this.studcieRepository = studcieRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public List<Faculty> getAllFaculties() {
        return facultyRepository.findAll();
    }

    public List<Status> getAllStatus() {
        return statusRepository.findAll();
    }

    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    public List<Orientatie> getAllOrientatie() {
        return orientatieRepository.findAll();
    }

    public List<Study> getAllStudy() {
        return studyRepository.findAll();
    }

    public void saveStudent(Student student) {
        if (student == null) {
            System.err.println("Student is null");
            return;
        }
        studentRepository.save(student);
    }

    public void deleteStudent(Student student) {
        studentRepository.delete(student);
    }

    public long countStudents() {
        return studentRepository.count();
    }
}
