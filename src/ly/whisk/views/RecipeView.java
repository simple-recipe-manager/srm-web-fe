package ly.whisk.views;

import io.swagger.client.model.Recipe;
import ly.whisk.auth.SRMUser;

import com.google.common.base.Optional;

public class RecipeView extends BaseView {
	private final Recipe recipe;

	public RecipeView(Optional<SRMUser> user, Recipe recipe) {
		super("recipe.ftl", user);
		this.recipe = recipe;
	}

	public Recipe getRecipe() {
		return recipe;
	}

}
