package com.myself.component;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class ComponentImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        List<String> componentClasses = new ArrayList<>();

        // 实际项目中可以使用反射或类路径扫描
        // 这里硬编码示例
        componentClasses.add("property.JwtProperty");

        return new String[0];
    }

}
