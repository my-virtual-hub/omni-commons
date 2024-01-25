/*
 * Copyright 2024 My Virtual Hub
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package br.com.myvirtualhub.omni.commons.scanner;

import br.com.myvirtualhub.omni.commons.annotations.Initializer;
import br.com.myvirtualhub.omni.commons.annotations.InitializerMethod;
import br.com.myvirtualhub.omni.commons.exceptions.ScannerException;
import com.google.common.reflect.ClassPath;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * The Scanner class provides utility methods for scanning and initializing classes using custom annotations.
 */
public class Scanner {

    /**
     * The PACKAGE_PREFIX variable holds the package prefix used by the Scanner class to scan and initialize classes.
     */
    private static final String PACKAGE_PREFIX = "br.com.myvirtualhub.omni";

    private Scanner() {
        // Utility class
    }

    /**
     * This method initializes classes using custom annotations by scanning for initializer classes and methods.
     * It scans all classes in the package with the prefix "br.com.myvirtualhub.omni" and filters classes
     * annotated with @Initializer. It then scans for methods annotated with @InitializerMethod and executes
     * them.
     *
     * @throws ScannerException if there is an error during scanning or executing initializer methods
     */
    public static void scanningInitializer() throws ScannerException {
        final Set<Class<?>> initializerClasses;
        initializerClasses = scanInitializerClasses();
        final Set<Method> initializerMethods = scanInitializerMethods(initializerClasses);
        executeInitializerMethods(initializerMethods);
    }

    private static Set<Class<?>> scanInitializerClasses() throws ScannerException {
        try {
            return ClassPath.from(ClassLoader.getSystemClassLoader())
                    .getAllClasses()
                    .stream()
                    .filter(clazz -> clazz.getPackageName().startsWith(PACKAGE_PREFIX))
                    .map(ClassPath.ClassInfo::load)
                    .filter(clazz -> clazz.isAnnotationPresent(Initializer.class))
                    .collect(Collectors.toSet());
        } catch (IOException e) {
            throw new ScannerException("Error when scan initializing classes", e.getMessage());
        }
    }


    private static Set<Method> scanInitializerMethods(final Set<Class<?>> initializerClasses) {
        return initializerClasses.stream()
                .map(Class::getDeclaredMethods)
                .flatMap(Arrays::stream)
                .filter(method -> method.isAnnotationPresent(InitializerMethod.class))
                .filter(method -> method.getParameterCount() == 0)
                .filter(method -> Modifier.isStatic(method.getModifiers()))
                .collect(Collectors.toSet());
    }

    private static void executeInitializerMethods(Set<Method> initializerMethods) throws ScannerException {
        for (Method method : initializerMethods) {
            try {
                method.invoke(null, (Object[])null);
            } catch (IllegalAccessException | InvocationTargetException e) {
                throw new ScannerException("Error when executing initializer methods", e.getMessage());
            }
        }
    }
}
