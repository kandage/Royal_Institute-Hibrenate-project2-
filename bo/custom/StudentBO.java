package lk.royalIstitute.bo.custom;

import lk.royalIstitute.bo.SuperBO;
import lk.royalIstitute.dto.StudentDTO;

import java.util.List;

public interface StudentBO extends SuperBO {
    boolean addCourse(StudentDTO studentDTO) throws Exception;
    boolean updateCourse(StudentDTO studentDTO) throws Exception;
    boolean deleteCourse(StudentDTO studentDTO) throws Exception;
    List<StudentDTO> getAll() throws Exception;
    StudentDTO search(StudentDTO studentDTO) throws Exception;
}

