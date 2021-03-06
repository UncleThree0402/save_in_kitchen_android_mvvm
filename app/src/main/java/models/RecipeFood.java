package models;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.room.*;

@Entity(tableName = "recipe_food",foreignKeys = {@ForeignKey(entity = Recipe.class,parentColumns = "recipe_id", childColumns = "recipe_id",onDelete = ForeignKey.CASCADE),@ForeignKey(entity = FoodType.class,parentColumns = "food_type_id", childColumns = "food_type_id",onDelete = ForeignKey.CASCADE)})
public class RecipeFood implements Parcelable {

    @PrimaryKey(autoGenerate = true)
    private int recipe_food_id;

    @ColumnInfo(name = "recipe_id")
    private int recipe_id;

    @ColumnInfo(name = "food_type_id")
    private int food_type_id;

    @ColumnInfo(name = "recipe_food_name")
    private String name;

    @ColumnInfo(name = "recipe_food_status")
    private String status;

    @ColumnInfo(name = "recipe_food_quantity")
    private double quantity;

    @ColumnInfo(name = "recipe_food_unit")
    private String unit;

    @ColumnInfo(name = "recipe_food_description")
    private String description;

    public RecipeFood(int recipe_food_id, int recipe_id, int food_type_id, String name, String status, double quantity, String unit, String description) {
        this.recipe_food_id = recipe_food_id;
        this.recipe_id = recipe_id;
        this.food_type_id = food_type_id;
        this.name = name;
        this.status = status;
        this.quantity = quantity;
        this.unit = unit;
        this.description = description;
    }

    @Ignore
    public RecipeFood() {
    }

    protected RecipeFood(Parcel in) {
        recipe_food_id = in.readInt();
        recipe_id = in.readInt();
        food_type_id = in.readInt();
        name = in.readString();
        status = in.readString();
        quantity = in.readDouble();
        unit = in.readString();
        description = in.readString();
    }

    public static final Creator<RecipeFood> CREATOR = new Creator<RecipeFood>() {
        @Override
        public RecipeFood createFromParcel(Parcel in) {
            return new RecipeFood(in);
        }

        @Override
        public RecipeFood[] newArray(int size) {
            return new RecipeFood[size];
        }
    };

    public int getRecipe_food_id() {
        return recipe_food_id;
    }

    public void setRecipe_food_id(int recipe_food_id) {
        this.recipe_food_id = recipe_food_id;
    }

    public int getRecipe_id() {
        return recipe_id;
    }

    public void setRecipe_id(int recipe_id) {
        this.recipe_id = recipe_id;
    }

    public int getFood_type_id() {
        return food_type_id;
    }

    public void setFood_type_id(int food_type_id) {
        this.food_type_id = food_type_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(recipe_food_id);
        dest.writeInt(recipe_id);
        dest.writeInt(food_type_id);
        dest.writeString(name);
        dest.writeString(status);
        dest.writeDouble(quantity);
        dest.writeString(unit);
        dest.writeString(description);
    }
}
