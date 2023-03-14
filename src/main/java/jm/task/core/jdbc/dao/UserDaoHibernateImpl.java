package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;


public class UserDaoHibernateImpl implements UserDao {
    public UserDaoHibernateImpl() {
    }

    @Override
    public void createUsersTable() {
        Session session = Util.getConcreteSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        String sql = "CREATE TABLE IF NOT EXISTS`test`.`user` (\n" +
                "  `id` BIGINT NOT NULL AUTO_INCREMENT,\n" +
                "  `name` VARCHAR(45) NULL,\n" +
                "  `lastName` VARCHAR(45) NULL,\n" +
                "  `age` INT NULL,\n" +
                "  PRIMARY KEY (`id`));\n";
        session.createSQLQuery(sql).executeUpdate();
        transaction.commit();
        session.close();
    }

    @Override
    public void dropUsersTable() {
        Session session = Util.getConcreteSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        String sql = "DROP TABLE IF EXISTS `test`.`user`;";
        session.createSQLQuery(sql).executeUpdate();
        transaction.commit();
        session.close();
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        User user = new User();
        user.setName(name);
        user.setLastName(lastName);
        user.setAge(age);
        Session session = Util.getConcreteSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.saveOrUpdate(user);
        tx1.commit();
        session.close();
    }

    @Override
    public void removeUserById(long id) {
        Session session = Util.getConcreteSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        String sql = "DELETE FROM `user` WHERE `id` = " + id;
        session.createSQLQuery(sql).executeUpdate();
        transaction.commit();
        session.close();

    }

    @Override
    public List<User> getAllUsers() {
        Session session = Util.getConcreteSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        List<User> users = session.createQuery("From User").list();
        transaction.commit();
        session.close();
        return users;
    }

    @Override
    public void cleanUsersTable() {
        Session session = Util.getConcreteSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        String sql = "TRUNCATE TABLE user; ";
        session.createSQLQuery(sql).executeUpdate();
        transaction.commit();
        session.close();
    }
}
