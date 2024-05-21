/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.tomcat.util.buf;

import java.util.Arrays;
import java.util.Collection;
import java.util.function.Function;

/**
 * Utility methods to build a separated list from a given set (not java.util.Set) of inputs and return that list as a
 * string or append it to an existing StringBuilder. If the given set is null or empty, an empty string will be
 * returned.
 */
public final class StringUtils {

    private static final String EMPTY_STRING = "";

    private StringUtils() {
        // Utility class
    }

    /*
    //@ ensures \result.length() >= a.length() || \result.length() >= b.length();
    //@ ensures (\exists int i; 0 <= i && i <= \result.length() - a.length(); \result.substring(i, i + a.length()).equals(a));
    //@ ensures (\exists int i; 0 <= i && i <= \result.length() - b.length(); \result.substring(i, i + b.length()).equals(b));
    */
    public static String join(String a, String b) {
        return join(new String[] { a, b });
    }
    /*
    // @ requires array != null;
    // @ ensures \result != null;
    // @ ensures \result.length() == 0 || array.length > 0;
    */
    public static String join(String[] array) {
        if (array == null) {
            return EMPTY_STRING;
        }
        
        return join(Arrays.asList(array));
    }


    public static void join(String[] array, char separator, StringBuilder sb) {
        if (array == null) {
            return;
        }
        join(Arrays.asList(array), separator, sb);
    }


    public static String join(Collection<String> collection) {
        return join(collection, ',');
    }


    public static String join(Collection<String> collection, char separator) {
        // Shortcut
        if (collection == null || collection.isEmpty()) {
            return EMPTY_STRING;
        }

        StringBuilder result = new StringBuilder();
        join(collection, separator, result);
        return result.toString();
    }


    public static void join(Iterable<String> iterable, char separator, StringBuilder sb) {
        join(iterable, separator, (x) -> x, sb);
    }


    public static <T> void join(T[] array, char separator, Function<T,String> function, StringBuilder sb) {
        if (array == null) {
            return;
        }
        join(Arrays.asList(array), separator, function, sb);
    }

  
    public static <T> void join(Iterable<T> iterable, char separator, Function<T,String> function, StringBuilder sb) {
        if (iterable == null) {
            return;
        }
        boolean first = true;
        for (T value : iterable) {
            if (first) {
                first = false;
            } else {
                sb.append(separator);
            }
            sb.append(function.apply(value));
        }
    }

    /**
     * Splits a comma-separated string into an array of String values.
     *
     * Whitespace around the commas is removed.
     *
     * Null or empty values will return a zero-element array.
     *
     * @param s The string to split by commas.
     *
     * @return An array of String values.
     
    // @ requires s.trim().length() > 0;
    // @ ensures \result.length <= s.length();
    // @ ensures (\forall int i; 0 <= i && i < \result.length; \result[i] != null && \result[i].trim().equals(\result[i]));
    */
    public static String[] splitCommaSeparated(String s) {
        if (s == null || s.length() == 0) {
            return new String[0];
        }
        
        String[] splits = s.split(",");
        /*
         // @ maintaining 0 <= i && i <= splits.length;
         // @ maintaining (\forall int j; 0 <= j && j < i; splits[j] != null && splits[j].trim().equals(splits[j]));
         // @ decreases splits.length - i;
         */
        for (int i = 0; i < splits.length; ++i) {
            splits[i] = splits[i].trim();
        }

        return splits;
    }
}

/**
 * Archivo de recurso
 * 
 * [ ] 5/8 postcondiciones // @ ensures
 * [ ] 2/8 precondiciones
 * [ ] 0/4 invariantes
 * [ ] 0/4 aserciones
 * [ ] 1/2 Ciclos (En caso de no haber) hacer dos más en las anteriores
 * 
 * Preguntas
 * ¿Por qué si uno lo corre con -esc da más errores? ¿Podríamos correrlo sin eso?
 * ¿Si es una biblioteca de stringUtils, cómo podemos garantizar el fundamento en el RFC?
 * ¿Cuentan las precondiciones y postcondiciones repetidas? a!= null
 */