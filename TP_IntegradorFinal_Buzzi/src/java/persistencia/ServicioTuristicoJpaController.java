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
import logica.PaqueteTuristico;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import logica.ServicioTuristico;
import logica.Venta;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author daniel
 */
public class ServicioTuristicoJpaController implements Serializable {

    public ServicioTuristicoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
            public ServicioTuristicoJpaController() {
        emf = Persistence.createEntityManagerFactory("TP_IntegradorFinal_BuzziPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ServicioTuristico servicioTuristico) {
        if (servicioTuristico.getListaPaquete() == null) {
            servicioTuristico.setListaPaquete(new ArrayList<PaqueteTuristico>());
        }
        if (servicioTuristico.getListaVentas() == null) {
            servicioTuristico.setListaVentas(new ArrayList<Venta>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<PaqueteTuristico> attachedListaPaquete = new ArrayList<PaqueteTuristico>();
            for (PaqueteTuristico listaPaquetePaqueteTuristicoToAttach : servicioTuristico.getListaPaquete()) {
                listaPaquetePaqueteTuristicoToAttach = em.getReference(listaPaquetePaqueteTuristicoToAttach.getClass(), listaPaquetePaqueteTuristicoToAttach.getCodigo_paquete());
                attachedListaPaquete.add(listaPaquetePaqueteTuristicoToAttach);
            }
            servicioTuristico.setListaPaquete(attachedListaPaquete);
            List<Venta> attachedListaVentas = new ArrayList<Venta>();
            for (Venta listaVentasVentaToAttach : servicioTuristico.getListaVentas()) {
                listaVentasVentaToAttach = em.getReference(listaVentasVentaToAttach.getClass(), listaVentasVentaToAttach.getNum_venta());
                attachedListaVentas.add(listaVentasVentaToAttach);
            }
            servicioTuristico.setListaVentas(attachedListaVentas);
            em.persist(servicioTuristico);
            for (PaqueteTuristico listaPaquetePaqueteTuristico : servicioTuristico.getListaPaquete()) {
                listaPaquetePaqueteTuristico.getListaServicio().add(servicioTuristico);
                listaPaquetePaqueteTuristico = em.merge(listaPaquetePaqueteTuristico);
            }
            for (Venta listaVentasVenta : servicioTuristico.getListaVentas()) {
                ServicioTuristico oldUnServicioOfListaVentasVenta = listaVentasVenta.getUnServicio();
                listaVentasVenta.setUnServicio(servicioTuristico);
                listaVentasVenta = em.merge(listaVentasVenta);
                if (oldUnServicioOfListaVentasVenta != null) {
                    oldUnServicioOfListaVentasVenta.getListaVentas().remove(listaVentasVenta);
                    oldUnServicioOfListaVentasVenta = em.merge(oldUnServicioOfListaVentasVenta);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ServicioTuristico servicioTuristico) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ServicioTuristico persistentServicioTuristico = em.find(ServicioTuristico.class, servicioTuristico.getCodigo_servicio());
            List<PaqueteTuristico> listaPaqueteOld = persistentServicioTuristico.getListaPaquete();
            List<PaqueteTuristico> listaPaqueteNew = servicioTuristico.getListaPaquete();
            List<Venta> listaVentasOld = persistentServicioTuristico.getListaVentas();
            List<Venta> listaVentasNew = servicioTuristico.getListaVentas();
            List<PaqueteTuristico> attachedListaPaqueteNew = new ArrayList<PaqueteTuristico>();
            for (PaqueteTuristico listaPaqueteNewPaqueteTuristicoToAttach : listaPaqueteNew) {
                listaPaqueteNewPaqueteTuristicoToAttach = em.getReference(listaPaqueteNewPaqueteTuristicoToAttach.getClass(), listaPaqueteNewPaqueteTuristicoToAttach.getCodigo_paquete());
                attachedListaPaqueteNew.add(listaPaqueteNewPaqueteTuristicoToAttach);
            }
            listaPaqueteNew = attachedListaPaqueteNew;
            servicioTuristico.setListaPaquete(listaPaqueteNew);
            List<Venta> attachedListaVentasNew = new ArrayList<Venta>();
            for (Venta listaVentasNewVentaToAttach : listaVentasNew) {
                listaVentasNewVentaToAttach = em.getReference(listaVentasNewVentaToAttach.getClass(), listaVentasNewVentaToAttach.getNum_venta());
                attachedListaVentasNew.add(listaVentasNewVentaToAttach);
            }
            listaVentasNew = attachedListaVentasNew;
            servicioTuristico.setListaVentas(listaVentasNew);
            servicioTuristico = em.merge(servicioTuristico);
            for (PaqueteTuristico listaPaqueteOldPaqueteTuristico : listaPaqueteOld) {
                if (!listaPaqueteNew.contains(listaPaqueteOldPaqueteTuristico)) {
                    listaPaqueteOldPaqueteTuristico.getListaServicio().remove(servicioTuristico);
                    listaPaqueteOldPaqueteTuristico = em.merge(listaPaqueteOldPaqueteTuristico);
                }
            }
            for (PaqueteTuristico listaPaqueteNewPaqueteTuristico : listaPaqueteNew) {
                if (!listaPaqueteOld.contains(listaPaqueteNewPaqueteTuristico)) {
                    listaPaqueteNewPaqueteTuristico.getListaServicio().add(servicioTuristico);
                    listaPaqueteNewPaqueteTuristico = em.merge(listaPaqueteNewPaqueteTuristico);
                }
            }
            for (Venta listaVentasOldVenta : listaVentasOld) {
                if (!listaVentasNew.contains(listaVentasOldVenta)) {
                    listaVentasOldVenta.setUnServicio(null);
                    listaVentasOldVenta = em.merge(listaVentasOldVenta);
                }
            }
            for (Venta listaVentasNewVenta : listaVentasNew) {
                if (!listaVentasOld.contains(listaVentasNewVenta)) {
                    ServicioTuristico oldUnServicioOfListaVentasNewVenta = listaVentasNewVenta.getUnServicio();
                    listaVentasNewVenta.setUnServicio(servicioTuristico);
                    listaVentasNewVenta = em.merge(listaVentasNewVenta);
                    if (oldUnServicioOfListaVentasNewVenta != null && !oldUnServicioOfListaVentasNewVenta.equals(servicioTuristico)) {
                        oldUnServicioOfListaVentasNewVenta.getListaVentas().remove(listaVentasNewVenta);
                        oldUnServicioOfListaVentasNewVenta = em.merge(oldUnServicioOfListaVentasNewVenta);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                long id = servicioTuristico.getCodigo_servicio();
                if (findServicioTuristico(id) == null) {
                    throw new NonexistentEntityException("The servicioTuristico with id " + id + " no longer exists.");
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
            ServicioTuristico servicioTuristico;
            try {
                servicioTuristico = em.getReference(ServicioTuristico.class, id);
                servicioTuristico.getCodigo_servicio();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The servicioTuristico with id " + id + " no longer exists.", enfe);
            }
            List<PaqueteTuristico> listaPaquete = servicioTuristico.getListaPaquete();
            for (PaqueteTuristico listaPaquetePaqueteTuristico : listaPaquete) {
                listaPaquetePaqueteTuristico.getListaServicio().remove(servicioTuristico);
                listaPaquetePaqueteTuristico = em.merge(listaPaquetePaqueteTuristico);
            }
            List<Venta> listaVentas = servicioTuristico.getListaVentas();
            for (Venta listaVentasVenta : listaVentas) {
                listaVentasVenta.setUnServicio(null);
                listaVentasVenta = em.merge(listaVentasVenta);
            }
            em.remove(servicioTuristico);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ServicioTuristico> findServicioTuristicoEntities() {
        return findServicioTuristicoEntities(true, -1, -1);
    }

    public List<ServicioTuristico> findServicioTuristicoEntities(int maxResults, int firstResult) {
        return findServicioTuristicoEntities(false, maxResults, firstResult);
    }

    private List<ServicioTuristico> findServicioTuristicoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ServicioTuristico.class));
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

    public ServicioTuristico findServicioTuristico(long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ServicioTuristico.class, id);
        } finally {
            em.close();
        }
    }

    public int getServicioTuristicoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ServicioTuristico> rt = cq.from(ServicioTuristico.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
