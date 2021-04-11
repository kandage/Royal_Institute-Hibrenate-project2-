package lk.royalIstitute.bo.custom;


import lk.royalIstitute.bo.SuperBO;
import lk.royalIstitute.dto.RegistrationDTO;

import java.util.List;

public interface RegistrationBO extends SuperBO {
    boolean addCourse(RegistrationDTO registrationDTO) throws Exception;
    boolean updateCourse(RegistrationDTO registrationDTO) throws Exception;
    boolean deleteCourse(RegistrationDTO registrationDTO) throws Exception;
    List<RegistrationDTO> getAll() throws Exception;
    RegistrationDTO search(RegistrationDTO registrationDTO) throws Exception;
    List<RegistrationDTO> getAllRegistration(String studentId) throws Exception;

}
