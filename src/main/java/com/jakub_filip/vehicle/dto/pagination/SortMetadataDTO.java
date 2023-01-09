package com.jakub_filip.vehicle.dto.pagination;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import javax.validation.constraints.NotNull;
import java.util.Objects;

public class SortMetadataDTO {
    @JsonProperty("property")
    private String property;
    @JsonProperty("direction")
    private SortMetadataDTO.DirectionEnum direction;

    public SortMetadataDTO() {
        this.direction = SortMetadataDTO.DirectionEnum.ASC;
    }

    public SortMetadataDTO property(String property) {
        this.property = property;
        return this;
    }

    @NotNull
//    @Schema(
//        name = "property",
//        example = "sort_property",
//        description = "Sort property",
//        required = true
//    )
    public String getProperty() {
        return this.property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public SortMetadataDTO direction(SortMetadataDTO.DirectionEnum direction) {
        this.direction = direction;
        return this;
    }

//    @Schema(
//        name = "direction",
//        description = "Sort order",
//        required = false
//    )
    public SortMetadataDTO.DirectionEnum getDirection() {
        return this.direction;
    }

    public void setDirection(SortMetadataDTO.DirectionEnum direction) {
        this.direction = direction;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            SortMetadataDTO sortMetadata = (SortMetadataDTO)o;
            return Objects.equals(this.property, sortMetadata.property) && Objects.equals(this.direction, sortMetadata.direction);
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.property, this.direction});
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class SortMetadataDTO {\n");
        sb.append("    property: ").append(this.toIndentedString(this.property)).append("\n");
        sb.append("    direction: ").append(this.toIndentedString(this.direction)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return o == null ? "null" : o.toString().replace("\n", "\n    ");
    }

    public static enum DirectionEnum {
        ASC("asc"),
        DESC("desc");

        private String value;

        private DirectionEnum(String value) {
            this.value = value;
        }

        @JsonValue
        public String getValue() {
            return this.value;
        }

        public String toString() {
            return String.valueOf(this.value);
        }

        @JsonCreator
        public static SortMetadataDTO.DirectionEnum fromValue(String value) {
            SortMetadataDTO.DirectionEnum[] var1 = values();
            int var2 = var1.length;

            for(int var3 = 0; var3 < var2; ++var3) {
                SortMetadataDTO.DirectionEnum b = var1[var3];
                if (b.value.equals(value)) {
                    return b;
                }
            }

            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }
    }
}
