package ejemplo.dao;

import ejemplo.jpa.Departamentos;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ejemplo.jpa.Empleados;
import ejemplo.utilidades.Utilidades;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;

public class EmpleadoDAOImp implements EmpleadoDAO {

    private Session currentSession;
    private Transaction currentTransaction;

    @Override
    public void persist(Empleados empleado) {
        getCurrentSession().persist(empleado);
    }

    @Override
    public List<Object[]> getEmpleadoPorDep(byte depNo) {
        List<Object[]> empleados = (List<Object[]>) getCurrentSession().createQuery(
                "select e.apellido, d.dnombre from Empleados e, Departamentos d where e.departamentos.deptNo = d.deptNo and d.deptNo= :deptNo" )
                .setParameter("deptNo", depNo)
                .list();
        return empleados;
    }

    @Override
    public Empleados getEmpleadoMaxSalario() {
        //from Empleados order by salario DESC"
        //q.setFirstResult(start);
       Empleados empleado= (Empleados) getCurrentSession().createCriteria(Empleados.class)
        .addOrder(Order.desc("salario"))
        .setMaxResults(1)
         .uniqueResult();
        return empleado;
    }

    @Override
    public List<Empleados> getEmpleados() {
        //List<Empleados> empleados = (List<Empleados>) getCurrentSession().createQuery("from Empleados").list();
         List<Empleados> empleados= (List<Empleados>) getCurrentSession().createCriteria(Empleados.class).list();        
        return empleados;

    }

    @Override
    public Empleados getEmpleado(short empNo) {
        //Empleados emp = (Empleados) getCurrentSession().get(Empleados.class, empNo);
        Empleados emp= (Empleados) getCurrentSession().createQuery("from Empleados where empNo = :empNo")
                .setParameter("empNo", empNo)
                .uniqueResult();        
         
        return emp;

    }
    
    
    @Override
    public Empleados loadEmpleado(short empNo) {
        Empleados emp = (Empleados) getCurrentSession().load(Empleados.class, empNo);
        return emp;

    }

    @Override
    public void updateEmpleado(Empleados empleado) {
        getCurrentSession().update(empleado);
    }

    @Override
    public void deleteEmpelado(Empleados empleado) {
        getCurrentSession().delete(empleado);
    }

    @Override
    public void addEmpelado(Empleados empleado) {
        getCurrentSession().save(empleado);
    }

    @Override
    public Session openCurrentSession() {
        currentSession = Utilidades.getSessionFactory().openSession();
        return currentSession;
    }

    @Override
    public Session openCurrentSessionwithTransaction() {
        currentSession = Utilidades.getSessionFactory().openSession();
        currentTransaction = currentSession.beginTransaction();
        return currentSession;
    }

    @Override
    public void closeCurrentSession() {
        currentSession.close();
    }

    @Override
    public void closeCurrentSessionwithTransaction() {
        currentTransaction.commit();
        currentSession.close();
    }

    @Override
    public Session getCurrentSession() {
        return currentSession;
    }

}
