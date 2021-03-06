package viewmodels;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import models.Food;
import models.RecipeFood;
import presistance.SaveInKitchenRepository;

import java.util.List;

public class RecipeFoodViewModel extends AndroidViewModel {

    private final SaveInKitchenRepository mSaveInKitchenRepository;

    private final LiveData<List<RecipeFood>> mRecipeFood;

    public RecipeFoodViewModel(@NonNull Application application) {
        super(application);
        mSaveInKitchenRepository = new SaveInKitchenRepository(application);
        mRecipeFood = mSaveInKitchenRepository.getRecipeFood();
    }

    public void insertRecipeFood(RecipeFood recipeFood){
        mSaveInKitchenRepository.insertRecipeFood(recipeFood);
    }

    public void updateRecipeFood(RecipeFood recipeFood){
        mSaveInKitchenRepository.updateRecipeFood(recipeFood);
    }

    public void deleteRecipeFood(RecipeFood recipeFood){
        mSaveInKitchenRepository.deleteRecipeFood(recipeFood);
    }

    public LiveData<List<RecipeFood>> getRecipeFood(){
        return mRecipeFood;
    }

    public LiveData<List<RecipeFood>> getSpecificRecipeFood(int id){
        return  mSaveInKitchenRepository.getSpecificRecipeFood(id);
    }

    public LiveData<List<RecipeFood>> getSpecificNameRecipeFood(String name){
        return  mSaveInKitchenRepository.getSpecificNameRecipeFood(name);
    }
}
