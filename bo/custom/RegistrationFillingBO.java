package lk.royalIstitute.bo.custom;


import lk.royalIstitute.bo.SuperBO;
import lk.royalIstitute.dto.RegistrationDTO;
import lk.royalIstitute.dto.StudentDTO;

import java.util.List;

public interface RegistrationFillingBO extends SuperBO {
    boolean saveRegistration(StudentDTO studentDTO, List<RegistrationDTO> registrationDTOS);
}
