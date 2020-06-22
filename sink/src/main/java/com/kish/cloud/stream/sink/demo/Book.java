package com.kish.cloud.stream.sink.demo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Book {

    private String uuid;
    private String bookName;
    private String authorName;
}
