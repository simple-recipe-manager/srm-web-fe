package ly.whisk.storage;

import io.swagger.client.ApiException;
import io.swagger.client.api.RecipesApi;
import io.swagger.client.model.Recipe;

public class APIStorage implements IRecipeStorage {

	private RecipesApi api;

	public APIStorage() {
		this.api = new RecipesApi();
	}

	@Override
	public Recipe getRecipe(String id) throws ApiException {
		return this.api.recipesIdGet(id);
	}

}
