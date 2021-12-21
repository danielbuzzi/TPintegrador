/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import logica.Venta;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import logica.Empleado;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author daniel
 */
public class EmpleadoJpaController implements Serializable {

    public EmpleadoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
            public EmpleadoJpaController() {
        emf = Persistence.createEntityManagerFactory("TP_IntegradorFinal_BuzziPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Empleado empleado) {
        if (empleado.getListaVentas() == null) {
            empleado.setListaVentas(new ArrayList<Venta>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Venta> attachedListaVentas = new ArrayList<Venta>();
            for (Venta listaVentasVentaToAttach : empleado.getListaVentas()) {
                listaVentasVentaToAttach = em.getReference(listaVentasVentaToAttach.getClass(), listaVentasVentaToAttach.getNum_venta());
                attachedListaVentas.add(listaVentasVentaToAttach);
            }
            empleado.setListaVentas(attachedListaVentas);
            em.persist(empleado);
            for (Venta listaVentasVenta : empleado.getListaVentas()) {
                Empleado oldUnEmpleadoOfListaVentasVenta = listaVentasVenta.getUnEmpleado();
                listaVentasVenta.setUnEmpleado(empleado);
                listaVentasVenta = em.merge(listaVentasVenta);
                if (oldUnEmpleadoOfListaVentasVenta != null) {
                    oldUnEmpleadoOfListaVentasVenta.getListaVentas().remove(listaVentasVenta);
                    oldUnEmpleadoOfListaVentasVenta = em.merge(oldUnEmpleadoOfListaVentasVenta);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Empleado empleado) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Empleado persistentEmpleado = em.find(Empleado.class, empleado.getCodigo_empleado());
            List<Venta> listaVentasOld = persistentEmpleado.getListaVentas();
            List<Venta> listaVentasNew = empleado.getListaVentas();
            List<Venta> attachedListaVentasNew = new ArrayList<Venta>();
            for (Venta listaVentasNewVentaToAttach : listaVentasNew) {
                listaVentasNewVentaToAttach = em.getReference(listaVentasNewVentaToAttach.getClass(), listaVentasNewVentaToAttach.getNum_venta());
                attachedListaVentasNew.add(listaVentasNewVentaToAttach);
            }
            listaVentasNew = attachedListaVentasNew;
            empleado.setListaVentas(listaVentasNew);
            empleado = em.merge(empleado);
            for (Venta listaVentasOldVenta : listaVentasOld) {
                if (!listaVentasNew.contains(listaVentasOldVenta)) {
                    listaVentasOldVenta.setUnEmpleado(null);
                    listaVentasOldVenta = em.merge(listaVentasOldVenta);
                }
            }
            for (Venta listaVentasNewVenta : listaVentasNew) {
                if (!listaVentasOld.contains(listaVentasNewVenta)) {
                    Empleado oldUnEmpleadoOfListaVentasNewVenta = listaVentasNewVenta.getUnEmpleado();
                    listaVentasNewVenta.setUnEmpleado(empleado);
                    listaVentasNewVenta = em.merge(listaVentasNewVenta);
                    if (oldUnEmpleadoOfListaVentasNewVenta != null && !oldUnEmpleadoOfListaVentasNewVenta.equals(empleado)) {
                        oldUnEmpleadoOfListaVentasNewVenta.getListaVentas().remove(listaVentasNewVenta);
                        oldUnEmpleadoOfListaVentasNewVenta = em.merge(oldUnEmpleadoOfListaVentasNewVenta);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                long id = empleado.getCodigo_empleado();
                if (findEmpleado(id) == null) {
                    throw new NonexistentEntityException("The empleado with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Empleado empleado;
            try {
                empleado = em.getReference(Empleado.class, id);
                empleado.getCodigo_empleado();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The empleado with id " + id + " no longer exists.", enfe);
            }
            List<Venta> listaVentas = empleado.getListaVentas();
            for (Venta listaVentasVenta : listaVentas) {
                listaVentasVenta.setUnEmpleado(null);
                listaVentasVenta = em.merge(listaVentasVenta);
            }
            em.remove(empleado);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Empleado> findEmpleadoEntities() {
        return findEmpleadoEntities(true, -1, -1);
    }

    public List<Empleado> findEmpleadoEntities(int maxResults, int firstResult) {
        return findEmpleadoEntities(false, maxResults, firstResult);
    }

    private List<Empleado> findEmpleadoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Empleado.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Empleado findEmpleado(long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Empleado.class, id);
        } finally {
            em.close();
        }
    }

    public int getEmpleadoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Empleado> rt = cq.from(Empleado.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
