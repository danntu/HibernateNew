import bean.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class StoreData {
    public static void main(String[] args) {
        StandardServiceRegistry standardServiceRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(standardServiceRegistry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Employee e1=new Employee();
        e1.setId(101);
        e1.setFirstName("Daniyar Updated");
        e1.setLastName("Myrzakanov");

        //insert record
        session.save(e1);

        //update record
        //session.update(e1);

        //delete record
        //session.delete(e1);

        transaction.commit();
        System.out.println("successfully saved");
        sessionFactory.close();
        session.close();

    }
}
