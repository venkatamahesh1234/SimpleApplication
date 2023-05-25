package com.web.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.web.model.Product;

public interface ProductRepo extends ElasticsearchRepository<Product, Integer> {

}
