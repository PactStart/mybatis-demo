package com.pactrex.mybatis.demo.plugin;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Map.Entry;

import org.apache.ibatis.reflection.factory.DefaultObjectFactory;

public class CustomerObjectFactory extends DefaultObjectFactory {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public <T> T create(Class<T> type) {
		System.out.println("create");
		return super.create(type);
	}

	@Override
	public <T> T create(Class<T> type, List<Class<?>> constructorArgTypes, List<Object> constructorArgs) {
		System.out.println("create by args");
		return super.create(type, constructorArgTypes, constructorArgs);
	}

	public void setProperties(Properties properties) {
		Iterator<Entry<Object, Object>> iterator = properties.entrySet().iterator();
		while(iterator.hasNext()){
			Entry<Object, Object> entry = iterator.next();
			System.out.println(entry.getKey() + ":" + entry.getValue());
		}
		super.setProperties(properties);
	}

	public <T> boolean isCollection(Class<T> type) {
		return Collection.class.isAssignableFrom(type);
	}
}