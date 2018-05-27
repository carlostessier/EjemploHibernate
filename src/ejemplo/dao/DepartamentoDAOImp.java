package ejemplo.dao;

import java.util.ArrayList;
import java.util.List;

import ejemplo.jpa.Departamentos;
import ejemplo.jpa.Empleados;
import ejemplo.utilidades.Utilidades;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DepartamentoDAOImp implements DepartamentoDAO {

    private Session currentSession;
    private Transaction currentTransaction;

    @Override
    public ArrayList<Departamentos> getDepartamentoPorEmp(int empNo) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Departamentos> getDepartamentos() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Departamentos getDepartamento(int empNo) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void updateDepartamento(Departamentos departamento) {
        getCurrentSession().update(departamento);

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

    @Override
    public Departamentos getDepartamento(short depNo) {
        Departamentos dep = (Departamentos) getCurrentSession().get(Departamentos.class, depNo);
        return dep;   
    }

    @Override
    public void persist(Departamentos departamento) {
        getCurrentSession().persist(departamento);
    }

    @Override
    public void deleteDepartamento(Departamentos departamento) {
        getCurrentSession().delete(departamento);
    }

    @Override
    public void addDepartamento(Departamentos departamento) {
        getCurrentSession().save(departamento);
    }

}
