package io.swagger.client.api;

import io.swagger.client.ApiException;
import io.swagger.client.ApiInvoker;
import io.swagger.client.model.Recipe;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RecipesApi {
	String basePath = "https://api.whisk.ly/v1";
	ApiInvoker apiInvoker = ApiInvoker.getInstance();

	public ApiInvoker getInvoker() {
		return apiInvoker;
	}

	public void setBasePath(String basePath) {
		this.basePath = basePath;
	}

	public String getBasePath() {
		return basePath;
	}

	/**
	 * Search all recipes Returns a listing of all recipes, paged.
	 * 
	 * @param pageNum
	 *            The page number to give back.
	 * @param pageSize
	 *            The size of each page to give back.
	 * @param search
	 *            Searches all text fields.
	 * @return List<Recipe>
	 */
	public List<Recipe> recipesGet(Integer pageNum, Integer pageSize,
			String search) throws ApiException {
		Object postBody = null;

		// create path and map variables
		String path = "/recipes".replaceAll("\\{format\\}", "json");

		// query params
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();
		Map<String, String> formParams = new HashMap<String, String>();

		if (pageNum != null)
			queryParams.put("pageNum", ApiInvoker.parameterToString(pageNum));
		if (pageSize != null)
			queryParams.put("pageSize", ApiInvoker.parameterToString(pageSize));
		if (search != null)
			queryParams.put("search", ApiInvoker.parameterToString(search));

		String[] contentTypes = {

		};

		String contentType = contentTypes.length > 0 ? contentTypes[0]
				: "application/json";

		if (contentType.startsWith("multipart/form-data")) {
			boolean hasFields = false;
			/*
			 * FormDataMultiPart mp = new FormDataMultiPart();
			 * 
			 * if (hasFields) postBody = mp;
			 */
		} else {

		}

		try {
			String response = apiInvoker.invokeAPI(basePath, path, "GET",
					queryParams, postBody, headerParams, formParams,
					contentType);
			if (response != null) {
				return (List<Recipe>) ApiInvoker.deserialize(response, "array",
						Recipe.class);
			} else {
				return null;
			}
		} catch (ApiException ex) {
			throw ex;
		}
	}

	/**
	 * New Recipe Adds a new recipe to the database, adding a unique id on the
	 * way in.
	 * 
	 * @param recipe
	 * @return Recipe
	 */
	public Recipe recipesPost(Recipe recipe) throws ApiException {
		Object postBody = recipe;

		// create path and map variables
		String path = "/recipes".replaceAll("\\{format\\}", "json");

		// query params
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();
		Map<String, String> formParams = new HashMap<String, String>();

		String[] contentTypes = {

		};

		String contentType = contentTypes.length > 0 ? contentTypes[0]
				: "application/json";

		if (contentType.startsWith("multipart/form-data")) {
			boolean hasFields = false;
			/*
			 * FormDataMultiPart mp = new FormDataMultiPart();
			 * 
			 * if (hasFields) postBody = mp;
			 */
		} else {

		}

		try {
			String response = apiInvoker.invokeAPI(basePath, path, "POST",
					queryParams, postBody, headerParams, formParams,
					contentType);
			if (response != null) {
				return (Recipe) ApiInvoker.deserialize(response, "",
						Recipe.class);
			} else {
				return null;
			}
		} catch (ApiException ex) {
			throw ex;
		}
	}

	/**
	 * Single Recipe Returns a single recipe for a given id.
	 * 
	 * @param id
	 *            Id of the recipe to fetch
	 * @return Recipe
	 */
	public Recipe recipesIdGet(String id) throws ApiException {
		Object postBody = null;

		// create path and map variables
		String path = "/recipes/{id}".replaceAll("\\{format\\}", "json")
				.replaceAll("\\{" + "id" + "\\}",
						apiInvoker.escapeString(id.toString()));

		// query params
		Map<String, String> queryParams = new HashMap<String, String>();
		Map<String, String> headerParams = new HashMap<String, String>();
		Map<String, String> formParams = new HashMap<String, String>();

		String[] contentTypes = {

		};

		String contentType = contentTypes.length > 0 ? contentTypes[0]
				: "application/json";

		if (contentType.startsWith("multipart/form-data")) {
			boolean hasFields = false;
			/*
			 * FormDataMultiPart mp = new FormDataMultiPart();
			 * 
			 * if (hasFields) postBody = mp;
			 */
		} else {

		}

		try {
			String response = apiInvoker.invokeAPI(basePath, path, "GET",
					queryParams, postBody, headerParams, formParams,
					contentType);
			if (response != null) {
				return (Recipe) ApiInvoker.deserialize(response, "",
						Recipe.class);
			} else {
				return null;
			}
		} catch (ApiException ex) {
			throw ex;
		}
	}

}
