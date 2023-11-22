package com.frequency.characterfrequencyapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@RestController
public class CharacterFrequencyController {
    @PostMapping("/frequency")
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Integer> calculateCharacterFrequency(@RequestBody Map<String, String> request) {
        String inputString = request.get("inputString");

        // Вычисляем частоту, с которой встречаются символы
        Map<String, Integer> charFrequency = inputString.chars()
                .mapToObj(ch -> String.valueOf((char) ch))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(ch -> 1)));

        // Сортируем по убыванию количества вхождений символа
        Map<String, Integer> sortedCharFrequency = charFrequency.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        return sortedCharFrequency;
    }
}
