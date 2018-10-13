package com.motashishu.barkeep.dao;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.motashishu.barkeep.model.LiquorCabinet;

@Repository
public interface LiquorCabinetRepository extends ReactiveMongoRepository<LiquorCabinet, ObjectId> {}
