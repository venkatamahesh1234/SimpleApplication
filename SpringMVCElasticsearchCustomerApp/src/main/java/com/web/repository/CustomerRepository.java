package com.web.repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.web.model.Customer;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.DeleteRequest;
import co.elastic.clients.elasticsearch.core.DeleteResponse;
import co.elastic.clients.elasticsearch.core.GetResponse;
import co.elastic.clients.elasticsearch.core.IndexResponse;
import co.elastic.clients.elasticsearch.core.SearchRequest;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.search.Hit;

@Repository
public class CustomerRepository {

	@Autowired
    private ElasticsearchClient elasticsearchClient;

   private final String indexName = "customers";


    public String createOrUpdateDocument(Customer customer) throws IOException {

        IndexResponse response = elasticsearchClient.index(i -> i
                .index("customers")
                .id(customer.getCustomerId())
                .document(customer)
        );
        if(response.result().name().equals("Created")){
            return new StringBuilder("Document has been successfully created.").toString();
        }else if(response.result().name().equals("Updated")){
            return new StringBuilder("Document has been successfully updated.").toString();
        }
        return new StringBuilder("Error while performing the operation.").toString();
    }

    public Customer getDocumentById(String customerId) throws IOException{
        Customer customer = null;
        GetResponse<Customer> response = elasticsearchClient.get(g -> g
                        .index("customers")
                        .id(customerId),
                Customer.class
        );

        if (response.found()) {
             customer = response.source();
            System.out.println("Customer name " + customer.getCustomerName());
        } else {
            System.out.println ("Customer not found");
        }

       return customer;
    }

    public String deleteDocumentById(String customerId) throws IOException {

        DeleteRequest request = DeleteRequest.of(d -> d.index("customers").id(customerId));

        DeleteResponse deleteResponse = elasticsearchClient.delete(request);
        if (Objects.nonNull(deleteResponse.result()) && !deleteResponse.result().name().equals("NotFound")) {
            return new StringBuilder("Customer with id " + deleteResponse.id() + " has been deleted.").toString();
        }
        System.out.println("Customer not found");
        return new StringBuilder("Customer with id " + deleteResponse.id()+" does not exist.").toString();

    }

    public  List<Customer> searchAllDocuments() throws IOException {

        SearchRequest searchRequest =  SearchRequest.of(s -> s.index("customers"));
        SearchResponse searchResponse =  elasticsearchClient.search(searchRequest, Customer.class);
        List<Hit> hits = searchResponse.hits().hits();
        List<Customer> customers = new ArrayList<>();
        for(Hit object : hits){

            System.out.print(((Customer) object.source()));
            customers.add((Customer) object.source());

        }
        return customers;
    }

}
