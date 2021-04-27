package com.example.personalchef.view.home;

import com.example.personalchef.model.Categories;
import com.example.personalchef.model.Meals;

import java.util.List;

public interface HomeView {
    void showLoading();
    void hideLoading();
    void setMeal(List<Meals.Meal> meal);
    void setCategory(List<Categories.Category> category);
    void onErrorLoading(String message);
}
