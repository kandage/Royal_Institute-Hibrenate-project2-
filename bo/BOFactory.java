package lk.royalIstitute.bo;


import lk.royalIstitute.bo.custom.Impl.CourseBOImpl;
import lk.royalIstitute.bo.custom.Impl.RegistrationBOImpl;
import lk.royalIstitute.bo.custom.Impl.RegistrationFillingBOImpl;
import lk.royalIstitute.bo.custom.Impl.StudentBOImpl;

public class BOFactory {

    public enum BOType{
        Course,Student,Registration,RegistrationFilling
    }

    private static BOFactory boFactory;

    private BOFactory(){}

    public static BOFactory getBOFactory(){
        return (boFactory != null) ?boFactory:(boFactory=new BOFactory());
    }

    public SuperBO getSuperBO(BOType boType){
        switch (boType){
            case Registration:
                return new RegistrationBOImpl();
            case Student:
                return new StudentBOImpl();
            case Course:
                return new CourseBOImpl();
            case RegistrationFilling:
                return new RegistrationFillingBOImpl();
            default:
                return null;
        }
    }

}
