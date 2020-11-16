package com.farfetch.nuxeo.service.dam.webhook.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * The possible activity log operations.
 */
@ApiModel(description = "The possible activity log operations.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2020-11-04T18:50:14.537-06:00[America/Chicago]")

public class OperationEnum   {
  /**
   * The event being send to the Farfetch platform.
   */
  public enum OperationEnumEnum {
    SHOOTINGSESSIONSTARTED("ShootingSessionStarted"),
    
    PRODUCTIONITEMSHOOTINGSTARTED("ProductionItemShootingStarted"),
    
    ASSETTRANSFERSTARTED("AssetTransferStarted"),
    
    ASSETTRANSFERCOMPLETED("AssetTransferCompleted"),
    
    PRODUCTIONITEMSHOOTINGCOMPLETED("ProductionItemShootingCompleted"),
    
    SHOOTINGSESSIONCOMPLETED("ShootingSessionCompleted"),
    
    ASSETTRANSFERFAIL("AssetTransferFail"),
    
    STUDIOSTYLINGQUALITYCONTROLSTART("StudioStylingQualityControlStart"),
    
    STUDIOSTYLINGQUALITYCONTROLFINISH("StudioStylingQualityControlFinish"),
    
    STUDIOSTYLINGQUALITYCONTROLRESHOOT("StudioStylingQualityControlReshoot"),
    
    STUDIOQUALITYCONTROLSTART("StudioQualityControlStart"),
    
    STUDIOQUALITYCONTROLFINISH("StudioQualityControlFinish"),
    
    STUDIOQUALITYCONTROLRESHOOT("StudioQualityControlReshoot"),
    
    POSTPRODUCTIONSTART("PostProductionStart"),
    
    POSTPRODUCTIONFINISH("PostProductionFinish"),
    
    PHOTOQUALITYCONTROLSTART("PhotoQualityControlStart"),
    
    PHOTOQUALITYCONTROLFINISH("PhotoQualityControlFinish"),
    
    PHOTOQUALITYCONTROLREEDIT("PhotoQualityControlReedit"),
    
    PRODUCTIONITEMVALIDATIONSTART("ProductionItemValidationStart"),
    
    PRODUCTIONITEMVALIDATIONFINISH("ProductionItemValidationFinish");

    private String value;

      OperationEnumEnum(String value) {
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
    public static OperationEnumEnum fromValue(String value) {
      for (OperationEnumEnum b : OperationEnumEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("operation")
  private OperationEnum operation;

  public OperationEnum operation(OperationEnum operation) {
    this.operation = operation;
    return this;
  }

  /**
   * The event being send to the Farfetch platform.
   * @return operation
  */
  @ApiModelProperty(example = "ProductionItemShootingCompleted", required = true, value = "The event being send to the Farfetch platform.")
  @NotNull


  public OperationEnum getOperation() {
    return operation;
  }

  public void setOperation(OperationEnum operation) {
    this.operation = operation;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OperationEnum operationEnum = (OperationEnum) o;
    return Objects.equals(this.operation, operationEnum.operation);
  }

  @Override
  public int hashCode() {
    return Objects.hash(operation);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OperationEnum {\n");
    
    sb.append("    operation: ").append(toIndentedString(operation)).append("\n");
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

