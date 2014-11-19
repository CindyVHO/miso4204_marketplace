/* ========================================================================
 * Copyright 2014 
 *
 * Licensed under the MIT, The MIT License (MIT)
 * Copyright (c) 2014 

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
 * ========================================================================


Source generated by CrudMaker version 1.0.0.qualifier

*/

package co.edu.uniandes.csw.tenantcontrol.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import co.edu.uniandes.csw.tenantcontrol.logic.dto.TenantControlDTO;
import co.edu.uniandes.csw.tenantcontrol.logic.dto.TenantControlPageDTO;
import co.edu.uniandes.csw.tenantcontrol.persistence.converter.TenantControlConverter;
import co.edu.uniandes.csw.tenantcontrol.persistence.entity.TenantControlEntity;

public abstract class _TenantControlPersistence{

  	protected EntityManager entityManager;
	
	public TenantControlDTO createTenantControl(TenantControlDTO tenantControl) {
		TenantControlEntity entity=TenantControlConverter.persistenceDTO2Entity(tenantControl);
		entityManager.getTransaction().begin();
		entityManager.persist(entity);
		entityManager.getTransaction().commit();
		return TenantControlConverter.entity2PersistenceDTO(entity);
	}
	
	@SuppressWarnings("unchecked")
	public List<TenantControlDTO> getTenantControls() {
		entityManager.getTransaction().begin();
		Query q = entityManager.createQuery("select u from TenantControlEntity u");
		List<TenantControlDTO> result = TenantControlConverter.entity2PersistenceDTOList(q.getResultList());
		entityManager.getTransaction().commit();
		return result;
		
	}

	@SuppressWarnings("unchecked")
	public TenantControlPageDTO getTenantControls(Integer page, Integer maxRecords) {
		entityManager.getTransaction().begin();
		Query count = entityManager.createQuery("select count(u) from TenantControlEntity u");
		Long regCount = 0L;
		regCount = Long.parseLong(count.getSingleResult().toString());
		Query q = entityManager.createQuery("select u from TenantControlEntity u");
		if (page != null && maxRecords != null) {
		    q.setFirstResult((page-1)*maxRecords);
		    q.setMaxResults(maxRecords);
		}
		TenantControlPageDTO response = new TenantControlPageDTO();
		response.setTotalRecords(regCount);
		response.setRecords(TenantControlConverter.entity2PersistenceDTOList(q.getResultList()));
		entityManager.getTransaction().commit();
		return response;
	}

	public TenantControlDTO getTenantControl(Long id) {
		entityManager.getTransaction().begin();
		TenantControlDTO result = TenantControlConverter.entity2PersistenceDTO(entityManager.find(TenantControlEntity.class, id));
		entityManager.getTransaction().commit();
		return result;
	}

	public void deleteTenantControl(Long id) {
		entityManager.getTransaction().begin();
		TenantControlEntity entity=entityManager.find(TenantControlEntity.class, id);
		entityManager.remove(entity);
		entityManager.getTransaction().commit();
	}

	public void updateTenantControl(TenantControlDTO detail) {
		entityManager.getTransaction().begin();
		TenantControlEntity entity=entityManager.merge(TenantControlConverter.persistenceDTO2Entity(detail));
		TenantControlConverter.entity2PersistenceDTO(entity);
		entityManager.getTransaction().commit();
	}

}