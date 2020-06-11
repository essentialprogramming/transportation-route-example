package com.route.model;


import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class City {
    private int id;
    private String name;
    private List<String> neighbours;

}
