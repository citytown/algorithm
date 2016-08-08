package com.planone.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;

public class BaseDao<T> {

	private Class<T> clazz;
	
	public BaseDao(){
		//获取带泛型参数的父类
		Type type=this.getClass().getGenericSuperclass();
		//获取具体的泛型参数
		if(type instanceof ParameterizedType){
			ParameterizedType parameterizedType= (ParameterizedType) type;
			//获取parameterType真正具有的参数，一般只有数组第一个具有值
			Type[] types= parameterizedType.getActualTypeArguments();
			System.out.println(Arrays.asList(types));
			if(types !=null && types.length>0){
				if(types[0] instanceof Class){
					clazz = (Class<T>) types[0];
				}
			}
		}
		
	}
	
	public T getEntity(String id){
		System.out.println(clazz);
		return null;
	}
	
	public void saveEntity(T entity){
		System.out.println("save Entity!");
	}
}
