package com.spenserca.adventofcode2019.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AdventOfCodeResponse {
    private int year;
    private int day;
    private String part;
    private Object result;
}
