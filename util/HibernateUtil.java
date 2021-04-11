package lk.royalIstitute.util;
import lk.royalIstitute.entity.Course;
import lk.royalIstitute.entity.Registration;
import lk.royalIstitute.entity.Student;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {

    private static SessionFactory sessionFactory=buildSessionFactory();

    private static SessionFactory buildSessionFactory(){

        StandardServiceRegistry sReg=new StandardServiceRegistryBuilder()
                .loadProperties("lk/royalInstitute/application.properties")
                .build();

        Metadata mData=new MetadataSources(sReg)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Registration.class)
                .getMetadataBuilder().build();
        return mData.getSessionFactoryBuilder().build();

    }

    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }
}
