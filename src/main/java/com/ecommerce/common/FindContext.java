package com.ecommerce.common;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;

public class FindContext {

    public SearchContext context;
    public By locator;

    public FindContext(SearchContext context,By locator){
        this.context=context;
        this.locator=locator;
    }

}
