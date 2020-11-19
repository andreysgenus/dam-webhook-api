package com.farfetch.nuxeo.service.dam.webhook.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/**
 * The activity log event.
 */
@ApiModel(description = "The activity log event.")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ActivityLog {

    @JsonProperty("digitalAssetsIds")
    @Valid
    private List<Integer> digitalAssetsIds = new ArrayList<Integer>();

    @JsonProperty("reason")
    private String reason;

    /**
     * The event being send to the Farfetch platform.
     */
    public enum OperationEnum {
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

        OperationEnum(String value) {
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
        public static OperationEnum fromValue(String value) {
            for (OperationEnum b : OperationEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }
    }

    @JsonProperty("operation")
    private OperationEnum operation;

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

    public ActivityLog digitalAssetsIds(List<Integer> digitalAssetsIds) {
        this.digitalAssetsIds = digitalAssetsIds;
        return this;
    }

    public ActivityLog addDigitalAssetsIdsItem(Integer digitalAssetsIdsItem) {
        this.digitalAssetsIds.add(digitalAssetsIdsItem);
        return this;
    }

    /**
     * The identification of the digital assets involved in the event.
     *
     * @return digitalAssetsIds
     */
    @ApiModelProperty(example = "[32423432]", required = true, value = "The identification of the digital assets involved in the event.")
    @NotNull
    public List<Integer> getDigitalAssetsIds() {
        return digitalAssetsIds;
    }

    public void setDigitalAssetsIds(List<Integer> digitalAssetsIds) {
        this.digitalAssetsIds = digitalAssetsIds;
    }

    public ActivityLog reason(String reason) {
        this.reason = reason;
        return this;
    }

    /**
     * If the operation is `StudioStylingQualityControlReshoot`, `StudioQualityControlReshoot` or `PhotoQualityControlReedit` this property has to contain the reason.
     *
     * @return reason
     */
    @ApiModelProperty(example = "Not following the guidelines", value = "If the operation is `StudioStylingQualityControlReshoot`, `StudioQualityControlReshoot` or `PhotoQualityControlReedit` this property has to contain the reason.")
    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public ActivityLog operation(OperationEnum operation) {
        this.operation = operation;
        return this;
    }

    /**
     * The event being send to the Farfetch platform.
     *
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

    public ActivityLog date(OffsetDateTime date) {
        this.date = date;
        return this;
    }

    /**
     * The date that the event ocurred on the origin system. Use date-time notation as defined by [RFC 3339, section 5.6](https://tools.ietf.org/html/rfc3339#section-5.6)
     *
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

    public ActivityLog userId(String userId) {
        this.userId = userId;
        return this;
    }

    /**
     * The active directory user's security identifier.
     *
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

    public ActivityLog workstationId(String workstationId) {
        this.workstationId = workstationId;
        return this;
    }

    /**
     * The identification of the physical workstation where the user made the action. *The property is required but it can be* `null`.
     *
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

    public ActivityLog productId(Integer productId) {
        this.productId = productId;
        return this;
    }

    /**
     * The identification of the product involved in the event.
     *
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

    public ActivityLog productionItemsIds(List<UUID> productionItemsIds) {
        this.productionItemsIds = productionItemsIds;
        return this;
    }

    public ActivityLog addProductionItemsIdsItem(UUID productionItemsIdsItem) {
        this.productionItemsIds.add(productionItemsIdsItem);
        return this;
    }

    /**
     * The identification of the production items involved in the event.
     *
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
        ActivityLog activityLog = (ActivityLog) o;
        return Objects.equals(this.digitalAssetsIds, activityLog.digitalAssetsIds) &&
                Objects.equals(this.reason, activityLog.reason) &&
                Objects.equals(this.operation, activityLog.operation) &&
                Objects.equals(this.date, activityLog.date) &&
                Objects.equals(this.userId, activityLog.userId) &&
                Objects.equals(this.workstationId, activityLog.workstationId) &&
                Objects.equals(this.productId, activityLog.productId) &&
                Objects.equals(this.productionItemsIds, activityLog.productionItemsIds);
    }

    @Override
    public int hashCode() {
        return Objects.hash(digitalAssetsIds, reason, operation, date, userId, workstationId, productId, productionItemsIds);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ActivityLog {\n");

        sb.append("    digitalAssetsIds: ").append(toIndentedString(digitalAssetsIds)).append("\n");
        sb.append("    reason: ").append(toIndentedString(reason)).append("\n");
        sb.append("    operation: ").append(toIndentedString(operation)).append("\n");
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

