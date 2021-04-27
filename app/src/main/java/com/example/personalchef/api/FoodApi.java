package com.example.personalchef.api;

import com.example.personalchef.model.Categories;
import com.example.personalchef.model.Meals;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface FoodApi {

    @GET("latest.php")
    Call<Meals> getMeal();

    @GET("categories.php")
    Call<Categories> getCategories();

    @GET("filter.php") 
    Call<Meals> getMealByCategory(@Query("c") String category);

    //@GET("filter.php")
    //Call<Meals> getMealByIngredient(Query("i") String ingredient);

    @GET("search.php")
    Call<Meals> getMealByName(@Query("s")String mealName);
}
