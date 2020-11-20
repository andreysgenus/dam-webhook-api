package com.farfetch.nuxeo.service.dam.webhook.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * The base request body.
 */
@ApiModel(parent = RequestBody.class, description = "The AssetPublication request body.")
@JsonPropertyOrder({
        RequestBodyAssetPublication.JSON_PROPERTY_TYPE,
        RequestBodyAssetPublication.JSON_PROPERTY_DATA
})
public class RequestBodyAssetPublication extends RequestBody {

    @JsonProperty("data")
    private AssetPublication data;

    public RequestBodyAssetPublication() {
    }

    public RequestBodyAssetPublication(String type, AssetPublication data) {
        this.type  = type;
        this.data = data;
    }

    public String getInfo() {

        StringBuilder sb = new StringBuilder();
        sb.append("AssetPublication type: " ).append(type);
        sb.append(", digitalAssetsId: ").append(data.getDigitalAssetId());
        sb.append( ", user: ").append(data.getUserId());
        return sb.toString();

    }

    /**
     * The body of the event or command being send to the Farfetch platform.
     *
     * @return data
     */
    @ApiModelProperty(example = "{\"operation\":\"ProductionItemShootingCompleted\",\"date\":\"2017-07-21T17:32:28Z\",\"userId\":\"S-1-5-32-1045337234-12924708993-5683276719-19000\",\"workstationId\":null,\"productId\":23123543,\"productionItemsIds\":[\"5d70e701-d00d-45d8-a9bf-66753bb56b20\"],\"digitalAssetsIds\":[32423432]}", required = true, value = "The body of the event or command being send to the Farfetch platform.")
    @NotNull
    @Valid
    public AssetPublication getData() {
        return data;
    }

    public void setData(AssetPublication data) {
        this.data = data;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RequestBodyAssetPublication requestBody = (RequestBodyAssetPublication) o;
        return Objects.equals(this.type, requestBody.type) &&
                Objects.equals(this.data, requestBody.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, data);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RequestBody {\n");

        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("    data: ").append(toIndentedString(data)).append("\n");
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

