package com.erp.config;


import com.erp.domain.RequestMessage;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * 接口：根据这个接口对mongodb中的数据做增删查改
 */
public interface LoggerRepository extends MongoRepository<RequestMessage,String> {
}
