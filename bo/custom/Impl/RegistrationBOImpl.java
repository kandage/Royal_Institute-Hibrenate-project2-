package lk.royalIstitute.bo.custom.Impl;


import lk.royalIstitute.bo.custom.RegistrationBO;
import lk.royalIstitute.dao.DAOFactory;
import lk.royalIstitute.dao.custom.RegistrationDAO;
import lk.royalIstitute.dto.CourseDTO;
import lk.royalIstitute.dto.RegistrationDTO;
import lk.royalIstitute.dto.StudentDTO;
import lk.royalIstitute.entity.Course;
import lk.royalIstitute.entity.Registration;
import lk.royalIstitute.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class RegistrationBOImpl implements RegistrationBO {

    private RegistrationDAO registrationDAO;

    public RegistrationBOImpl() {
        registrationDAO= (RegistrationDAO) DAOFactory.getDaoFactory().getSuperDAO(DAOFactory.DAOType.Registration);
    }

    @Override
    public boolean addCourse(RegistrationDTO registrationDTO) throws Exception {
        return registrationDAO.add(makeRegistrationForSave(registrationDTO));
    }

    @Override
    public boolean updateCourse(RegistrationDTO registrationDTO) throws Exception {
        return registrationDAO.update(makeRegistration(registrationDTO));
    }

    @Override
    public boolean deleteCourse(RegistrationDTO registrationDTO) throws Exception {
        return registrationDAO.delete(makeRegistration(registrationDTO));
    }


    @Override
    public List<RegistrationDTO> getAll() throws Exception {
        List<RegistrationDTO> registrationDTOS=new ArrayList<>();
        List<Registration> registrations=registrationDAO.getAll();
        for (Registration registration : registrations) {
            registrationDTOS.add(makeRegistrationDTO(registration));
        }
        return registrationDTOS;
    }

    @Override
    public RegistrationDTO search(RegistrationDTO registrationDTO) throws Exception {
        return null;
    }

    @Override
    public List<RegistrationDTO> getAllRegistration(String studentId) throws Exception {
        List<RegistrationDTO> registrationDTOS=new ArrayList<>();
        List<Registration> registrations=registrationDAO.getAllRegistration(studentId);
        for (Registration registration : registrations) {
            registrationDTOS.add(makeRegistrationDTO(registration));
        }
        return registrationDTOS;
    }

    private Registration makeRegistrationForSave(RegistrationDTO registrationDTO){
        return new Registration(registrationDTO.getRegDate(),registrationDTO.getRegFee(),
                makeStudent(registrationDTO.getStudentDTO()),makeCourse(registrationDTO.getCourseDTO()));
    }

    private Registration makeRegistration(RegistrationDTO registrationDTO){
        return new Registration(registrationDTO.getRegNo(),registrationDTO.getRegDate(),registrationDTO.getRegFee(),
                makeStudent(registrationDTO.getStudentDTO()),makeCourse(registrationDTO.getCourseDTO()));
    }

    private RegistrationDTO makeRegistrationDTO(Registration registration){
        return new RegistrationDTO(registration.getRegNo(),registration.getRegDate(),registration.getRegFee(),
                makeStudentDTO(registration.getStudent()),makeCourseDTO(registration.getCourse()));
    }

    private Student makeStudent(StudentDTO studentDTO) {
        return new Student(studentDTO.getId(), studentDTO.getStudentName(), studentDTO.getAddress(),
                studentDTO.getContact(), studentDTO.getDate(), studentDTO.getGender());
    }

    private StudentDTO makeStudentDTO(Student student) {
        return new StudentDTO(student.getId(), student.getStudentName(), student.getAddress(),
                student.getContact(), student.getDate(), student.getGender());
    }

    private Course makeCourse(CourseDTO courseDTO){
        return new Course(courseDTO.getCode(),courseDTO.getCourseName(),courseDTO.getDuration(),courseDTO.getCourseFee());
    }
    private CourseDTO makeCourseDTO(Course course){
        return new CourseDTO(course.getCode(),course.getCourseName(),course.getDuration(),course.getCourseFee());
    }
}
