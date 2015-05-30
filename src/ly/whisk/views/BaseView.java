package ly.whisk.views;

import com.google.common.base.Optional;

import ly.whisk.auth.SRMUser;
import io.dropwizard.views.View;
import io.swagger.client.api.RecipesApi;
import io.swagger.client.api.SearchApi;

public abstract class BaseView extends View {

	private RecipesApi recipes;
	private SearchApi search;
	private SRMUser user;

	public SRMUser getUser() {
		return user;
	}

	public void setUser(SRMUser user) {
		this.user = user;
	}

	protected BaseView(String templateName, Optional<SRMUser> user) {
		super(templateName);
		this.recipes = new RecipesApi();
		this.search = new SearchApi();

		this.user = user.or(SRMUser.guestSupplier());
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
