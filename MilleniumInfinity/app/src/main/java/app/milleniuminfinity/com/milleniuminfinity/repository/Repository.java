package app.milleniuminfinity.com.milleniuminfinity.repository;

import java.util.Set;

/**
 * Created by 208023429 on 4/21/2016.
 */
public interface Repository <Entity, Identity> {

    Entity findById(Identity id);
    Entity save(Entity entity) throws Exception;
    Entity update(Entity entity) throws Exception;
    Entity delete (Entity entity) throws Exception;

    Set<Entity> findAll() throws Exception;
}
