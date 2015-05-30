package ly.whisk.views;

import io.dropwizard.views.View;
import io.swagger.client.api.RecipesApi;
import io.swagger.client.api.SearchApi;

public abstract class BaseView extends View {

	private RecipesApi recipes;
	private SearchApi search;

	protected BaseView(String templateName) {
		super(templateName);
		this.recipes = new RecipesApi();
		this.search = new SearchApi();
	}

	public RecipesApi getRecipes() {
		return recipes;
	}

	public void setRecipes(RecipesApi recipes) {
		this.recipes = recipes;
	}

	public SearchApi getSearch() {
		return search;
	}

	public void setSearch(SearchApi search) {
		this.search = search;
	}

}
