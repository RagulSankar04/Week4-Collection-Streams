interface MealPlan {
    String getMealType();
    void showMealDetails();
}

// --- Implementations of MealPlan Interface ---
class VegetarianMeal implements MealPlan {
    @Override
    public String getMealType() {
        return "Vegetarian";
    }

    @Override
    public void showMealDetails() {
        System.out.println("Vegetarian Meal: Paneer, Rice, Vegetables, Fruits");
    }
}

class VeganMeal implements MealPlan {
    @Override
    public String getMealType() {
        return "Vegan";
    }

    @Override
    public void showMealDetails() {
        System.out.println("Vegan Meal: Tofu, Quinoa, Leafy Greens, Avocado");
    }
}

class KetoMeal implements MealPlan {
    @Override
    public String getMealType() {
        return "Keto";
    }

    @Override
    public void showMealDetails() {
        System.out.println("Keto Meal: Eggs, Cheese, Chicken, Leafy Veggies");
    }
}

class HighProteinMeal implements MealPlan {
    @Override
    public String getMealType() {
        return "High-Protein";
    }

    @Override
    public void showMealDetails() {
        System.out.println("High-Protein Meal: Grilled Chicken, Lentils, Boiled Eggs");
    }
}

// --- Generic Meal Class ---
class Meal<T extends MealPlan> {
    private T mealType;

    public Meal(T mealType) {
        this.mealType = mealType;
    }

    public T getMealType() {
        return mealType;
    }

    public void displayMeal() {
        System.out.println("Meal Type: " + mealType.getMealType());
        mealType.showMealDetails();
    }
}

// --- Utility Class for Validation & Generation ---
class MealPlanner {
    public static <T extends MealPlan> void generateMealPlan(T plan) {
        System.out.println("Generating your personalized meal plan...");
        Meal<T> meal = new Meal<>(plan);
        meal.displayMeal();
        System.out.println("✅ Plan Generated Successfully!\n");
    }
}

// --- Main Class ---
public class PersonalizedMealPlanner {
    public static void main(String[] args) {
        // Simulate meal preferences
        VegetarianMeal veg = new VegetarianMeal();
        VeganMeal vegan = new VeganMeal();
        KetoMeal keto = new KetoMeal();
        HighProteinMeal protein = new HighProteinMeal();

        // Generate personalized plans
        System.out.println("---- Personalized Meal Plans ----");
        MealPlanner.generateMealPlan(veg);
        MealPlanner.generateMealPlan(vegan);
        MealPlanner.generateMealPlan(keto);
        MealPlanner.generateMealPlan(protein);
    }
}
