package com.jiraws.library.book.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

public class BookDTO {
    
    @Builder
    @AllArgsConstructor
    @Data
    public static class PostInput {
        @NotNull @NotBlank
        String bookName;
        @NotNull
        Integer bookPages;
    }

    @Builder
    @AllArgsConstructor
    @Data
    public static class PostOutput {
        Long id;
        String bookName;
        Integer bookPages;        
    }

}
