import java.util.*;

public class LabeledPropertyNode {
	// A labeled property node has a name, a label and a set of key value pairs.
	// The key value pairs represent the properties.
	String name;
	String label;
	Map<String,String> properties = new HashMap<String,String>();
	
	//Constructor
	public LabeledPropertyNode(String name) {
		this.name = name;
	}
	public LabeledPropertyNode(String name, String label) {
		this.name = name;
		this.label = label;
	}
	public LabeledPropertyNode(String name, String label, String propertyName, String propertyValue) {
		this.name = name;
		this.label = label;
		addProperty(propertyName, propertyValue);
	}
	public LabeledPropertyNode(String name, String label, String propertyName, String propertyValue, 
										   String propertyName2, String propertyValue2) 
	{
		this.name = name;
		this.label = label;
		addProperty(propertyName, propertyValue);
		addProperty(propertyName2, propertyValue2);
	}
	public LabeledPropertyNode(String name, String label, String propertyName, String propertyValue, 
										   	String propertyName2, String propertyValue2, 
										   	String propertyName3, String propertyValue3) 
	{
		this.name = name;
		this.label = label;
		addProperty(propertyName, propertyValue);
		addProperty(propertyName2, propertyValue2);
		addProperty(propertyName3, propertyValue3);
	}
	
	//Adds a property to a node
	public void addProperty(String propertyName, String propertyValue) {
		this.properties.put(propertyName, propertyValue);
	}
	
	//Set the label of a node
	public void setLabel(String label) {
		this.label = label;
	}
	
	//Returns whether a node has a specific property or not
	public boolean hasProperty(String propertyName, String propertyValue) {
		if(this.properties.containsKey(propertyName)) {
			if(this.properties.get(propertyName) == propertyValue) {
				return true;
			}
		}
		return false;
	}
	
	//Returns whether a node has a specific label or not
		public boolean hasLabel(String label) {
			if(this.label == label) {
				return true; 
			}
			return false;
		}
	
	//Get name of node
	public String getName() {
		return this.name;
	}
	
	//Get label of node
	public String getLabel(String label) {
		return this.label;
	}
	
	//Gives all the node information
	public String nodeInfo() {
		StringBuilder ret = new StringBuilder(this.name);
		if(!this.label.isEmpty())
			ret.append(", Label: " + this.label);
		if(!properties.isEmpty())
			ret.append(", Properties: " + this.properties.toString());
		return ret.toString();
	}
	
	//Returns only the name of the node
	@Override
	public String toString() {
		String ret = this.name;
		return ret;
	}
}
