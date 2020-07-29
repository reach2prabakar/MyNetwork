package com.client.helpers;

import io.restassured.path.json.JsonPath;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Validator {

    public static boolean iterateInList(List<String> list, String toContain, boolean exactMatch) {
        boolean matchFound;
        for (String listItem : list) {
            matchFound = exactMatch ? listItem.toLowerCase().equals(toContain.toLowerCase()) : listItem.contains(toContain);
            if (matchFound) {
                return matchFound;
            }
        }
        return false;
    }

    public static List<List<String>>  listDiffer(List<String> beforeList, List<String> afterList) {
        List<List<String>> var1 = new ArrayList<>();
        beforeList = beforeList.stream().sorted().collect(Collectors.toList());
        afterList = afterList.stream().sorted().collect(Collectors.toList());
        List<String> var2 = afterList;
        var1.add(beforeList.stream().filter(e -> (var2.stream().filter(d -> d.equals(e)).count()) < 1)
                .collect(Collectors.toList()));
        List<String> var3 = beforeList;
        var1.add(afterList.stream().filter(e -> (var3.stream().filter(d -> d.equals(e)).count()) < 1)
                .collect(Collectors.toList()));
        return var1;
    }
}
