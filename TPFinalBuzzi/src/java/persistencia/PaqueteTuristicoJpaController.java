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
import logica.ServicioTuristico;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import logica.PaqueteTuristico;
import logica.Venta;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author daniel
 */
public class PaqueteTuristicoJpaController implements Serializable {

    public PaqueteTuristicoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
            public PaqueteTuristicoJpaController() {
        emf = Persistence.createEntityManagerFactory("TP_IntegradorFinal_BuzziPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PaqueteTuristico paqueteTuristico) {
        if (paqueteTuristico.getListaServicio() == null) {
            paqueteTuristico.setListaServicio(new ArrayList<ServicioTuristico>());
        }
        if (paqueteTuristico.getListaVentas() == null) {
            paqueteTuristico.setListaVentas(new ArrayList<Venta>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<ServicioTuristico> attachedListaServicio = new ArrayList<ServicioTuristico>();
            for (ServicioTuristico listaServicioServicioTuristicoToAttach : paqueteTuristico.getListaServicio()) {
                listaServicioServicioTuristicoToAttach = em.getReference(listaServicioServicioTuristicoToAttach.getClass(), listaServicioServicioTuristicoToAttach.getCodigo_servicio());
                attachedListaServicio.add(listaServicioServicioTuristicoToAttach);
            }
            paqueteTuristico.setListaServicio(attachedListaServicio);
            List<Venta> attachedListaVentas = new ArrayList<Venta>();
            for (Venta listaVentasVentaToAttach : paqueteTuristico.getListaVentas()) {
                listaVentasVentaToAttach = em.getReference(listaVentasVentaToAttach.getClass(), listaVentasVentaToAttach.getNum_venta());
                attachedListaVentas.add(listaVentasVentaToAttach);
            }
            paqueteTuristico.setListaVentas(attachedListaVentas);
            em.persist(paqueteTuristico);
            for (ServicioTuristico listaServicioServicioTuristico : paqueteTuristico.getListaServicio()) {
                listaServicioServicioTuristico.getListaPaquete().add(paqueteTuristico);
                listaServicioServicioTuristico = em.merge(listaServicioServicioTuristico);
            }
            for (Venta listaVentasVenta : paqueteTuristico.getListaVentas()) {
                PaqueteTuristico oldUnPaqueteOfListaVentasVenta = listaVentasVenta.getUnPaquete();
                listaVentasVenta.setUnPaquete(paqueteTuristico);
                listaVentasVenta = em.merge(listaVentasVenta);
                if (oldUnPaqueteOfListaVentasVenta != null) {
                    oldUnPaqueteOfListaVentasVenta.getListaVentas().remove(listaVentasVenta);
                    oldUnPaqueteOfListaVentasVenta = em.merge(oldUnPaqueteOfListaVentasVenta);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PaqueteTuristico paqueteTuristico) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PaqueteTuristico persistentPaqueteTuristico = em.find(PaqueteTuristico.class, paqueteTuristico.getCodigo_paquete());
            List<ServicioTuristico> listaServicioOld = persistentPaqueteTuristico.getListaServicio();
            List<ServicioTuristico> listaServicioNew = paqueteTuristico.getListaServicio();
            List<Venta> listaVentasOld = persistentPaqueteTuristico.getListaVentas();
            List<Venta> listaVentasNew = paqueteTuristico.getListaVentas();
            List<ServicioTuristico> attachedListaServicioNew = new ArrayList<ServicioTuristico>();
            for (ServicioTuristico listaServicioNewServicioTuristicoToAttach : listaServicioNew) {
                listaServicioNewServicioTuristicoToAttach = em.getReference(listaServicioNewServicioTuristicoToAttach.getClass(), listaServicioNewServicioTuristicoToAttach.getCodigo_servicio());
                attachedListaServicioNew.add(listaServicioNewServicioTuristicoToAttach);
            }
            listaServicioNew = attachedListaServicioNew;
            paqueteTuristico.setListaServicio(listaServicioNew);
            List<Venta> attachedListaVentasNew = new ArrayList<Venta>();
            for (Venta listaVentasNewVentaToAttach : listaVentasNew) {
                listaVentasNewVentaToAttach = em.getReference(listaVentasNewVentaToAttach.getClass(), listaVentasNewVentaToAttach.getNum_venta());
                attachedListaVentasNew.add(listaVentasNewVentaToAttach);
            }
            listaVentasNew = attachedListaVentasNew;
            paqueteTuristico.setListaVentas(listaVentasNew);
            paqueteTuristico = em.merge(paqueteTuristico);
            for (ServicioTuristico listaServicioOldServicioTuristico : listaServicioOld) {
                if (!listaServicioNew.contains(listaServicioOldServicioTuristico)) {
                    listaServicioOldServicioTuristico.getListaPaquete().remove(paqueteTuristico);
                    listaServicioOldServicioTuristico = em.merge(listaServicioOldServicioTuristico);
                }
            }
            for (ServicioTuristico listaServicioNewServicioTuristico : listaServicioNew) {
                if (!listaServicioOld.contains(listaServicioNewServicioTuristico)) {
                    listaServicioNewServicioTuristico.getListaPaquete().add(paqueteTuristico);
                    listaServicioNewServicioTuristico = em.merge(listaServicioNewServicioTuristico);
                }
            }
            for (Venta listaVentasOldVenta : listaVentasOld) {
                if (!listaVentasNew.contains(listaVentasOldVenta)) {
                    listaVentasOldVenta.setUnPaquete(null);
                    listaVentasOldVenta = em.merge(listaVentasOldVenta);
                }
            }
            for (Venta listaVentasNewVenta : listaVentasNew) {
                if (!listaVentasOld.contains(listaVentasNewVenta)) {
                    PaqueteTuristico oldUnPaqueteOfListaVentasNewVenta = listaVentasNewVenta.getUnPaquete();
                    listaVentasNewVenta.setUnPaquete(paqueteTuristico);
                    listaVentasNewVenta = em.merge(listaVentasNewVenta);
                    if (oldUnPaqueteOfListaVentasNewVenta != null && !oldUnPaqueteOfListaVentasNewVenta.equals(paqueteTuristico)) {
                        oldUnPaqueteOfListaVentasNewVenta.getListaVentas().remove(listaVentasNewVenta);
                        oldUnPaqueteOfListaVentasNewVenta = em.merge(oldUnPaqueteOfListaVentasNewVenta);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                long id = paqueteTuristico.getCodigo_paquete();
                if (findPaqueteTuristico(id) == null) {
                    throw new NonexistentEntityException("The paqueteTuristico with id " + id + " no longer exists.");
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
            PaqueteTuristico paqueteTuristico;
            try {
                paqueteTuristico = em.getReference(PaqueteTuristico.class, id);
                paqueteTuristico.getCodigo_paquete();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The paqueteTuristico with id " + id + " no longer exists.", enfe);
            }
            List<ServicioTuristico> listaServicio = paqueteTuristico.getListaServicio();
            for (ServicioTuristico listaServicioServicioTuristico : listaServicio) {
                listaServicioServicioTuristico.getListaPaquete().remove(paqueteTuristico);
                listaServicioServicioTuristico = em.merge(listaServicioServicioTuristico);
            }
            List<Venta> listaVentas = paqueteTuristico.getListaVentas();
            for (Venta listaVentasVenta : listaVentas) {
                listaVentasVenta.setUnPaquete(null);
                listaVentasVenta = em.merge(listaVentasVenta);
            }
            em.remove(paqueteTuristico);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PaqueteTuristico> findPaqueteTuristicoEntities() {
        return findPaqueteTuristicoEntities(true, -1, -1);
    }

    public List<PaqueteTuristico> findPaqueteTuristicoEntities(int maxResults, int firstResult) {
        return findPaqueteTuristicoEntities(false, maxResults, firstResult);
    }

    private List<PaqueteTuristico> findPaqueteTuristicoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PaqueteTuristico.class));
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

    public PaqueteTuristico findPaqueteTuristico(long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PaqueteTuristico.class, id);
        } finally {
            em.close();
        }
    }

    public int getPaqueteTuristicoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PaqueteTuristico> rt = cq.from(PaqueteTuristico.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
