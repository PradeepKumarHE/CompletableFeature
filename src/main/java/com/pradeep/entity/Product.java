package com.pradeep.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Entity
@Table(name = "PRODUCT_TBL")
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue
    private Long Id;
    private Long productId;
    private Long alert_Id;
    private String k;
    private String description;
    private String classification;
    private String event;
    private String productDefect;
    private String drugSlashProduct;
    private String identifiableRef;
    private String url;
    private Date publishedDate;
    private String source_type;
    private String language;
    private String country;
    private Integer favorite;
    private String negative;
    private String source_name;
    private String source_url;
    private String parent_url;
    private Long parentId;
    private Integer children;
    private Integer direct_rea;
    private Integer cumulative;
    private String domain_n;
    private String tags;
    private Integer score;
    private String alert_name;
}
