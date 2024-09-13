package com.br.marketplacepedido.util;

import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class TransformatorUtil {
    public <I, O> O transformarModelEmRecordDto(I input, String className) {
        try {
            var sourceClass = input.getClass();

            var targetClassType = Class.forName("br.com.dto." + className + "Dto");

            var sourceFieldsMap = Arrays.stream(sourceClass.getDeclaredFields())
                    .collect(Collectors.toMap(Field::getName, Function.identity()));

            var constructors = targetClassType.getConstructors();
            if (constructors.length == 0) {
                throw new IllegalArgumentException("Nenhum construtor encontrado para a classe de registro: " +
                        targetClassType.getName());
            }
            var targetConstructor = constructors[0];

            var args = Arrays.stream(targetConstructor.getParameters())
                    .map(param -> {
                        Field sourceField = sourceFieldsMap.get(param.getName());
                        if (sourceField != null) {
                            sourceField.setAccessible(true);
                            try {
                                return sourceField.get(input);
                            } catch (IllegalAccessException e) {
                                throw new RuntimeException("Falha ao acessar o valor do campo", e);
                            }
                        }
                        return null;
                    })
                    .toArray();

            @SuppressWarnings("unchecked")
            var targetInstance = (O) targetConstructor.newInstance(args);

            return targetInstance;

        } catch (Exception e) {
            throw new RuntimeException("Falha ao transformar objeto", e);
        }
    }
}
