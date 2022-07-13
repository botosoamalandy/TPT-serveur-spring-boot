package com.tptransversal.rdvvaksiny.autre;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Vector;

public class Json extends HashMap<String, Object>{
	private static final long serialVersionUID = 4185759267522893546L;
	public static String jsonArray(Json[] jsons) {
		String res = "[";
		for (int i = 0; i < jsons.length; i++) {
			res += jsons[i];
			res += i + 1 < jsons.length ? "," : ""; 
		}
		res += "]";
		return res;
	}
	@Override
	public String toString() {
		String json = "{";
        if (!this.isEmpty()) { 
        	Set<String> set = this.keySet();
        	int index = 0;
        	for (Iterator<String> iterator = set.iterator(); iterator.hasNext();) {
    			String key = iterator.next();
    			if(this.get(key) instanceof Integer || this.get(key) instanceof Long || this.get(key) instanceof Double) {
    				json += "\""+key+"\" : "+this.get(key)+"";
    			}else if(this.get(key) instanceof Timestamp){
    				Timestamp dates=(Timestamp)this.get(key);
    				json += "\""+key+"\" : \""+dates.toLocalDateTime()+"\"";
    			}else if(this.get(key) instanceof Boolean){
    				boolean bol=(Boolean)this.get(key);
    				json += "\""+key+"\" : "+bol+"";
    			}else {
    				if(formatJsonOrNo(this.get(key).toString())) {
    					json += "\""+key+"\" : "+this.get(key)+"";
    				}else {
    					json += "\""+key+"\" : \""+this.get(key)+"\"";
    				}
    			}
    			json += index + 1 < set.size() ? " , " : "}";  
    			index++;
    		}
        	return json;
        } 
        return "{}";
	}
	public String setJsonToStringJson(Vector<Json> jsons) {
		Json []jsons2=new Json[jsons.size()];
		for(int i=0;i<jsons.size();i++) {
			jsons2[i]=jsons.get(i);
		}
		String newJson=jsonArray(jsons2);
		return newJson;
	}
	public String caseT(String mot) {
    	String reste=mot.substring(1);
    	char premierLettreEnChar=mot.charAt(0);
    	String premierLettreEnString=""+premierLettreEnChar;
    	return premierLettreEnString.toUpperCase()+reste;
    }
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Json putObjectInJson(Object object) throws Exception {
		Json json=new Json();
		Field []field=object.getClass().getDeclaredFields();
		Class classe=object.getClass();int size2=field.length;
		for (int j = 0; j < size2; j++) {
			Method methodeTemporaire=classe.getMethod("get"+caseT(field[j].getName()));
			Object objectInvokeTemporaire=methodeTemporaire.invoke(object);
			json.put(field[j].getName(), objectInvokeTemporaire);			
		}
		return json;
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String setObjectToDataJson(Object object) throws Exception {
		Json json=new Json();
		Field []field=object.getClass().getDeclaredFields();
		Class classe=object.getClass();int size2=field.length;
		for (int j = 0; j < size2; j++) {
			Method methodeTemporaire=classe.getMethod("get"+caseT(field[j].getName()));
			Object objectInvokeTemporaire=methodeTemporaire.invoke(object);
			json.put(field[j].getName(), objectInvokeTemporaire);			
		}
		return json.toString();
	}
	
	public String getJsonToStringGeneraliser(Object []objects) throws Exception{
		int size=objects.length;
		Json jsonTmp=new Json();
		Vector<Json> jsons=new Vector<Json>();
		for (int i = 0; i < size; i++) {
			if(objects[i]!=null) {
				jsons.add(putObjectInJson(objects[i]));
			}
		}
		return jsonTmp.setJsonToStringJson(jsons);
	}
	public String getJsonVectorTableau(Vector<Object[]> vector,String [] values) throws Exception {
		int size=vector.size();
		if(size==values.length) {
			Vector<Json> jsons=new Vector<Json>();
			for (int i = 0; i < size; i++) {
				
				Json json=new Json();json.put(values[i],getJsonToStringGeneraliser(vector.get(i)));
				jsons.add(json);
			}
			return setJsonToStringJson(jsons);
		}
		return "";
	}
	public boolean formatJsonOrNo(String valeur) {
		if(valeur.length()>0) {
			if(valeur.charAt(0)=='[' && valeur.charAt(valeur.length()-1)==']') {
				return true;
			}
		}
		return false;
	}
	
	public String createDataJson(Object []objects) {
		Json json=new Json();
		try {
			json.put("data", getJsonToStringGeneraliser(objects));
			json.put("status",200);
			json.put("message","success");
			
		} catch (Exception e) {
			e.printStackTrace();
			json.put("data", "");
			json.put("status",400);
			json.put("message",e.getMessage());
		}
		return json.toString();
	}
	public String createDataJsonByList(List<Object> list) {
		int size=list.size();Object []objects=new Object[size];
		for (int i = 0; i < size; i++) {
			objects[i]=list.get(i);
		}
		return createDataJson(objects);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
