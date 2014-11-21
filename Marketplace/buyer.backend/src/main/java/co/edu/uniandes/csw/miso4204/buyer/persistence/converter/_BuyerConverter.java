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

package co.edu.uniandes.csw.miso4204.buyer.persistence.converter;

import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;


import co.edu.uniandes.csw.miso4204.buyer.logic.dto.BuyerDTO;
import co.edu.uniandes.csw.miso4204.buyer.persistence.entity.BuyerEntity;

public abstract class _BuyerConverter {

 
	private final static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");
	public static BuyerDTO entity2PersistenceDTO(BuyerEntity entity){
		if (entity != null) {
			BuyerDTO dto = new BuyerDTO();
					dto.setId(entity.getId());
					dto.setUsername(entity.getUsername());
					dto.setPassword(entity.getPassword());
					dto.setEmail(entity.getEmail());
					dto.setFirstName(entity.getFirstName());
					dto.setSecondName(entity.getSecondName());
					dto.setLastName(entity.getLastName());
 
			    if(entity.getBirthDate() != null){
					dto.setBirthDate(DATE_FORMAT.format(entity.getBirthDate()));
				}	
					dto.setGender(entity.getGender());
					dto.setName(entity.getName());
			return dto;
		}else{
			return null;
		}
	}
	
	public static BuyerEntity persistenceDTO2Entity(BuyerDTO dto){
		if(dto!=null){
			BuyerEntity entity=new BuyerEntity();
					entity.setId(dto.getId());
			
					entity.setUsername(dto.getUsername());
			
					entity.setPassword(dto.getPassword());
			
					entity.setEmail(dto.getEmail());
			
					entity.setFirstName(dto.getFirstName());
			
					entity.setSecondName(dto.getSecondName());
			
					entity.setLastName(dto.getLastName());
			
 
			      try{ 
			        if(dto.getBirthDate() != null){
						entity.setBirthDate(DATE_FORMAT.parse(dto.getBirthDate()));
					}
				  } catch (Exception ex) {
                        Logger.getLogger(_BuyerConverter.class.getName()).log(Level.SEVERE, null, ex);
                  }	
			
					entity.setGender(dto.getGender());
			
					entity.setName(dto.getName());
			
			return entity;
		}else {
			return null;
		}
	}
	
	public static List<BuyerDTO> entity2PersistenceDTOList(List<BuyerEntity> entities){
		List<BuyerDTO> dtos=new ArrayList<BuyerDTO>();
		for(BuyerEntity entity:entities){
			dtos.add(entity2PersistenceDTO(entity));
		}
		return dtos;
	}
	
	public static List<BuyerEntity> persistenceDTO2EntityList(List<BuyerDTO> dtos){
		List<BuyerEntity> entities=new ArrayList<BuyerEntity>();
		for(BuyerDTO dto:dtos){
			entities.add(persistenceDTO2Entity(dto));
		}
		return entities;
	}
}