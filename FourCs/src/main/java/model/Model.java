package main.java.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;


public class Model 
{
	PropertyChangeSupport changes;
	
	public Model() {
		changes= new PropertyChangeSupport(this);
		
		// TODO Auto-generated constructor stub
	}
	
	public void AddPropertyChangeListener(PropertyChangeListener propertyChangeListener)
	{
		changes.addPropertyChangeListener(propertyChangeListener);
		
	}
	
	
	

}
