package com.example.demo.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ContractDTO;
import com.example.demo.dto.ContractWrapperResponseDTO;

import lombok.extern.java.Log;

@RestController
@Log
public class ContractsController {

	@GetMapping("/clients/{clientId}/contracts")
	public ContractWrapperResponseDTO getContractsByClient(@PathVariable String clientId) {
		log.info("[ContractsController][getContractsByClient][START]");
	
		List<ContractDTO> contractsList = new ArrayList<>();
		ContractWrapperResponseDTO wrapperResponse = ContractWrapperResponseDTO.builder().contractsList(contractsList).build();
		
		ContractDTO contract1 = ContractDTO.builder()
				.clientId(clientId)
				.contractId("20200618001")
				.creationDate(LocalDate.of(2020, 06, 18))
				.productId("XXX")
				.description("Product XXX")
				.build();
		
		ContractDTO contract2 = ContractDTO.builder()
				.clientId(clientId)
				.contractId("20210110001")
				.creationDate(LocalDate.of(2021, 01, 11))
				.productId("YYY")
				.description("Product YYY")
				.build();		
		
		wrapperResponse.getContractsList().add(contract1);
		wrapperResponse.getContractsList().add(contract2);
		
		try {
		    TimeUnit.SECONDS.sleep(10);
		} catch (InterruptedException ie) {
		    Thread.currentThread().interrupt();
		}			
		
		log.info("[ContractsController][getContractsByClient][END]");
		return wrapperResponse;
	}
	
}
