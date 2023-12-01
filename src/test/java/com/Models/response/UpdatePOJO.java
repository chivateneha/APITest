package com.Models.response;


import java.util.LinkedHashMap;
import java.util.Map;



public class UpdatePOJO {

private String name;
private String description;
private String _private;
private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

public String getName() {
return name;
}

public void setName(String name) {
this.name = name;
}

public String getDescription() {
return description;
}

public void setDescription(String description) {
this.description = description;
}

public String getPrivate() {
return _private;
}

public void setPrivate(String _private) {
this._private = _private;
}

public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

@Override
public int hashCode() {
int result = 1;
result = ((result* 31)+((this.name == null)? 0 :this.name.hashCode()));
result = ((result* 31)+((this.description == null)? 0 :this.description.hashCode()));
result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
result = ((result* 31)+((this._private == null)? 0 :this._private.hashCode()));
return result;
} }

