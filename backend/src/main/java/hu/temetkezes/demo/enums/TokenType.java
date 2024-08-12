package hu.temetkezes.demo.enums;

import hu.temetkezes.demo.domain.TokenData;
import lombok.Getter;

@Getter
public enum TokenType {
    ACCESS("access-token"),REFRESH("refresh-token");
    private final String value;
    TokenType(String value) {this.value = value;}


}
