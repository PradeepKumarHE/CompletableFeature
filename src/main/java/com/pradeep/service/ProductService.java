package com.pradeep.service;

import com.pradeep.entity.Product;
import com.pradeep.entity.User;
import com.pradeep.repository.ProductRepository;
import com.pradeep.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    Object target;
    Logger logger = LoggerFactory.getLogger(ProductService.class);

    @Async
    public CompletableFuture<List<Product>> saveProducts(List<Product> products) throws Exception {
        long start = System.currentTimeMillis();

        logger.info("saving list of users of size {}", products.size(), "" + Thread.currentThread().getName());
        products = productRepository.saveAll(products);
        long end = System.currentTimeMillis();
        logger.info("Total time {}", (end - start));
        return CompletableFuture.completedFuture(products);
    }
    @Async
    public CompletableFuture<List<Product>> findAllUsers(){
        logger.info("get list of user by "+Thread.currentThread().getName());
        List<Product> users=productRepository.findAll();
        return CompletableFuture.completedFuture(users);
    }
}