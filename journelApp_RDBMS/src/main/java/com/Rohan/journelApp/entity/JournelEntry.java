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
@Document(collection = "journel_entries")
@Data
public class JournelEntry {

    @Id           //unique key
    private ObjectId id;
    @NonNull
    private String title;
    private String content;
    private LocalDateTime date;


}
