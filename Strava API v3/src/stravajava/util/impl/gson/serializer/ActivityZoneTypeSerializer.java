package stravajava.util.impl.gson.serializer;

import java.lang.reflect.Type;

import stravajava.api.v3.model.reference.StravaActivityZoneType;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

/**
 * @author Dan Shannon
 *
 */
public class ActivityZoneTypeSerializer implements JsonSerializer<StravaActivityZoneType>, JsonDeserializer<StravaActivityZoneType> {

	/**
	 * @see com.google.gson.JsonDeserializer#deserialize(com.google.gson.JsonElement, java.lang.reflect.Type, com.google.gson.JsonDeserializationContext)
	 */
	@Override
	public StravaActivityZoneType deserialize(JsonElement json, Type type, JsonDeserializationContext context) throws JsonParseException {
		return StravaActivityZoneType.create(json.getAsString());
	}

	/**
	 * @see com.google.gson.JsonSerializer#serialize(java.lang.Object, java.lang.reflect.Type, com.google.gson.JsonSerializationContext)
	 */
	@Override
	public JsonElement serialize(StravaActivityZoneType activityZoneType, Type type, JsonSerializationContext context) {
		return context.serialize(activityZoneType.getValue());
	}

}