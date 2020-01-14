package com.mindtree.candyshopmanagementsystem.dto;

public class TypeDto {
	private int typeId;
	private String typeName;
	public TypeDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TypeDto(int typeId, String typeName) {
		super();
		this.typeId = typeId;
		this.typeName = typeName;
	}
	public int getTypeId() {
		return typeId;
	}
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	
}
