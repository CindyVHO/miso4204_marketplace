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

package co.edu.uniandes.csw.miso4204.paymentmode.logic.ejb;

import java.util.List;

import co.edu.uniandes.csw.miso4204.paymentmode.logic.dto.PaymentModeDTO;
import co.edu.uniandes.csw.miso4204.paymentmode.logic.dto.PaymentModePageDTO;
import co.edu.uniandes.csw.miso4204.paymentmode.persistence.PaymentModePersistence;

public abstract class _PaymentModeLogicService {

	protected PaymentModePersistence persistance;

	public PaymentModeDTO createPaymentMode(PaymentModeDTO paymentMode){
		return persistance.createPaymentMode( paymentMode); 
    }

	public List<PaymentModeDTO> getPaymentModes(){
		return persistance.getPaymentModes(); 
	}

	public PaymentModePageDTO getPaymentModes(Integer page, Integer maxRecords){
		return persistance.getPaymentModes(page, maxRecords); 
	}

	public PaymentModeDTO getPaymentMode(Long id){
		return persistance.getPaymentMode(id); 
	}

	public void deletePaymentMode(Long id){
	    persistance.deletePaymentMode(id); 
	}

	public void updatePaymentMode(PaymentModeDTO paymentMode){
	    persistance.updatePaymentMode(paymentMode); 
	}	
}