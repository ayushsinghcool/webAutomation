package api.helpers;

import java.util.Map;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonProcessing {

	public ObjectMapper objectMapper = new ObjectMapper();
	
	public JsonProcessing() 
	{
	}

	public String ConvertModelToJSON(Map<String, String> inputMap)
	{		
		String postModelAsString = null;
		try 
		{
			postModelAsString = objectMapper.writeValueAsString(inputMap);
			return postModelAsString;
		} 
		catch (Exception e)
		{

		}
		
		return postModelAsString;		
	}
	
	public Map<?, ?> ConvertModelToMap(Object model) 
	{
		Map<?, ?> mappedObject = objectMapper.convertValue(model, Map.class);
		return mappedObject;
	}

}