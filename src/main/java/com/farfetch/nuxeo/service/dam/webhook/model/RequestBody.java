package com.farfetch.nuxeo.service.dam.webhook.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;

/**
 * The base request body.
 */
@ApiModel(subTypes = {RequestBodyAssetPublication.class, RequestBodyActivityLog.class}, discriminator = "type", description = "The base request body.")
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({@JsonSubTypes.Type(value = RequestBodyAssetPublication.class, name = "AssetUnpublished"),
        @JsonSubTypes.Type(value = RequestBodyAssetPublication.class, name = "AssetPublished"),
        @JsonSubTypes.Type(value = RequestBodyActivityLog.class, name = "ActivityLog")})
public abstract class RequestBody {

    public static final String JSON_PROPERTY_TYPE = "type";

    public static final String JSON_PROPERTY_DATA = "data";

    //@JsonProperty("type")
    protected String type;

    public abstract String getInfo();

    /**
     * The type of command or event being send to the Farfetch platform.
     *
     * @return type
     */
    //@ApiModelProperty(example = "ActivityLog", required = true, value = "The type of command or event being send to the Farfetch platform.")
    //@NotNull
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    /**
     * The type of command or event being send to the Farfetch platform.
     */
    public enum TypeEnum {

        ACTIVITYLOG("ActivityLog"),

        ASSETPUBLISHED("AssetPublished"),

        ASSETUNPUBLISHED("AssetUnpublished");

        private String value;

        TypeEnum(String value) {
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
        public static TypeEnum fromValue(String value) {
            for (TypeEnum b : TypeEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }
    }
}

