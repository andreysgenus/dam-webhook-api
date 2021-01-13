package com.farfetch.nuxeo.service.dam.webhook.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * AssetPublication
 */
public class AssetPublication extends BaseActivityLog  {
  @JsonProperty("tenant")
  private Integer tenant;

  @JsonProperty("viewOrder")
  private Integer viewOrder;

  @JsonProperty("viewType")
  private String viewType;

  /**
   * The type of asset that is being published on unpublished.
   */
  public enum AssetTypeEnum {
    IMAGE("Image"),
    
    VIDEO("Video");

    private String value;

    AssetTypeEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static AssetTypeEnum fromValue(String value) {
      for (AssetTypeEnum b : AssetTypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("assetType")
  private AssetTypeEnum assetType;

  @JsonProperty("digitalAssetId")
  private Integer digitalAssetId;

  @JsonProperty("externalDigitalAssetId")
  private String externalDigitalAssetId;


  public AssetPublication tenant(Integer tenant) {
    this.tenant = tenant;
    return this;
  }

  /**
   * The tenant where the digital asset should be published or unpublished.
   * @return tenant
  */
  @ApiModelProperty(example = "5000", required = true, value = "The tenant where the digital asset should be published or unpublished.")
  @NotNull
  public Integer getTenant() {
    return tenant;
  }

  public void setTenant(Integer tenant) {
    this.tenant = tenant;
  }

  public AssetPublication viewOrder(Integer viewOrder) {
    this.viewOrder = viewOrder;
    return this;
  }

  /**
   * The order of the asset for presentation.
   * @return viewOrder
  */
  @ApiModelProperty(required = true, value = "The order of the asset for presentation.")
  @NotNull
  public Integer getViewOrder() {
    return viewOrder;
  }

  public void setViewOrder(Integer viewOrder) {
    this.viewOrder = viewOrder;
  }

  public AssetPublication viewType(String viewType) {
    this.viewType = viewType;
    return this;
  }

  /**
   * The type of view of the asset.
   * @return viewType
  */
  @ApiModelProperty(required = true, value = "The type of view of the asset.")
  @NotNull


  public String getViewType() {
    return viewType;
  }

  public void setViewType(String viewType) {
    this.viewType = viewType;
  }

  public AssetPublication assetType(AssetTypeEnum assetType) {
    this.assetType = assetType;
    return this;
  }

  /**
   * The type of asset that is being published on unpublished.
   * @return assetType
  */
  @ApiModelProperty(required = true, value = "The type of asset that is being published on unpublished.")
  @NotNull
  public AssetTypeEnum getAssetType() {
    return assetType;
  }

  public void setAssetType(AssetTypeEnum assetType) {
    this.assetType = assetType;
  }

  public AssetPublication digitalAssetId(Integer digitalAssetId) {
    this.digitalAssetId = digitalAssetId;
    return this;
  }

  public AssetPublication externalDigitalAssetId(String externalDigitalAssetId) {
        this.externalDigitalAssetId = externalDigitalAssetId;
        return this;
  }

  /**
   * The identification of the digital asset to be published or unpublished.
   * @return digitalAssetId
  */
  @ApiModelProperty(example = "32423432", required = true, value = "The identification of the digital asset to be published or unpublished.")
  @NotNull
  public Integer getDigitalAssetId() {
    return digitalAssetId;
  }

  public void setDigitalAssetId(Integer digitalAssetId) {
    this.digitalAssetId = digitalAssetId;
  }

    @ApiModelProperty(example = "32423432", required = true, value = "The identification of the digital asset to be published or unpublished.")
    public String getExternalDigitalAssetId() {
        return externalDigitalAssetId;
    }

    public void setExternalDigitalAssetId(String externalDigitalAssetId) {
        this.externalDigitalAssetId = externalDigitalAssetId;
    }

    @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    return Objects.hash(tenant, viewOrder, viewType, assetType, digitalAssetId.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AssetPublication {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    tenant: ").append(toIndentedString(tenant)).append("\n");
    sb.append("    viewOrder: ").append(toIndentedString(viewOrder)).append("\n");
    sb.append("    viewType: ").append(toIndentedString(viewType)).append("\n");
    sb.append("    assetType: ").append(toIndentedString(assetType)).append("\n");
    sb.append("    digitalAssetId: ").append(toIndentedString(digitalAssetId)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

