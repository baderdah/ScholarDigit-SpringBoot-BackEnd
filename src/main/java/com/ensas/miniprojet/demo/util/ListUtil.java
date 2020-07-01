package com.ensas.miniprojet.demo.util;

import java.util.List;

public class ListUtil {
    public static boolean isEmptyOrNull(List list){
        return ObjectUtil.isNull(list) || list.size() == 0;
    }
}
