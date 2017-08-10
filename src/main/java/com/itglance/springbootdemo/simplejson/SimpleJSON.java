package com.itglance.springbootdemo.simplejson;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

import com.itglance.springbootdemo.entity.User;
import com.itglance.springbootdemo.error.entity.ApiError;

@Service
@SuppressWarnings("unchecked")
public class SimpleJSON {
	
	
	public JSONObject getUserJSON(List<User> userList){
		JSONArray JSONArray = new JSONArray();
		for (User userinfo : userList){
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("id", userinfo.getId());
			jsonObject.put("name", userinfo.getName());
			JSONArray.add(jsonObject);		
		}
		JSONObject userJsonObject = new JSONObject();
		userJsonObject.put("data", JSONArray);
		return userJsonObject;
	}
	
	public JSONObject getErrorJSON(ApiError apiError){
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("message", apiError.getMessage());
		jsonObject.put("developer message", apiError.getDeveloperMessage());
		JSONObject jsonErrorObject = new JSONObject();
		jsonErrorObject.put("error", jsonObject);
		return jsonErrorObject;
	}

}
