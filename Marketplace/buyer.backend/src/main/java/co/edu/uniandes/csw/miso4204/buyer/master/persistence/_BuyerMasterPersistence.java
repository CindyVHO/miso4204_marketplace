/* ========================================================================
 * Copyright 2014 miso4204
 *
 * Licensed under the MIT, The MIT License (MIT)
 * Copyright (c) 2014 miso4204

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

package co.edu.uniandes.csw.miso4204.buyer.master.persistence;
import co.edu.uniandes.csw.miso4204.creditcard.logic.dto.CreditCardDTO;
import co.edu.uniandes.csw.miso4204.buyer.master.persistence.entity.BuyercreditCardEntity;
import co.edu.uniandes.csw.miso4204.creditcard.persistence.converter.CreditCardConverter;
import co.edu.uniandes.csw.miso4204.address.logic.dto.AddressDTO;
import co.edu.uniandes.csw.miso4204.buyer.master.persistence.entity.BuyeraddressEntity;
import co.edu.uniandes.csw.miso4204.address.persistence.converter.AddressConverter;
import co.edu.uniandes.csw.miso4204.buyer.logic.dto.BuyerDTO;
import co.edu.uniandes.csw.miso4204.buyer.master.logic.dto.BuyerMasterDTO;
import co.edu.uniandes.csw.miso4204.buyer.persistence.BuyerPersistence;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class _BuyerMasterPersistence{

    protected EntityManager entityManager;
    
    protected BuyerPersistence buyerPersistence;  

    public BuyerMasterDTO getBuyer(Long buyerId) {
        BuyerMasterDTO buyerMasterDTO = new BuyerMasterDTO();
        BuyerDTO buyer = buyerPersistence.getBuyer(buyerId);
        buyerMasterDTO.setBuyerEntity(buyer);
        buyerMasterDTO.setListcreditCard(getBuyercreditCardEntityList(buyerId));
        buyerMasterDTO.setListaddress(getBuyeraddressEntityList(buyerId));
        return buyerMasterDTO;
    }

    public BuyercreditCardEntity createBuyercreditCardEntity(BuyercreditCardEntity entity) {
        entityManager.getTransaction().begin();
		entityManager.persist(entity);
		entityManager.getTransaction().commit();
        return entity;
    }

   public void deleteBuyercreditCardEntity(Long buyerId, Long creditCardId) {
		entityManager.getTransaction().begin();
        Query q = entityManager.createNamedQuery("BuyercreditCardEntity.deleteBuyercreditCardEntity");
        q.setParameter("buyerId", buyerId);
        q.setParameter("creditCardId", creditCardId);
        q.executeUpdate();
		entityManager.getTransaction().commit();
    }

   public List<CreditCardDTO> getBuyercreditCardEntityList(Long buyerId) {
		entityManager.getTransaction().begin();
		ArrayList<CreditCardDTO> resp = new ArrayList<CreditCardDTO>();
        Query q = entityManager.createNamedQuery("BuyercreditCardEntity.getByMasterId");
        q.setParameter("buyerId",buyerId);
        List<BuyercreditCardEntity> qResult =  q.getResultList();
        for (BuyercreditCardEntity entity : qResult) { 
            if(entity.getCreditCardIdEntity()==null){
                entityManager.refresh(entity);
            }
            resp.add(CreditCardConverter.entity2PersistenceDTO(entity.getCreditCardIdEntity()));
        }
        entityManager.getTransaction().commit();
        return resp;
      
    }
    public BuyeraddressEntity createBuyeraddressEntity(BuyeraddressEntity entity) {
        entityManager.getTransaction().begin();
		entityManager.persist(entity);
		entityManager.getTransaction().commit();
        return entity;
    }

   public void deleteBuyeraddressEntity(Long buyerId, Long addressId) {
		entityManager.getTransaction().begin();
        Query q = entityManager.createNamedQuery("BuyeraddressEntity.deleteBuyeraddressEntity");
        q.setParameter("buyerId", buyerId);
        q.setParameter("addressId", addressId);
        q.executeUpdate();
		entityManager.getTransaction().commit();
    }

   public List<AddressDTO> getBuyeraddressEntityList(Long buyerId) {
		entityManager.getTransaction().begin();
		ArrayList<AddressDTO> resp = new ArrayList<AddressDTO>();
        Query q = entityManager.createNamedQuery("BuyeraddressEntity.getByMasterId");
        q.setParameter("buyerId",buyerId);
        List<BuyeraddressEntity> qResult =  q.getResultList();
        for (BuyeraddressEntity entity : qResult) { 
            if(entity.getAddressIdEntity()==null){
                entityManager.refresh(entity);
            }
            resp.add(AddressConverter.entity2PersistenceDTO(entity.getAddressIdEntity()));
        }
        entityManager.getTransaction().commit();
        return resp;
      
    }
 
}