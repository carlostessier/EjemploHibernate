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
import org.hibernate.Session;
import org.hibernate.Transaction;

public class EmpleadoDAOImp implements EmpleadoDAO {

    private Session currentSession;
    private Transaction currentTransaction;
    
    public void persist(Empleados empleado) { 
        getCurrentSession().persist(empleado);      
    }


    @Override
    public List<Object[]> getEmpleadoPorDep(short depNo) {
        List<Object[]> empleados = (List<Object[]>) getCurrentSession().createQuery("select e.apellido, d.dnombre from Empleados e, Departamentos d where e.departamentos.deptNo = d.deptNo and d.deptNo="+depNo).list();
        return empleados;
    }

    @Override
    public Empleados getEmpleadoMaxSalario() {
        Empleados empleado = new Empleados();

        return empleado;
    }

    @Override
    public List<Empleados> getEmpleados() {
        List<Empleados> empleados = (List<Empleados>) getCurrentSession().createQuery("from Empleados").list();
        return empleados;

    }

    @Override
    public Empleados getEmpleado(short depNo) {
        Empleados emp = (Empleados) getCurrentSession().get(Empleados.class, depNo);       
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
    
    public Session getCurrentSession() {
        return currentSession;
   }

 


}
