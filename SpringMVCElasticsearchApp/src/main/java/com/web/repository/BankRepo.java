package com.web.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.web.model.Bank;

public interface BankRepo extends ElasticsearchRepository<Bank, String> {

}
