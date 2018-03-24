package com.example.demo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "camp")
public interface CampaignRepo extends CrudRepository<Campaign,Long>{
}
