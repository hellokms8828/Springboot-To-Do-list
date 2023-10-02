package com.example.babo.dto;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import lombok.Data;

@Data
public class checkboxDto {
    @NotNull
    private Boolean completed;
}
