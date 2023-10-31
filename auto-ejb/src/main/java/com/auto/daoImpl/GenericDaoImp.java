package com.auto.daoImpl;

import com.auto.dao.IGenericoDao;
import com.excepciones.registos.RegistroNoEliminado;
import com.excepciones.registos.RegistroNoGuardado;
import com.excepciones.registos.RegistroNoLocalizado;
import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Query;

/**
 * Class GenericDao.
 *
 * @param <T> the generic type
 * @param <PK> the generic id type
 */
@SuppressWarnings("unchecked")
public class GenericDaoImp<T, PK extends Serializable> implements
        IGenericoDao<T, PK> {


    @PersistenceContext(unitName = "autoDataSource")
    protected EntityManager em;

    private final Class<T> type;

    /**
     * Instancia un nuevo generic dao.
     *
     * @param type the type
     */
    public GenericDaoImp(final Class<T> type) {
        this.type = type;
    }

    @Override
    public void crear(final T o) throws RegistroNoGuardado {
        try {
            em.persist(o);
        } catch (Exception ex) {
            Logger.getLogger(GenericDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public T recuperar(final PK id) throws RegistroNoLocalizado {

        final T entidad = em.find(type, id);

        if (entidad == null) {
            final StringBuffer msg = new StringBuffer();
            msg.append(type.getSimpleName());
            msg.append('[');
            msg.append(id.toString());
            msg.append("] no encontrada.");
            throw new RegistroNoLocalizado(msg.toString());
        }

        return entidad;
    }

    @Override
    public void actualizar(final T o) throws RegistroNoGuardado {

        try {
            em.merge(o);
        } catch (Exception ex) {
            Logger.getLogger(GenericDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   
    @Override
    public void eliminar(final T o) throws RegistroNoEliminado {

        try {
            em.merge(o);
            em.remove(o);
        } catch (Exception ex) {
            Logger.getLogger(GenericDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   

    @Override
    public Object selectNamedQuerySingle(final String namedQuery,
            final Map<String, Object> parameters) {
        final Query query = em.createNativeQuery(namedQuery);
        if (parameters != null) {
            int cont = 1;
            for (final String key : parameters.keySet()) {
                query.setParameter(cont++, parameters.get(key));
            }
        }
        return (Object) query.getSingleResult();
    }
    
     @Override
    public List<Object> selectNamedQueryResultList(final String namedQuery,
            final Map<String, Object> parameters) {
        final Query query = em.createNativeQuery(namedQuery);
        if (parameters != null) {
            int cont = 1;
            for (final String key : parameters.keySet()) {
                query.setParameter(cont++, parameters.get(key));
            }
        }
        return query.getResultList();
    }



}
