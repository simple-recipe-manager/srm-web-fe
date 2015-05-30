package ly.whisk.storage;

import io.swagger.client.model.Recipe;

public interface IRecipeStorage {

	public Recipe getRecipe(String id) throws Exception;

}
