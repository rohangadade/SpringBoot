package com.Rohan.journelApp.entity;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.*;
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@ToString
//@EqualsAndHashCode
//@Builder
@Data
public class JournelEntry {

    @Id           //unique key
    private ObjectId id;

    private String title;

    private String content;

    private LocalDateTime date;


}
