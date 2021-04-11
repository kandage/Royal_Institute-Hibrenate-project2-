package lk.royalIstitute.bo.custom.Impl;

import lk.royalIstitute.bo.custom.CourseBO;
import lk.royalIstitute.dao.DAOFactory;
import lk.royalIstitute.dao.custom.CourseDAO;
import lk.royalIstitute.dto.CourseDTO;
import lk.royalIstitute.entity.Course;

import java.util.ArrayList;
import java.util.List;

public class CourseBOImpl implements CourseBO {

    private CourseDAO courseDAO;

    public CourseBOImpl(){
        courseDAO= (CourseDAO) DAOFactory.getDaoFactory().getSuperDAO(DAOFactory.DAOType.Course);
    }

    @Override
    public boolean addCourse(CourseDTO courseDTO) throws Exception {
        return courseDAO.add(makeCourse(courseDTO));
    }

    @Override
    public boolean updateCourse(CourseDTO courseDTO) throws Exception {
        return courseDAO.update(makeCourse(courseDTO));
    }

    @Override
    public boolean deleteCourse(CourseDTO courseDTO) throws Exception {
        return courseDAO.delete(makeCourse(courseDTO));
    }

    @Override
    public List<CourseDTO> getAll() throws Exception {
        List<CourseDTO> courseDTOS=new ArrayList<>();
        List<Course> courses=courseDAO.getAll();
        for (Course course :courses) {
            courseDTOS.add(makeCourseDTO(course));
        }
        return courseDTOS;
    }

    @Override
    public CourseDTO search(CourseDTO courseDTO) throws Exception {
        return makeCourseDTO(courseDAO.search(makeCourse(courseDTO)));
    }

    private Course makeCourse(CourseDTO courseDTO){
        return new Course(courseDTO.getCode(),courseDTO.getCourseName(),courseDTO.getDuration(),courseDTO.getCourseFee());
    }
    private CourseDTO makeCourseDTO(Course course){
        return new CourseDTO(course.getCode(),course.getCourseName(),course.getDuration(),course.getCourseFee());
    }
}
