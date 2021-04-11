package lk.royalIstitute.dao.custom;


import lk.royalIstitute.dao.CrudDAO;
import lk.royalIstitute.entity.Registration;

import java.util.List;

public interface RegistrationDAO extends CrudDAO<Registration,String> {
    List<Registration> getAllRegistration(String studentId) throws Exception;
}
