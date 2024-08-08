package com.youtube.jwt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class AssetsData {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long assetsId;
	private String assetName;
	private String assetType;
	@Lob
	@Column(name = "asset_data", columnDefinition = "BLOB")
	private byte[] assetData;
	
	private String serialNumber;
	private String value;
	private String location;
	private String status;
	private String description;
	public Long getAssetsId() {
		return assetsId;
	}
	public void setAssetsId(Long assetsId) {
		this.assetsId = assetsId;
	}
	public String getAssetName() {
		return assetName;
	}
	public void setAssetName(String assetName) {
		this.assetName = assetName;
	}
	public String getAssetType() {
		return assetType;
	}
	public void setAssetType(String assetType) {
		this.assetType = assetType;
	}
	
	public byte[] getAssetData() {
		return assetData;
	}
	public void setAssetData(byte[] assetData) {
		this.assetData = assetData;
	}
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
