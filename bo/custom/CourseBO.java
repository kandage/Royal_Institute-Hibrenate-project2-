package lk.royalIstitute.bo.custom;

import lk.royalIstitute.bo.SuperBO;
import lk.royalIstitute.dto.CourseDTO;

import java.util.List;

public interface CourseBO extends SuperBO {

     boolean addCourse(CourseDTO courseDTO) throws Exception;
     boolean updateCourse(CourseDTO courseDTO) throws Exception;
     boolean deleteCourse(CourseDTO courseDTO) throws Exception;
     List<CourseDTO> getAll() throws Exception;
     CourseDTO search(CourseDTO courseDTO) throws Exception;

}
