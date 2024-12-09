package com.sajid.ecommerce.config;

import com.sajid.ecommerce.Entity.Product;
import com.sajid.ecommerce.Entity.ProductCategory;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        RepositoryRestConfigurer.super.configureRepositoryRestConfiguration(config, cors);

        HttpMethod[] theUnsupportedAction = {HttpMethod.PUT, HttpMethod.POST,HttpMethod.DELETE};
        config.getExposureConfiguration()
                .forDomainType(Product.class)
                .withAssociationExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedAction))
                .withCollectionExposure(((metdata, httpMethods) -> httpMethods.disable(theUnsupportedAction)));


        config.getExposureConfiguration()
                .forDomainType(ProductCategory.class)
                .withAssociationExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedAction))
                .withCollectionExposure(((metdata, httpMethods) -> httpMethods.disable(theUnsupportedAction)));
    }
}
