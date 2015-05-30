package ly.whisk.views;

import io.swagger.client.model.Recipe;

public class RecipeView extends BaseView {
	private final Recipe recipe;

	public RecipeView(Recipe recipe) {
		super("recipe.ftl");
		this.recipe = recipe;
	}

	public Recipe getRecipe() {
		return recipe;
	}

}
