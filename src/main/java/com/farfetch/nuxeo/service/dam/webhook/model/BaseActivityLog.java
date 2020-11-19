package com.farfetch.nuxeo.service.dam.webhook.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * BaseActivityLog
 */
public class BaseActivityLog   {

  @JsonProperty("date")
  private OffsetDateTime date;

  @JsonProperty("userId")
  private String userId;

  @JsonProperty("workstationId")
  @JsonInclude(JsonInclude.Include.NON_NULL)
  private String workstationId;

  @JsonProperty("productId")
  private Integer productId;

  @JsonProperty("productionItemsIds")
  @Valid
  private List<UUID> productionItemsIds = new ArrayList<>();

  public BaseActivityLog date(OffsetDateTime date) {
    this.date = date;
    return this;
  }

  /**
   * The date that the event ocurred on the origin system. Use date-time notation as defined by [RFC 3339, section 5.6](https://tools.ietf.org/html/rfc3339#section-5.6)
   * @return date
  */
  @ApiModelProperty(example = "2017-07-21T17:32:28Z", required = true, value = "The date that the event ocurred on the origin system. Use date-time notation as defined by [RFC 3339, section 5.6](https://tools.ietf.org/html/rfc3339#section-5.6)")
  @NotNull
  @Valid
  public OffsetDateTime getDate() {
    return date;
  }

  public void setDate(OffsetDateTime date) {
    this.date = date;
  }

  public BaseActivityLog userId(String userId) {
    this.userId = userId;
    return this;
  }

  /**
   * The active directory user's security identifier.
   * @return userId
  */
  @ApiModelProperty(example = "S-1-5-32-1045337234-12924708993-5683276719-19000", required = true, value = "The active directory user's security identifier.")
  @NotNull
  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public BaseActivityLog workstationId(String workstationId) {
    this.workstationId = workstationId;
    return this;
  }

  /**
   * The identification of the physical workstation where the user made the action. *The property is required but it can be* `null`.
   * @return workstationId
  */
  @ApiModelProperty(example = "1221", required = true, value = "The identification of the physical workstation where the user made the action. *The property is required but it can be* `null`.")
  public String getWorkstationId() {
    return workstationId;
  }

  public void setWorkstationId(String workstationId) {
      this.workstationId = workstationId;
      if(this.workstationId == null) {
          this.workstationId = "";
      }
  }

  public BaseActivityLog productId(Integer productId) {
    this.productId = productId;
    return this;
  }

  /**
   * The identification of the product involved in the event.
   * @return productId
  */
  @ApiModelProperty(example = "23123543", required = true, value = "The identification of the product involved in the event.")
  @NotNull
  public Integer getProductId() {
    return productId;
  }

  public void setProductId(Integer productId) {
    this.productId = productId;
  }

  public BaseActivityLog productionItemsIds(List<UUID> productionItemsIds) {
    this.productionItemsIds = productionItemsIds;
    return this;
  }

  public BaseActivityLog addProductionItemsIdsItem(UUID productionItemsIdsItem) {
    this.productionItemsIds.add(productionItemsIdsItem);
    return this;
  }

  /**
   * The identification of the production items involved in the event.
   * @return productionItemsIds
  */
  @ApiModelProperty(example = "[\"5d70e701-d00d-45d8-a9bf-66753bb56b20\"]", required = true, value = "The identification of the production items involved in the event.")
  @NotNull
  @Valid
  public List<UUID> getProductionItemsIds() {
    return productionItemsIds;
  }

  public void setProductionItemsIds(List<UUID> productionItemsIds) {
    this.productionItemsIds = productionItemsIds;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BaseActivityLog baseActivityLog = (BaseActivityLog) o;
    return Objects.equals(this.date, baseActivityLog.date) &&
        Objects.equals(this.userId, baseActivityLog.userId) &&
        Objects.equals(this.workstationId, baseActivityLog.workstationId) &&
        Objects.equals(this.productId, baseActivityLog.productId) &&
        Objects.equals(this.productionItemsIds, baseActivityLog.productionItemsIds);
  }

  @Override
  public int hashCode() {
    return Objects.hash(date, userId, workstationId, productId, productionItemsIds);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BaseActivityLog {\n");
    
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
    sb.append("    workstationId: ").append(toIndentedString(workstationId)).append("\n");
    sb.append("    productId: ").append(toIndentedString(productId)).append("\n");
    sb.append("    productionItemsIds: ").append(toIndentedString(productionItemsIds)).append("\n");
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

